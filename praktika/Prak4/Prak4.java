package rtu.IT.IKBO_06_19.Vizer.praktika.Prak4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prak4 extends JFrame {
    private int milan =0;
    private int madrid =0;
    private boolean scored = false;

    JButton team1 = new JButton("AC Milan");
    JButton team2 = new JButton("Real Madrid");
    JLabel score = new JLabel("Result 0 X 0");
    JLabel last_scorer = new JLabel("Last Scorer: N/A");
    JLabel res = new JLabel("Winner: DRAW");
    Prak4(){
        super("Football");
        setSize(250,150);
        setLayout(new FlowLayout());
        add(team1);
        add(team2);
        add(score);
        add(last_scorer);
        add(res);
        team1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                milan++;
                scored = false;
                upd();
            }
        });
        team2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                madrid++;
                scored = true;
                upd();
            }
        });
        setVisible(true);
    }
    public void upd(){
        score.setText("Result " + milan + " X " + madrid);
        last_scorer.setText("Last Scorer: " + ((scored == false) ? "Milan" : "Madrid"));
        res.setText("Winner: " + ((milan>madrid) ? "Milan" : (milan == madrid) ? "Draw" : "Madrid"));
    }

    public static void main(String[] args) {
        Prak4 prak4 = new Prak4();
    }
}

