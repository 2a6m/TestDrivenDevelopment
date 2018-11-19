package inter;

import backend.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login {
    private JPanel loginPanel;
    private JTextField username;
    private JPasswordField password;
    private JButton Login;
    private JButton notLogin;
    private Game game ;

    public Login(JFrame frame, Difficulty difficulty,TypeMystery typeMystery) {

        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pswdArray = password.getPassword();
                String str = "";
                for(char c : pswdArray) str+=String.valueOf(c);
//                game = new Game(difficulty, typeMystery);
//                game.SetTypeMystery(typeMystery);
//                game.Login(username.getText(),str);
                new riddle(frame, difficulty, typeMystery, username.getText(), str).initialize();
            }
        });
        notLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new riddle(frame, difficulty, typeMystery, "", "").initialize();
            }
        });
    }
    public JPanel getLogin() { return loginPanel; }

}
