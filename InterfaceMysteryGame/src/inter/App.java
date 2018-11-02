package inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel InterfaceMain;
    private JLabel Title;
    private JLabel Intro;
    private JComboBox Difficulty;
    private JButton PlayButton;

    public App() {
        PlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Hello world");
                JFrame frame = new JFrame("MysteryGame");
                frame.setContentPane(new GameChoice().getGameChoice());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MysteryGame");
        frame.setContentPane(new App().InterfaceMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
