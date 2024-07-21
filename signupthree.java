package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class signupthree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;

    String formno;


    signupthree(String formno){
        this.formno=formno;

        setLayout(null);

//heading
        JLabel l1=new JLabel("Page no. 3: Account Details");
        l1.setBounds(150,50,500,40);
        l1.setFont(new Font("Ariel",Font.BOLD,18));
        add(l1);

        //type

        JLabel type=new JLabel("Account Type :");
        type.setBounds(90,140,200,30);
        type.setFont(new Font("Ariel",Font.BOLD,20));
        add(type);
        r1=new JRadioButton("Saving");
        r1.setBounds(270,145,100,20);
        add(r1);
        r2=new JRadioButton("Current");
        r2.setBounds(400,145,100,20);
        add(r2);
        r3=new JRadioButton("ZeroBalance");
        r3.setBounds(270,175,100,20);
        add(r3);
        r4=new JRadioButton("Domestic");
        r4.setBounds(400,175,100,20);
        add(r4);
        ButtonGroup b=new ButtonGroup();
        b.add(r1);
        b.add(r2);
        b.add(r3);
        b.add(r4);

        //card no.

        JLabel card=new JLabel("Card Number :");
        card.setBounds(90,220,200,30);
        card.setFont(new Font("Ariel",Font.BOLD,20));
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-2424");
        number.setBounds(270,220,250,30);
        number.setFont(new Font("Ariel",Font.BOLD,15));
        add(number);

        //pin no.

        JLabel pin=new JLabel("Pin Number :");
        pin.setBounds(90,270,200,30);
        pin.setFont(new Font("Ariel",Font.BOLD,20));
        add(pin);

        JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setBounds(270,270,250,30);
        pinnumber.setFont(new Font("Ariel",Font.BOLD,15));
        add(pinnumber);


        //services required

        JLabel services=new JLabel("Services Req. :");
        services.setBounds(90,320,200,30);
        services.setFont(new Font("Ariel",Font.BOLD,20));
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setBounds(270,325,100,20);
        add(c1);
        c2=new JCheckBox("Internet Banking");
        c2.setBounds(400,325,200,20);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(270,355,130,20);
        add(c3);
        c4=new JCheckBox("SMS Alert");
        c4.setBounds(400,355,100,20);
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBounds(270,385,130,20);
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBounds(400,385,100,20);
        add(c6);
        c7=new JCheckBox("I herby above all details are correct ");
        c7.setBounds(100,440,600,20);
        add(c7);


        //buttons
        submit=new JButton("Submit");
        submit.setBounds(410,500,80,20);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("Cancel");
        cancel.setBounds(270,500,80,20);
        cancel.addActionListener(this);
        add(cancel);




        setTitle("signupthree");
        setSize(600,700);
        setLocation(50,50);
setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==submit){
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="savings";
            }else if(r2.isSelected()){
                accounttype="current";
            } else if (r3.isSelected()) {
                accounttype="zero balance";

            }else if (r4.isSelected()){
                accounttype="domestic";
            }

            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()% 90000000L) +4545936300000000L);

            String pinnumber= ""+Math.abs((random.nextLong()% 9000L)+1000L);

            String facility ="";
            if(c1.isSelected()){
                facility+="ATM Card";

            }
            else if(c2.isSelected()){
                facility+="Internet Banking";
            } else if (c3.isSelected()) {
                facility+="Mobile Banking";

            }
            else if(c4.isSelected()){
                facility+="Email & SMS Alert";
            }
            else if(c5.isSelected()){
                facility+="Cheque Book";
            }
            else if(c6.isSelected()){
                facility+="E statement";
            }

            try{
                if (accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is req.");
                }
                else{
                    conn conn =new conn();
                   String query1="insert into signupthree values('"+formno +"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno +"','"+cardnumber+"','"+pinnumber+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                }
                JOptionPane.showMessageDialog(null,"card no."+cardnumber +"\n pin no."+ pinnumber);
                setVisible(false);
                new deposit(pinnumber).setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
setVisible(false);

new Login().setVisible(true);
        }
    }
    public static void main(String[]args){
new signupthree("");

    }
}
