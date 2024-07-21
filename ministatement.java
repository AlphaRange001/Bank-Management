
package ATM;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ministatement extends JFrame {


    ministatement(String pinnumber){
        setLayout(null);


        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank=new JLabel("VP BANK");
        bank.setBounds(130,50,100,30);
        bank.setFont(new Font("Ariel",Font.BOLD,20));
        add(bank);
        JLabel balance =new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        JLabel card=new JLabel();
        card.setBounds(20,100,300,20);
        add(card);
try{
    conn conn=new conn();
    int bal=0;
    ResultSet rs =conn.s.executeQuery("select *from login where pinnumber = '"+pinnumber+"'");
    while(rs.next()){
        card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
        if(rs.getString("type").equals("deposit")){
            bal+=Integer.parseInt(rs.getString("amount"));
        }else {
            bal-=Integer.parseInt(rs.getString("amount"));
        }

    }
//balance.setText("Your current Balance is :"+bal);
}catch (Exception e){
    System.out.println(e);

        }
try{
    conn conn=new conn();
    ResultSet rs=conn.s.executeQuery("select *from bank where pin = '"+pinnumber+"'");
    while(rs.next()){
        mini.setText(mini.getText() +"<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount")+"<br><br><html>");

    }
}catch(Exception e){
    System.out.println(e);

        }


        setTitle("Mini Statement");
        setSize(500,600);
        setLocation(30,30);
        setVisible(true);


    }
    public static void main(String args []){
        new ministatement("");

    }
}
