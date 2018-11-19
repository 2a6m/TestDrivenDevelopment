package inter;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
                        new riddle(frame, difficulty, typeMystery).initialize();
                        break;
                }
            }
        });
    }

    public JPanel getGameChoice() {
        return gameChoice;
    }
}
