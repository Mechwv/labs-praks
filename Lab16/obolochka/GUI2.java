package Lab16.obolochka;

import Lab16.*;
import Lab16.MenuItem;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class GUI2 extends JFrame{
    protected CardLayout card;
    protected Container c;
    protected JFrame frame;
    protected OrderUpdater OU;
    protected InternetOrdersManager IOM = new InternetOrdersManager();
    protected TableOrdersManager TOM = new TableOrdersManager();
    protected JPanel allOrders;
    protected TM tm;
    protected int table = 0;
    protected boolean BAR = false;
    GUI2(){
        super("BAR");
        frame = this;
        restart();
    }

    private void restart(){
        if (c!=null)
            c.removeAll();
        c=frame.getContentPane();
        card=new CardLayout(40,30); //create CardLayout object with 40 hor space and 30 ver space
        c.setLayout(card);

        JPanel main = firstPanel();
        JPanel panel2 = secondPanel();

        c.add("1", main);
        c.add("2", panel2);
    }

    private JPanel firstPanel(){
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JComponent panel1 = makeTextPanel("Please enter your info");

        JButton bok = new JButton("OK");
        JPanel p = new JPanel(new SpringLayout());

        String[] labelz = {"First Name: ", "Second Name: ", "Age: "};
        int numPairs = labelz.length;
        p.setMaximumSize(new Dimension(300,120));
        for (String s : labelz) {
            JLabel l = new JLabel(s, JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
        }
        bok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean check = OU.firstReg(p);
                if (check)
                    switchPanel();
            }
        });
        bok.setMaximumSize(new Dimension(200,300));
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);

        bok.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(panel1);
        main.add((Box.createRigidArea(new Dimension(1,50))));
        main.add(p);
        main.add((Box.createRigidArea(new Dimension(1,100))));
        main.add(bok);
        main.add((Box.createRigidArea(new Dimension(1,200))));
        return main;
    }

    private JPanel secondPanel(){
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JComponent panel2 = makeTextPanel("Please choose your order type");

        JPanel btns = new JPanel();
        btns.setLayout(new BoxLayout(btns, BoxLayout.X_AXIS));
        JButton table = new JButton("TABLE");
        table.setMaximumSize(new Dimension(300,200));
        table.setFont(new Font("Serif", Font.PLAIN, 30));
        table.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BAR = true;
                JPanel panel3 = tablePanel();
                JPanel panel4 = orderPanel();
                c.add("3", panel3);
                c.add("4", panel4);
                switchPanel();
            }
        });
        JButton internet = new JButton("INTERNET");
        internet.setFont(new Font("Serif", Font.PLAIN, 30));
        internet.setMaximumSize(new Dimension(300,200));
        internet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BAR = false;
                JPanel panel3 = internetPanel();
                JPanel panel4 = orderPanel();
                c.add("3", panel3);
                c.add("4", panel4);
                switchPanel();
            }
        });

        btns.add(table);
        btns.add(internet);
        main.add(panel2);
        main.add(btns);

        return main;
    }

    private JPanel tablePanel(){
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        JComponent text = makeTextPanel("Please choose a table");
        String[] tables = {"1", "2", "3", "4"};
        JComboBox comboBox = new JComboBox(tables);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JComboBox box = (JComboBox)actionEvent.getSource();
                try {
                    table = Integer.parseInt((String) Objects.requireNonNull(box.getSelectedItem()));
                    TOM.add(table);
                    switchPanel();
                } catch (OrderAlreadyAddedException e) {
                    if (TOM.freeTableNumbers().length == 0){
                        JOptionPane.showMessageDialog(main, "No free tables!");
                        restart();
//                        switchPanel();
                    }
                    else
                        JOptionPane.showMessageDialog(main, "Table has an order!");
                }
            }
        });
        main.add((Box.createRigidArea(new Dimension(1,100))));
        main.add(text);
        main.add((Box.createRigidArea(new Dimension(1,100))));
        main.add(comboBox);
        main.add((Box.createRigidArea(new Dimension(1,400))));
        return main;
    }

    private JPanel internetPanel(){
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JComponent panel1 = makeTextPanel("Please enter your info");

        JButton bok = new JButton("OK");
        JPanel p = new JPanel(new SpringLayout());

        String[] labelz = {"City: ", "Zip code: ", "Street: ", "Building №: ", "Building letter: ", "Flat: "};
        int numPairs = labelz.length;
        p.setMaximumSize(new Dimension(300,120));
        for (String s : labelz) {
            JLabel l = new JLabel(s, JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
        }
        bok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean check = OU.secondReg(p);
                if (check) {
                    switchPanel();
                }
            }
        });
        bok.setMaximumSize(new Dimension(200,300));
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);

        bok.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(panel1);
        main.add((Box.createRigidArea(new Dimension(1,50))));
        main.add(p);
        main.add((Box.createRigidArea(new Dimension(1,50))));
        main.add(bok);
        main.add((Box.createRigidArea(new Dimension(1,200))));
        return main;
    }

    private JPanel orderPanel(){
        JSpinner[] drinksSpinner;
        int[] drinksCnt;
        Drink[] drinks;
        Order order;
        if (!BAR)
            order = new InternetOrder(new MenuItem[0]);
        else
            order = new TableOrder(table);
        JLabel orderInfo = new JLabel();
        orderInfo.setFont(new Font("Serif", Font.PLAIN, 48));

        JPanel main = new JPanel();
        JPanel orders = new JPanel(new SpringLayout());
        JPanel btns = new JPanel();
        btns.setLayout(new BoxLayout(btns, BoxLayout.Y_AXIS));

        OU.setOrderInfo(orderInfo);
        orderInfo.setText("<html>Total<br/> items: 0<br/>Total<br/> cost: 0 </html>");


        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));

        DrinkTypeEnum[] drinksEnum = DrinkTypeEnum.values();
        JLabel[] labels = new JLabel[drinksEnum.length];

        drinksSpinner = new JSpinner[drinksEnum.length];
        drinksCnt = new int[drinksEnum.length];
        drinks = new Drink[drinksEnum.length];
        for (int i = 0; i < drinksEnum.length; i++) {
            drinksCnt[i] = 0;
            drinks[i] = drinksEnum[i].getValue();
            labels[i] = new JLabel(drinks[i].getName());
            orders.add(labels[i]);
            drinksSpinner[i] = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
            drinksSpinner[i].setToolTipText(labels[i].getToolTipText());
            int finalI = i;
            int finalI1 = i;
            drinksSpinner[i].addChangeListener(changeEvent -> {
                if ((drinks[finalI1].getAlcoholVol() > 0) && (OU.getCustomer().getAge() < 18)) {
                    if (drinksSpinner[finalI1].isEnabled()) {
                        drinksSpinner[finalI1].setEnabled(false);
                        drinksSpinner[finalI1].setValue(-1);
                        JOptionPane.showMessageDialog(main, "U R 2 young cowboy!");
                    }
                }
                else {
                    int diff = (int) drinksSpinner[finalI].getValue() - drinksCnt[finalI];
                    while (diff > 0) {
                        OU.getOrder().add(drinks[finalI]);
                        diff--;
                    }
                    while (diff < 0) {
                        OU.getOrder().remove(drinks[finalI]);
                        diff++;
                    }
                    drinksCnt[finalI] = (int) drinksSpinner[finalI].getValue();
                    OU.setOrderInfoText();
                }
            });
            orders.add(drinksSpinner[i]);
        }
        OU.addOrder(order, drinksSpinner);
        SpringUtilities.makeCompactGrid(orders,
                drinksEnum.length, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);

        JButton addOrder = new JButton("ADD ORDER");
        addOrder.setFont(new Font("Serif", Font.PLAIN, 20));
        addOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    try {
                        if (OU.getOrder().itemsQuantity() > 0) {
                            if (!BAR) {
                                System.out.println(OU.getCustomer().getAddress().toString());
                                OU.getOrder().setCustomer(OU.getCustomer());
                                IOM.add(OU.getOrder());
                            }
                            else {
                                System.out.println(table);
                                TOM.add((TableOrder) OU.getOrder(), table);
                            }
                            JPanel panel5 = orders();
                            c.add("orders", panel5);
                            switchPanel();
                        }
                        else
                            JOptionPane.showMessageDialog(main, "Choose something!");
                    } catch (NullPointerException e){
                        JOptionPane.showMessageDialog(main, "ERROR!");
                    }
                } catch (OrderAlreadyAddedException e) {
                    JOptionPane.showMessageDialog(main, e.getMessage());
                    restart();
//                    switchPanel();
            }
            }
        });
        btns.add(orderInfo);
        btns.add((Box.createRigidArea(new Dimension(1,100))));
        btns.add(addOrder);

        main.add(orders);
        main.add((Box.createRigidArea(new Dimension(100,1))));
        JTable t = pricelist();

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(t.getTableHeader());
        p.add(t);

        main.add(p);
        main.add((Box.createRigidArea(new Dimension(100,1))));
        main.add(btns);
        main.add((Box.createRigidArea(new Dimension(50,1))));
        return main;
    }

    private JTable pricelist(){
        String[] columnNames = {"Name", "Alcohol Vol", "Cost"};
        TM tableModel = new TM(columnNames, 0);
        JTable table = new JTable(tableModel);

        table.setFont(new Font("Serif", Font.PLAIN, 28));
        table.setRowHeight(25);

        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDragEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);

        DrinkTypeEnum[] drinksEnum = DrinkTypeEnum.values();
        Drink drink;

        Object[] row = new Object[3];

        for (DrinkTypeEnum typeEnum : drinksEnum) {
            drink = typeEnum.getValue();
            row[0] = drink.getName();
            row[1] = drink.getAlcoholVol();
            row[2] = drink.getCost();
            tableModel.addRow(row);
        }
        return table;
    }

    private JPanel orders(){
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));

        JPanel btns = new JPanel();
        btns.setLayout(new BoxLayout(btns, BoxLayout.Y_AXIS));


        JButton newOrder = new JButton("NEW ORDER");
        JButton delete = new JButton("DELETE");

        JTable t = allOrdersTable();


        newOrder.setFont(new Font("Serif", Font.PLAIN, 28));
        delete.setFont(new Font("Serif", Font.PLAIN, 28));
        newOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                restart();
