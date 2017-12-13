import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userDetails extends JFrame{
    private JTextField txtName;
    private JTextField textContact;
    private JButton logoutButton;
    private JButton coursesButton;
    private JPanel Panel1;
    private JTextField textEmail;
    private JTextField textGPA;

    public userDetails(String userNmae) {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
    setVisible(true);
    logoutButton.addActionListener(new ActionListener());{
    @Override
    public void actionPerformed  (ActionEvent e) {
    System.exit(0);
    }
        }
    }
}
