package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lab6 extends JFrame implements MouseListener {
    //adding best looking text 4 area (lul)
    JButton north = new JButton("NORTH");
    JButton south = new JButton("SOUTH");
    JButton west = new JButton("WEST");
    JButton east = new JButton("EAST");
    JButton center = new JButton("CENTER");
    public Lab6() {
        //basic parameters & layout
        super("Borders");
        setLayout(new BorderLayout());
        setSize(600,400);
        //providing good looking text
        add(west,BorderLayout.WEST);
        add(south,BorderLayout.SOUTH);
        add(north,BorderLayout.NORTH);
        add(east,BorderLayout.EAST);
        add(center,BorderLayout.CENTER);
        //disabling
        west.setEnabled(false);
        south.setEnabled(false);
        north.setEnabled(false);
        east.setEnabled(false);
        center.setEnabled(false);
        //listeners
        west.addMouseListener(this);
        south.addMouseListener(this);
        north.addMouseListener(this);
        east.addMouseListener(this);
        center.addMouseListener(this);

        setVisible(true);
    }
    public static void main(String[] args) {
        Lab6 l = new Lab6();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        String response = "";
        Object source = e.getSource();
        if (north.equals(source)) {
            response = "Добро пожаловать в";
        } else if (center.equals(source)) {
            response = "Добро пожаловать в";
        } else if (south.equals(source)) {
            response = "Добро пожаловать в Абха";
        } else if (west.equals(source)) {
            response = "Добро пожаловать в Джидда";
        } else if (east.equals(source)) {
            response = "Добро пожаловать в Дахране";
        }
        JOptionPane.showMessageDialog(null, response);
    }
    @Override
    public void mouseExited(MouseEvent e) {}
}
