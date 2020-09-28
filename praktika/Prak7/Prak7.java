package praktika.Prak7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Prak7 extends JFrame {
    private Player player1 = new Player();
    private Player player2 = new Player();
    private static ImageIcon[] images;
    private static JLabel cards_1, cards_2, space_1, space_2, endgame;
    private static JButton simulate;
    private static Game game = new Game();
    private int turns = 0;

    private String check_game(){
        if (player1.isEmpty()) {
            return ("Первый игрок победил. Ходы: " + (turns+1));
        } else if (player2.isEmpty()) {
            return ("Второй игрок победил. Ходы: " + (turns+1));
        } else if (turns == 106)
            return "Ботва!";
        return "";
    }

    private void init(){
        simulate = new JButton();
        simulate.setText("Simulate");
        simulate.setBounds(900,50,100,100);
        simulate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                endgame.setText(game.simulate(player1,player2, turns));
            }
        });

        cards_1 = new JLabel();
        cards_1.setIcon(images[10]);
        cards_1.setBounds(100,20,images[10].getIconWidth(),images[10].getIconHeight());

        cards_2 = new JLabel();
        cards_2.setIcon(images[11]);
        cards_2.setBounds(900,350,images[11].getIconWidth(),images[11].getIconHeight());
        cards_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                space_1.setIcon(images[player1.peek_card()]);
                space_2.setIcon(images[player2.peek_card()]);
                turns = game.upd_turn(player1,player2,turns);
                endgame.setText(check_game());
            }
        });

        space_1 = new JLabel();
        space_1.setIcon(images[12]);
        space_1.setBounds(510,200,images[12].getIconWidth(),images[12].getIconHeight());

        space_2 = new JLabel();
        space_2.setBounds(560,200,images[0].getIconWidth(),images[0].getIconHeight());

        endgame = new JLabel();
        endgame.setBounds(100,500,800,50);
        Font labelFont = endgame.getFont();
        String labelText = endgame.getText();

        int stringWidth = endgame.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = endgame.getWidth();
        double widthRatio = (double)componentWidth / (double)stringWidth; // scale
        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = endgame.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight); // Размер не более высоты (должен влезть)
        endgame.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse)); // установка размера
    }

    public Prak7() {
//        super("Card Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] ids = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "rubashka_3", "rubashka_3_rev", "space" };
        images = load_pics(ids);
        Color myGreen = new Color(7, 163, 33);

        setLayout(null);
        setResizable(false);
        getContentPane().setBackground( myGreen );
        JPanel panel = new JPanel();
        init();
        setSize(1200,700);

        add(cards_1);
        add(cards_2);
        add(space_2);
        add(space_1);
        add(endgame);
        add(simulate);
        setVisible(true);
    }


    public ImageIcon[] load_pics(String[] ids){
        BufferedImage[] images = new BufferedImage[ids.length];
        ImageIcon[] pic = new ImageIcon[ids.length];
        for(int j = 0; j < images.length; j++) {
            String path = "res/" + ids[j] + ".png";
            try {
                images[j] = ImageIO.read(Prak7.class.getResourceAsStream(path));
                pic[j] = new ImageIcon(images[j]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pic;
    }

    public static void main(String[] args) throws IOException {
        Prak7 prak = new Prak7();
        //9 8 7 6 5 0 1 2 3 4
    }
}
