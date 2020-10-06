package praktika.Prak9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class LabClassUI extends JFrame {
    private JPanel topPanel;
    private JPanel btnPanel;
    private JPanel DBPanel;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    public LabClassUI(){
        super("Students");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,700);
        setLayout (new BorderLayout());
        topPanel = new JPanel();
        topPanel = new JPanel();
        btnPanel = new JPanel();
        DBPanel = new JPanel();
        DBPanel.setLayout(new BorderLayout());
        topPanel.setLayout(new GridLayout(3, 2, 5, 12));

        add(topPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
        add(DBPanel, BorderLayout.SOUTH);

        JLabel id = new JLabel("ID",JLabel.CENTER);
        JLabel fio = new JLabel("FIO",JLabel.CENTER);
        JLabel gpa = new JLabel("GPA",JLabel.CENTER);
        JTextField id_field = new JTextField();
        JTextField fio_field = new JTextField();
        JTextField gpa_field = new JTextField();

        topPanel.add(id);
        topPanel.add(id_field);
        topPanel.add(fio);
        topPanel.add(fio_field);
        topPanel.add(gpa);
        topPanel.add(gpa_field);

        tableModel = new DefaultTableModel(){
            final String[] student = {"ID", "F.I.O", "GPA"};
            @Override
            public int getColumnCount() {
                return student.length;
            }

            @Override
            public String getColumnName(int index) {
                return student[index];
            }
        };
        DBdriver dbdriver = new DBdriver(tableModel);
        JTable table = new JTable(tableModel);
        table.getTableHeader().setReorderingAllowed(false);


        scrollPane = new JScrollPane(table);
        DBPanel.add(scrollPane,BorderLayout.CENTER);
        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    dbdriver.add(Integer.parseInt(id_field.getText()), fio_field.getText(), Double.parseDouble(gpa_field.getText()));
                } catch (NumberFormatException n){
                    System.err.println("wrong ID or GPA");
                }
                id_field.setText("");
                fio_field.setText("");
                gpa_field.setText("");
            }
        });
        JButton findButton = new JButton("FIND");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dbdriver.find(fio_field.getText());
            }
        });
        JButton sortButton = new JButton("SORT");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dbdriver.sort();
            }
        });
        btnPanel.add(addButton);
        btnPanel.add(findButton);
        btnPanel.add(sortButton);
        pack();
        setVisible(true);


    }
    public static void main(String[] args) {
        LabClassUI UI = new LabClassUI();
    }
}
