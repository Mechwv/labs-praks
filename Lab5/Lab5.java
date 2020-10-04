package Lab5;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Lab5 extends JFrame {

    private BufferedImage image;
    public static Scanner scanner = new Scanner(System.in);
    public Lab5() {
        super("Pic");
        this.setSize(500,640);
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        String name;
        System.out.println("Введите название файла и его формат: example(Kek.png)");
        name = scanner.nextLine();
        try {
            image = ImageIO.read(Lab5.class.getResourceAsStream(name));
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
        Lab5 l = new Lab5();
    }
}