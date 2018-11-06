package inter;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GameChoice {
    private JPanel gameChoice;
    private JLabel title;
    private JLabel intro;
    private JComboBox gameMode;
    private JButton playButton;

    public GameChoice(JFrame frame) {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, gameMode.getSelectedItem());
                new riddle(frame).linkMethod();
            }
        });
    }

    public JPanel getGameChoice() {
        return gameChoice;
    }
}
