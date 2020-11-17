package Lab16.obolochka;

import Lab16.*;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class OrderUpdater {
    public Customer customer;
    private Order order;
    private JLabel orderInfo;
    private JSpinner[] drinksSpinner;


    String regex = "^[a-zA-Z]+$";
    String regex1 = "^\\d.*$";
    Pattern text = Pattern.compile(regex);
    Pattern num = Pattern.compile(regex1);


    public OrderUpdater() {

    }

    public boolean firstReg(JPanel p){
        String[] fReg = new String[3];
        int i = 0;
        boolean check = true;
        for (Component jc : p.getComponents()) {
            if ( jc instanceof JTextField ) {
                String info = ((JTextField) jc).getText();
                if (info.equals(""))
                    check = false;
                fReg[i] = info;
                i++;
            }
        }
        if (check) {
            try {
                if ((num.matcher(fReg[2]).find()) && (Integer.parseInt(fReg[2]) > 5)) {
                    if ((text.matcher(fReg[0]).find()) && (text.matcher(fReg[1]).find()) && (fReg[0].length() > 2) && (fReg[1].length() > 2)) {
                        customer = new Customer(fReg[0], fReg[1], Integer.parseInt(fReg[2]), Address.EMPTY_ADDRESS);
                        return true;
                    } else
                        JOptionPane.showMessageDialog(p, "Invalid first or second name !");
                } else
                    JOptionPane.showMessageDialog(p, "Invalid age!");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(p, "Invalid character!");
            }
        }
        else
            JOptionPane.showMessageDialog(p, "Please fill info!");
        return false;
    }

    public boolean secondReg(JPanel p){
        String[] fReg = new String[6];
        int i = 0;
        boolean check = true;
        for (Component jc : p.getComponents()) {
            if ( jc instanceof JTextField ) {
                String info = ((JTextField) jc).getText();
                if (info.equals(""))
                    check = false;
                fReg[i] = info;
                i++;
            }
        }
        if (check){
            try {
                if (num.matcher(fReg[1]).find()){
                    if (num.matcher(fReg[3]).find()){
                        if ((text.matcher(fReg[4]).find()) && (fReg[4].length() == 1)){
                            if(num.matcher(fReg[5]).find()){
                                customer.setAddress(new Address(fReg[0], Integer.parseInt(fReg[1]), fReg[2], Integer.parseInt(fReg[3]), fReg[4].charAt(0), Integer.parseInt(fReg[5])));
                                return true;
                            }
                            else
                                JOptionPane.showMessageDialog(p, "Invalid flat number!");
                        }
                        else
                            JOptionPane.showMessageDialog(p, "Invalid building letter!");
                    }
                    else
                        JOptionPane.showMessageDialog(p, "Invalid building number!");
                }
                else
                    JOptionPane.showMessageDialog(p, "Invalid zip!");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(p, "Invalid character!");
            }

        }
        return false;
    }

    public void addOrder(Order order, JSpinner[] drinksSpinner){
        this.order = order;
        this.drinksSpinner = drinksSpinner;
    }

    public void setOrderInfoText() {
        if (order == null)
            orderInfo.setText("<html>Total items: 0<br/>Total cost: 0 </html>");
        else
            orderInfo.setText("<html>Total<br/>items:" + order.itemsQuantity() + "<br/>Total<br/>cost:" + order.costTotal() + "</html>");
    }

    public void setOrderInfo(JLabel j){
        orderInfo = j;
    }

    public Order getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }
}
