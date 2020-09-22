package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab6_1 extends JFrame {
    //adding best looking text 4 area (lul)
    JButton north = new JButton("NORTH");
    JButton south = new JButton("SOUTH");
    JButton west = new JButton("WEST");
    JButton east = new JButton("EAST");
    JButton center = new JButton("CENTER");
    public Lab6_1() {
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
        west.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JOptionPane.showMessageDialog(null, "Добро пожаловать в Джидда");
            }
        });
        south.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JOptionPane.showMessageDialog(null, "Добро пожаловать в Абха");
            }
        });
        north.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JOptionPane.showMessageDialog(null, "Добро пожаловать в");
            }
        });
        east.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JOptionPane.showMessageDialog(null, "Добро пожаловать в Дахране");
            }
        });
        center.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JOptionPane.showMessageDialog(null, "Добро пожаловать в ");
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        Lab6 l = new Lab6();
    }
}
