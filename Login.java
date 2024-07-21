package ATM;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton Clear, Login, Register;
    JLabel username, pin, name, phone;
    JTextField usernameTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("Login Page");
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(70, 10, 200, 200);
        add(l1);

        JLabel l2 = new JLabel("WELCOME TO VP BANKING");
        l2.setFont(new Font("Onward", Font.BOLD, 40));
        l2.setBounds(230, 75, 800, 60);
        add(l2);

        // ATM no.
        username = new JLabel("ATM No.");
        username.setFont(new Font("onward", Font.BOLD, 30));
        username.setBounds(230, 200, 150, 30);
        add(username);
        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("onward", Font.BOLD, 15));
        usernameTextField.setBounds(375, 200, 150, 30);
        add(usernameTextField);

        // pin no.
        pin = new JLabel("PIN No.");
        pin.setFont(new Font("onward", Font.BOLD, 30));
        pin.setBounds(230, 250, 150, 30);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(375, 250, 150, 30);
        pinTextField.setFont(new Font("onward", Font.BOLD, 15));
        add(pinTextField);


        // Buttons
        Login = new JButton("Login");
        Login.setBounds(250, 330, 70, 30);
        Login.addActionListener(this);
        Login.setBackground(Color.white);
        add(Login);
        Clear = new JButton("Clear");
        Clear.setBounds(395, 330, 70, 30);
        Clear.addActionListener(this);
        Clear.setBackground(Color.white);
        add(Clear);
        Register = new JButton("Register");
        Register.setBounds(310, 400, 100, 30);
        Register.addActionListener(this);
        Register.setBackground(Color.white);
        add(Register);


        setSize(900, 500);
        setLocation(100, 100);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Clear) {
            usernameTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == Login) {
            conn conn=new conn();
            String cardnumber=usernameTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardnumber ='"+cardnumber+"' and pinnumber ='"+pinnumber+"'";
       try{
ResultSet rs= conn.s.executeQuery(query);
if(rs.next()){
    setVisible(false);
    new transaction(pinnumber).setVisible(true);
}else {
    JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
}
       }catch(Exception e){
           System.out.println(e);
       }
        } else if (ae.getSource() == Register) {
            setVisible(false);
            new signupone().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

