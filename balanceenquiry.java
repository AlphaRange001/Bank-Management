
package ATM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class balanceenquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    balanceenquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm1" +
                ".jpg"));
        Image i2=i1.getImage().getScaledInstance(700,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,800);
        add(image);

        back=new JButton("Back");
        back.setBounds(300,460,100,25);
        back.addActionListener(this);
        image.add(back);

        conn c=new conn();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }

            }
        }catch (Exception e){
            System.out.println(e);}

JLabel text=new JLabel("Your Current Balance is : "+balance);
        text.setBounds(170,280,400,30);
        text.setForeground(Color.white);
        image.add(text);

        setSize(700,800);
        setBounds(100,100,700,800);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transaction(pinnumber).setVisible(true);


    }
    public static void main(String args []){
        new balanceenquiry("");
    }
}
