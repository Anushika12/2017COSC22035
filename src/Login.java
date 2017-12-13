import DBConnect.dbConnect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.sql.*;
import DBConnect.*;

public class Login {
    private JPanel Login;
    private JTextField userField;

    private JButton exitButton;
    private JButton loginButton;
    private JPasswordField passwordField1;
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
                String pw = String.valueOf(passwordField1.getPassword());
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
            inPW = RS.getString("Pasword");

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

