import DBConnect.dbConnect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.SQLException;

public class storeDetails extends JFrame {

    private JPanel panel1;
    private JTextField txtUser;
    private JTextField txtUID;
    private JTextField txtEmail;
    private JButton logoutButton;
    private JButton btnInsert;
    private JPasswordField txtPW;

    public storeDetails() {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertDB();
            }
        });
    }

    public void InsertDB()
    {
        String query = "INSERT INTO userdetails VALUES ('"+txtUID.getText()+"','"+txtUser.getText()+"','"+txtEmail.getText()+"','"+String.valueOf(txtPW.getPassword())+"',5)";
        System.out.println(query);
        dbConnect DB = new dbConnect();
        Statement stmt = null;
        try {
            stmt = DB.Conn2DB();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Store details");
        } catch (SQLException se)
        {
            se.printStackTrace();
        }
        DB.closeDB();
    }

}
