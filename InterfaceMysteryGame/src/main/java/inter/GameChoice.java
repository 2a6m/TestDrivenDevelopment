package inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.*;

public class GameChoice {
    private JPanel gameChoice;
    private JLabel title;
    private JLabel intro;
    private JComboBox gameMode;
    private JButton playButton;

    public GameChoice(JFrame frame, Difficulty difficulty) {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, gameMode.getSelectedItem());
                switch (gameMode.getSelectedItem().toString()) {
                    case "Devinette":
                        SentenceMystery typeMystery = new SentenceMystery();
                        frame.setContentPane(new Login(frame, difficulty, typeMystery).GetLogin());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                }
            }
        });
    }

    public JPanel GetGameChoice() {
        return gameChoice;
    }
}
