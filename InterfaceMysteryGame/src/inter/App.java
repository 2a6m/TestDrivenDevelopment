package inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private JPanel InterfaceMain;
    private JLabel title;
    private JLabel intro;
    private JComboBox difficulty;
    private JButton validateButton;

    public App(JFrame frame) {
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String level = difficulty.getSelectedItem().toString();
                Difficulty difficultyObject = new Difficulty(level);
                frame.setContentPane(new GameChoice(frame, difficultyObject).getGameChoice());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MysteryGame");
        frame.setContentPane(new App(frame).InterfaceMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
