package ATM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class transaction extends JFrame implements ActionListener {
    JButton deposit,withdrawl,ministatement,pinchange,exit,fastcash,balanceenquiry;
    String pinnumber ;
    transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1000,800);
        add(image);

JLabel text =new JLabel("Please select your transaction");
text.setBounds(220,160,600,50);
text.setFont(new Font("Ariel",Font.BOLD,37));
text.setForeground(Color.white);
image.add(text);


        //deposit

         deposit=new JButton("Deposit");
        deposit.setBounds(220,300,150,25);
        deposit.setFont(new Font("Ariel",Font.BOLD,14));
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        //fast cash

         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(220,340,150,25);
        fastcash.setFont(new Font("Ariel",Font.BOLD,14));
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        image.add(fastcash);

        //exit

        exit=new JButton("Exit");
        exit.setBounds(220,380,150,25);
        exit.setFont(new Font("Ariel",Font.BOLD,14));
        exit.setBackground(Color.white);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);



        //cash withdrawl

         withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(650,300,150,25);
        withdrawl.setFont(new Font("Ariel",Font.BOLD,14));
        withdrawl.setBackground(Color.white);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.addActionListener(this);

        image.add(withdrawl);

        //mini statement

         ministatement=new JButton("Mini Statement");
        ministatement.setBounds(650,340,150,25);
        ministatement.setFont(new Font("Ariel",Font.BOLD,14));
        ministatement.setBackground(Color.white);
        ministatement.setForeground(Color.BLACK);
        ministatement.addActionListener(this);

        image.add(ministatement);

        //balance enquiry

         balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(650,380,150,25);
        balanceenquiry.setFont(new Font("Ariel",Font.BOLD,14));
        balanceenquiry.setBackground(Color.white);
        balanceenquiry.setForeground(Color.BLACK);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);





        setTitle("Transaction");
        setBounds(0,0,1000,800);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==exit){
             System.exit(0);
         }
         else if (ae.getSource()==deposit){
             setVisible(false);
             new deposit(pinnumber).setVisible(true);
         }
         else if (ae.getSource()==withdrawl){
             setVisible(false);
             new withdrawl(pinnumber).setVisible(true);
         } else if (ae.getSource()==fastcash) {
             setVisible(false);
             new fastcash(pinnumber).setVisible(true);
         }else if (ae.getSource()==balanceenquiry) {
             setVisible(false);
             new balanceenquiry(pinnumber).setVisible(true);
         }else if (ae.getSource()==ministatement) {
             new ministatement(pinnumber).setVisible(true);
         }

    }
    public static void main(String args[]){

        new transaction("");
    }


}
