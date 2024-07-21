package ATM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {
    JButton deposit,withdrawl,ministatement,pinchange,exit,fastcash,balanceenquiry;
    String pinnumber ;
    fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1000,800);
        add(image);


        JLabel text =new JLabel("Select withdarwl amount");
        text.setBounds(220,200,500,25);
        text.setFont(new Font("Ariel",Font.BOLD,25));
        image.add(text);


        //deposit

        deposit=new JButton("100");
        deposit.setBounds(180,300,150,25);
        deposit.setFont(new Font("Ariel",Font.BOLD,14));
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        //fast cash

        fastcash=new JButton("500");
        fastcash.setBounds(180,340,150,25);
        fastcash.setFont(new Font("Ariel",Font.BOLD,14));
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        image.add(fastcash);

        //pin change

        pinchange=new JButton("1000");
        pinchange.setBounds(180,380,150,25);
        pinchange.setFont(new Font("Ariel",Font.BOLD,14));
        pinchange.setBackground(Color.white);
        pinchange.setForeground(Color.BLACK);
        pinchange.addActionListener(this);

        image.add(pinchange);

        //cash withdrawl

        withdrawl=new JButton("2000");
        withdrawl.setBounds(400,300,150,25);
        withdrawl.setFont(new Font("Ariel",Font.BOLD,14));
        withdrawl.setBackground(Color.white);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.addActionListener(this);

        image.add(withdrawl);

        //mini statement

        ministatement=new JButton("5000");
        ministatement.setBounds(400,340,150,25);
        ministatement.setFont(new Font("Ariel",Font.BOLD,14));
        ministatement.setBackground(Color.white);
        ministatement.setForeground(Color.BLACK);
        ministatement.addActionListener(this);

        image.add(ministatement);

        //balance enquiry

        balanceenquiry=new JButton("10000");
        balanceenquiry.setBounds(400,380,150,25);
        balanceenquiry.setFont(new Font("Ariel",Font.BOLD,14));
        balanceenquiry.setBackground(Color.white);
        balanceenquiry.setForeground(Color.BLACK);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        //exit

        exit=new JButton("Back");
        exit.setBounds(400,420,150,25);
        exit.setFont(new Font("Ariel",Font.BOLD,14));
        exit.setBackground(Color.white);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);



        setTitle("Transaction");
        setBounds(0,0,1000,800);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           setVisible(false);
           new transaction(pinnumber).setVisible(true);
        }
        else   {
            String amount =((JButton)ae.getSource()).getText();
            conn c=new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }

                }
                if (ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                    Date date = new Date();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "',' withdrawl ','" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "rs " + amount + "debited successflly");
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);


            }catch(Exception e){
                System.out.println();
            }
        }

    }
    public static void main(String args[]){
        new fastcash("");
    }


}
