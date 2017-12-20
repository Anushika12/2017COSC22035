import DBConnect.dbConnect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.*;

public class Login {
    private JPanel Login;
    private JTextField userField;

    private JButton exitButton;
    private JButton loginButton;
    private JPasswordField pwfield;
    private student user new student ();
    public static JFrame loginFR = new JFrame("Login Box");


    public Login() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String pw = String.valueOf(pwfield.getPassword());
                loginCheck(username, pw);
                JOptionPane.showMessageDialog(null, username + "System not ready yet");
            }
        });
    }

    public static void main(String[] args) {
        loginFR.setContentPane(new Login().Login);
        loginFR.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFR.pack();
        loginFR.setVisible(true);
    }

    private void loginCheck(String frUsername, String frPW) {
        String inPW = null;
        String inUsername = null;
        dbConnect dbcon = new dbConnect();
        Statement stml = null;
        try {
            String query = "Select * from userDetails where UserName='" + frUsername + "'";
            stml = dbcon.Conn2DB();
            ResultSet RS = stml.executeQuery(query);
            RS.first();
            inUsername = frUsername;
            user.name = frUsername;
            inPW = RS.getString("Pasword");
            user.PW = inPW;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        if (frUsername.equals(inUsername) && frPW.equals(inPW))

        {
            JOptionPane.showMessageDialog(null, "user name and password correct");
            loginFR.setVisible(false);
            new userDetails(frUsername);
        } else JOptionPane.showMessageDialog(null, "Incorrect");

    }
}

