package inter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameChoice {
    private JPanel gameChoice;
    private JLabel title;
    private JLabel intro;
    private JComboBox gameMode;
    private JButton playButton;

    public GameChoice() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, gameMode.getSelectedItem());
            }
        });
    }

    public JPanel getGameChoice() {
        return gameChoice;
    }
}
