package inter;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import ;

public class riddle {
    private JPanel riddle;
    private JLabel title;
    private JLabel wordBox;
    private JButton letter1;
    private JButton letter2;
    private JButton letter3;
    private JButton letter4;
    private JButton letter5;
    private JButton letter6;
    private JButton letter7;
    private JButton letter8;
    private JButton letter9;
    private JButton letter10;
    private JButton letter11;
    private JButton letter12;
    private JButton clear;
    private JFrame frame;
    private String word;
    private ArrayList<JButton> disableButtons = new ArrayList<JButton>();

    Game game = new Game();
    private ArrayList<Character> letters = ;

    public void setLetters(ArrayList<Character> letters) {
        letter1.setText(Character.toString(letters.get(0)));
        letter2.setText(Character.toString(letters.get(1)));
        letter3.setText(Character.toString(letters.get(2)));
        letter4.setText(Character.toString(letters.get(3)));
        letter5.setText(Character.toString(letters.get(4)));
        letter6.setText(Character.toString(letters.get(5)));
        letter7.setText(Character.toString(letters.get(6)));
        letter8.setText(Character.toString(letters.get(7)));
        letter9.setText(Character.toString(letters.get(8)));
        letter10.setText(Character.toString(letters.get(9)));
        letter11.setText(Character.toString(letters.get(10)));
        letter12.setText(Character.toString(letters.get(11)));
    }

    public riddle(JFrame frame, Difficulty difficulty, TypeMystery typeMystery) {

        this.frame = frame;

        letter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter1);
            }
        });
        letter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter2);
            }
        });
        letter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter3);
            }
        });
        letter4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter4);
            }
        });
        letter5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter5);
            }
        });
        letter6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter6);
            }
        });
        letter7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter7);
            }
        });
        letter8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter8);
            }
        });
        letter9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter9);
            }
        });
        letter10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter10);
            }
        });
        letter11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter11);
            }
        });
        letter12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter12);
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordBox.setText("");
                disableButtons.forEach(jButton -> jButton.setEnabled(true));
                disableButtons = new ArrayList<JButton>();
            }
        });
    }

    public void updateWordBox(JButton button) {
        word = wordBox.getText();
        word = word + button.getText();
        wordBox.setText(word);
        button.setEnabled(false);
        disableButtons.add(button);
    }

    public void linkMethod() {
        Game game = new Game(difficulty, typeMystery);
        game.SetTypeMystery(typeMystery);

        game.NextMystery();

        ArrayList<Character> displayLetters = game.GetLetterDisplay();

        //game.GetBonusList().get(0).ApplyBonus(game);

        frame.setContentPane(riddle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setLetters(displayLetters);
    }

}
