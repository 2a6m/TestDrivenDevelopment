package inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.*;

public class App {

    private JPanel interfaceMain;
    private JLabel title;
    private JLabel intro;
    private JComboBox difficulty;
    private JButton validateButton;

    public App(JFrame frame) {
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Difficulty difficultyObject;

                switch (difficulty.getSelectedItem().toString()) {
                    case "Facile":
                        difficultyObject = new Difficulty("easy");
                        frame.setContentPane(new GameChoice(frame, difficultyObject).GetGameChoice());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    case "Moyen":
                        difficultyObject = new Difficulty("intermediate");
                        frame.setContentPane(new GameChoice(frame, difficultyObject).GetGameChoice());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    case "Difficile":
                        difficultyObject = new Difficulty("advanced");
                        frame.setContentPane(new GameChoice(frame, difficultyObject).GetGameChoice());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MysteryGame");
        frame.setContentPane(new App(frame).interfaceMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
