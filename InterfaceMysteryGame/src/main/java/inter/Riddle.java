package inter;

import java.util.function.Consumer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import backend.*;


public class Riddle {
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
    private JLabel lettersNumber;
    private JLabel coins;
    private JLabel space;
    private JFrame frame;
    private Difficulty difficulty;
    private TypeMystery typeMystery;
    private String word;
    private String response;
    private String user;
    private String password;
    private ArrayList<JButton> disableButtons = new ArrayList<JButton>();
    private ArrayList<JButton> bonusUsed = new ArrayList<JButton>();
    private ArrayList<JButton> listButtons = new ArrayList<JButton>();
    private ArrayList<JButton> listSpace = new ArrayList<JButton>();
    private Game game;
    private Player player;

    public void SetLetters(ArrayList<Character> letters) {
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
        listButtons.add(letter1);
        listButtons.add(letter2);
        listButtons.add(letter3);
        listButtons.add(letter4);
        listButtons.add(letter5);
        listButtons.add(letter6);
        listButtons.add(letter7);
        listButtons.add(letter8);
        listButtons.add(letter9);
        listButtons.add(letter10);
        listButtons.add(letter11);
        listButtons.add(letter12);
        RemoveSpace();

    }

    public Riddle(JFrame frame, Difficulty difficulty, TypeMystery typeMystery, String user, String password) {

        this.frame = frame;
        this.difficulty = difficulty;
        this.typeMystery= typeMystery;
        this.user = user;
        this.password = password;

        letter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter1);
                Check();
            }
        });
        letter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter2);
                Check();
            }
        });
        letter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter3);
                Check();
            }
        });
        letter4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter4);
                Check();
            }
        });
        letter5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter5);
                Check();
            }
        });
        letter6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter6);
                Check();
            }
        });
        letter7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter7);
                Check();
            }
        });
        letter8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter8);
                Check();
            }
        });
        letter9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter9);
                Check();
            }
        });
        letter10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter10);
                Check();
            }
        });
        letter11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter11);
                Check();
            }
        });
        letter12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateWordBox(letter12);
                Check();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reset();
            }
        });
        removeBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.GetBonusList().get(0).ApplyBonus(game);
                SetLetters(game.GetLetterDisplay());
                coins.setText(String.valueOf(player.GetCoins()) + " pièces");
                removeBonus.setEnabled(false);
                bonusUsed.add(removeBonus);
            }
        });
        displayBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        skipBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public void Reset() {
        wordBox.setText("");

        disableButtons.forEach(new Consumer<JButton>() {
            @Override
            public void accept(JButton jButton) {
                if (!jButton.equals(" ")) {
                    jButton.setEnabled(true);
                    disableButtons = new ArrayList<JButton>();
                }
            }
        });
    }

    public void ResetSpace() {
        listButtons.forEach(new Consumer<JButton>() {
            @Override
            public void accept(JButton jButton) {
                jButton.setEnabled(true);
                listSpace = new ArrayList<JButton>();
            }
        });
    }

    public void ResetBonus() {
        bonusUsed.forEach(new Consumer<JButton>() {
            @Override
            public void accept(JButton jButton) {
                jButton.setEnabled(true);
                bonusUsed = new ArrayList<JButton>();
            }
        });
    }

    public void RemoveSpace() {
        for (JButton button : listButtons) {
            if (button.getText().equals(" ")){
                button.setEnabled(false);
                listSpace.add(button);
            }

        }
    }

    public void Check() {
        String word = wordBox.getText();
        if (response.length() == wordBox.getText().length()) {
            boolean bool = response.contentEquals(word);
            if (bool) {
                Reset();
                ResetSpace();
                ResetBonus();
                if (player!=null){difficulty.AddCoins(game.GetPlayer());}
                Next();
            }
        }
    }

    public void UpdateWordBox(JButton button) {
        word = wordBox.getText();
        word = word + button.getText();
        wordBox.setText(word);
        button.setEnabled(false);
        disableButtons.add(button);
    }


    public void Initialize() {
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
        lettersNumber.setText(String.valueOf(response.length()) + " lettres");

        ArrayList<Character> displayLetters = game.GetLetterDisplay();

        frame.setContentPane(riddle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        SetLetters(displayLetters);
        player = game.GetPlayer();
        if (player==null){
            removeBonus.setEnabled(false);
            disableButtons.add(removeBonus);
        } else {
          coins.setText(String.valueOf(player.GetCoins()) + " pièces");
        }

    }
}
