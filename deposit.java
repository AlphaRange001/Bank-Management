
package ATM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class deposit extends JFrame implements ActionListener {

JButton deposit,back;
JTextField amount;
String pinnumber;
    deposit(String pinnumber){
        setTitle("bank Deposit");
        this.pinnumber=pinnumber;
        setLayout(null);

        //image

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm1" +
                ".jpg"));
        Image i2=i1.getImage().getScaledInstance(700,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,800);
        add(image);

        //text

        JLabel text=new JLabel("Enter Amount to Withdrawl");
        text.setFont(new Font("Ariel",Font.BOLD,20));
        text.setBounds(200,260,500,20);
        text.setForeground(Color.white);
        image.add(text);

        //amount

         amount=new JTextField("");
        amount.setBounds(300,330,100,30);
        amount.setFont(new Font("raleway",Font.BOLD,20));
        image.add(amount);

        //button

         deposit=new JButton("Deposit");
        deposit.setBounds(300,400,100,30);
        deposit.setFont(new Font("raleway",Font.BOLD,15));
        deposit.addActionListener(this);
        image.add(deposit);

         back=new JButton("Back");
        back.setBounds(300,440,100,30);
        back.setFont(new Font("raleway",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);




          setSize(700,800);
          setLocation(300,0);
          setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){
String  number =amount.getText();

Date date =new Date();
if(number.equals("")){
     JOptionPane.showMessageDialog(null,"enter amount");
}
        else{
            try{
            conn conn=new conn();
            String query="insert into bank values('"+pinnumber+"','"+date+"','deposit','"+number+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"rs"+number+"Deposited successfully");
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
                        }   catch (Exception e){
                System.out.println(e);
            }
        }

        }else if(ae.getSource()==back){
            conn conn=new conn();
            setVisible(false);
            new transaction(pinnumber).setVisible(true);

        }
    }
    public static void main(String []args){
new deposit("");
    }

}
