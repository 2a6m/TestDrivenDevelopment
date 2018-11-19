package inter;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.util.*;
import java.util.function.Consumer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import backend.*;


public class riddle {
    private JPanel riddle;
    private JLabel enigma;
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
    private JButton removeBonus;
    private JButton displayBonus;
    private JButton skipBonus;
    private JLabel espace;
    private JFrame frame;
    private Difficulty difficulty;
    private TypeMystery typeMystery;
    private String word;
    private String response;
    private String user;
    private String password;
    private ArrayList<JButton> disableButtons = new ArrayList<JButton>();
    private ArrayList<JButton> bonusUsed = new ArrayList<JButton>();
    private ArrayList<JButton> ListButtons = new ArrayList<JButton>();
    private Game game;

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
        ListButtons.add(letter1);
        ListButtons.add(letter2);
        ListButtons.add(letter3);
        ListButtons.add(letter4);
        ListButtons.add(letter5);
        ListButtons.add(letter6);
        ListButtons.add(letter7);
        ListButtons.add(letter8);
        ListButtons.add(letter9);
        ListButtons.add(letter10);
        ListButtons.add(letter11);
        ListButtons.add(letter12);
    }

    public riddle(JFrame frame, Difficulty difficulty, TypeMystery typeMystery, String user, String password) {

        this.frame = frame;
        this.difficulty = difficulty;
        this.typeMystery= typeMystery;
        this.user = user;
        this.password = password;

        letter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter1);
                check();
            }
        });
        letter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter2);
                check();
            }
        });
        letter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter3);
                check();
            }
        });
        letter4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter4);
                check();
            }
        });
        letter5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter5);
                check();
            }
        });
        letter6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter6);
                check();
            }
        });
        letter7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter7);
                check();
            }
        });
        letter8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter8);
                check();
            }
        });
        letter9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter9);
                check();
            }
        });
        letter10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter10);
                check();
            }
        });
        letter11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter11);
                check();
            }
        });
        letter12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWordBox(letter12);
                check();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayBonus.isEnabled()) {
                    if (removeBonus.isEnabled()){reset();}
                    else {
                        reset();
                        removeMethod();
                    }
                }
                else {

                    if(removeBonus.isEnabled()){reset();}
                    else {
                        reset();
                        removeMethod();
                    }
                    wordBox.setText(response.substring(0,1));
                    removeFirstLetter();
                }
            }
        });
        removeBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                if (!displayBonus.isEnabled()) {wordBox.setText(response.substring(0,1));}
                removeMethod();
                removeBonus.setEnabled(false);
                bonusUsed.add(removeBonus);
            }
        });

        displayBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                removeFirstLetter();
                wordBox.setText(response.substring(0,1));
                displayBonus.setEnabled(false);
                bonusUsed.add(displayBonus);
            }
        });
        skipBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                resetBonus();
                Next();
            }
        });
    }

    public void reset() {
        wordBox.setText("");

        disableButtons.forEach(new Consumer<JButton>() {
            @Override
            public void accept(JButton jButton) {
                jButton.setEnabled(true) ;
                disableButtons = new ArrayList<JButton>();
            }
        });
    }

    public void resetBonus() {
        bonusUsed.forEach(new Consumer<JButton>() {
            @Override
            public void accept(JButton jButton) {
                jButton.setEnabled(true) ;
                bonusUsed = new ArrayList<JButton>();
            }
        });
    }

    public void check() {
        String word = wordBox.getText();
        if (response.length() == wordBox.getText().length()) {
            boolean bool = response.contentEquals(word);
            if (bool) {
                reset();
                resetBonus();
                Next();
            }
        }
    }

    public void updateWordBox(JButton button) {
        word = wordBox.getText();
        word = word + button.getText();
        wordBox.setText(word);
        button.setEnabled(false);
        disableButtons.add(button);
    }

    public void removeMethod(){
        for (JButton button : ListButtons) {
            if(response.indexOf(button.getText().charAt(0))== -1){
                button.setEnabled(false);
                disableButtons.add(button);
            }
            
        }
    }
    public void removeFirstLetter(){
        for (JButton button : ListButtons) {
            if (button.getText().contentEquals(response.substring(0,1))) {
                button.setEnabled(false);
                disableButtons.add(button);
                break;
            }
        }

    }

    public void initialize() {
        this.game = new Game(difficulty, typeMystery);
        game.SetTypeMystery(typeMystery);
        if (this.user != "") {
            game.Login(this.user, this.password);
        }
        Next();
    }

    public void Next() {

        game.NextMystery();

        enigma.setText(game.GetMystery().getValue().get(0));
        this.response = game.GetMystery().getKey();

        ArrayList<Character> displayLetters = game.GetLetterDisplay();

        //game.GetBonusList().get(0).ApplyBonus(game);

        frame.setContentPane(riddle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setLetters(displayLetters);
    }

}
