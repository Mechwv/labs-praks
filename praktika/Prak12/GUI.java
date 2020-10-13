package praktika.Prak12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GUI extends JFrame implements ActionListener{
    private JMenuBar menuBar = new JMenuBar();
    private JFrame f;
    private JTextArea t = new JTextArea();
    private ICreateDocument factory;
    private IDocument idoc;

    public GUI(CreateTextDocument concreteCreateDocument){
        factory = concreteCreateDocument;
        f = new JFrame("TXT edit");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(1000,700);
        f.setJMenuBar(menuBar);
        t.setEditable(false);

        JMenu file = new JMenu("File");
        JMenuItem newf = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        newf.addActionListener(this);
        file.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);

        menuBar.add(file);
        file.add(newf);
        file.add(open);
        file.add(save);
        file.add(exit);

        f.add(t);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "Open": {
                String filename = JOptionPane.showInputDialog(null, "Input filename");
                if (filename != null) {
                    f.setTitle(filename);
                    idoc = factory.CreateOpen(filename);
                    try {
                        String text = idoc.read();
                        t.setEditable(true);
                        t.setText(text);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Can`t read this file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Please, enter filename");
                }
            }
                break;
            case "New":
                idoc = factory.CreateNew();
                t.setEditable(true);
                t.setText("");
                break;
            case "Save":
                if (idoc == null) {
                    JOptionPane.showMessageDialog(null, "Nothing to save!");
                    break;
                }
                try {
                    if (((TextDocument) idoc).getName() == null){
                        String filename = JOptionPane.showInputDialog(null, "Input filename");
                        String path = "praktika/Prak12/txtfiles/" + filename;
                        if (!Files.exists(Paths.get(path))) {
                            ((TextDocument) idoc).setName(filename);
                            f.setTitle(filename);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "This file already exists", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                    ((TextDocument) idoc).setData(t.getText());
                    idoc.save();
                    JOptionPane.showMessageDialog(null, "Success!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
            case "Exit":
                f.setVisible(false);
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args)
    {
        new GUI(new CreateTextDocument());
    }


}
