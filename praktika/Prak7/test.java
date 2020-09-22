package praktika.Prak7;

import praktika.test.Application;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class test extends JFrame {

    BufferedImage image;

    public test() {
        this.setSize(1000,700);
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        try {
            image = ImageIO.read(Application.class.getResourceAsStream("res/rubashka_3.png"));
        } catch (IOException ex) {
            System.err.println("Oh noes, gimme a pic");
        }
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel();
        label.setIcon(icon);
        panel.add(label);
        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        test t = new test();
    }
}