//                switchPanel();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int orderRow = getSelectedOrderRow(t);
                if (orderRow != -1) {
                    String type = (String) t.getValueAt(orderRow, 0);
                    if (type.equals("INTERNET")) {
                        String[] adr = ((String) t.getValueAt(orderRow, 1)).split(", ");
                        Address address = new Address(adr[0], Integer.parseInt(adr[1]), adr[2], Integer.parseInt(adr[3]), adr[4].charAt(0), Integer.parseInt(adr[5]));
                        IOM.remove(address);
                    } else {
                        Object object = t.getValueAt(orderRow, 1);
                        TOM.remove((int) object);
                    }
                    tm.removeRow(orderRow);
                    JOptionPane.showMessageDialog(main, "Ok ");
                }
            }
        });
        btns.add(newOrder);
        btns.add(Box.createRigidArea(new Dimension(1,50)));
        btns.add(delete);

        JScrollPane scrollPane = new JScrollPane(t);
        main.add(t.getTableHeader());
        main.add(scrollPane);
        main.add((Box.createRigidArea(new Dimension(50,1))));
        main.add(btns);
        return main;
    }

    private int getSelectedOrderRow(JTable table) {
        if (table.getSelectedRowCount() == 1)
            return table.getSelectedRow();
        else
            JOptionPane.showMessageDialog(this, "No order selected!");
        return -1;
    }

    private JTable allOrdersTable(){
        String[] columnNames = {"Type", "Client/Table", "Drinks", "Cost"};
        tm = new TM(columnNames, 0);
        JTable table = new JTable(tm);

        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.setRowHeight(20);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(250);

        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDragEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        Order[] Iorders;
        try {
            Iorders = IOM.getOrders();
        } catch (NullPointerException e){
            Iorders = new InternetOrder[0];
        }

        Object[] row = new Object[4];
        for (int i = 0; i < Iorders.length; i++) {
            row[0] = Iorders[i].getType();
            row[1] = Iorders[i].getCustomer().getAddress().toString();
            row[2] = Iorders[i].getItems().length;
            row[3] = Iorders[i].costTotal();
            tm.addRow(row);
        }

        TableOrder[] Torders = TOM.getOrders();
        for (int i = 0; i < Torders.length; i++) {
            TableOrder t = Torders[i];
            row[0] = t.getType();
            row[1] = t.getTable();
            row[2] = t.getItems().length;
            row[3] = t.costTotal();
            tm.addRow(row);
            }
        return table;
    }

    private void start(){
        OU = new OrderUpdater();

//        frame.setSize(700,480);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected void switchPanel(){
        c = frame.getContentPane();
        card.next(c);
        frame.repaint();
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setFont(new Font("Serif", Font.PLAIN, 48));
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public static void main(String[] args) {
        GUI2 cl = new GUI2();
        cl.start();
    }
}
