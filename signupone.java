package ATM;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class signupone extends JFrame implements ActionListener{
    long random;
    JTextField n,f,e,a,s,p,c;
    JDateChooser date;
    JButton next;
    JRadioButton m,u,male,Female;
    signupone(){
        setLayout(null);

Random ran=new Random();
random=ran.nextInt(9999);
        System.out.println(random);
JLabel formno=new JLabel("Application Form no. is "+random);
formno.setFont(new Font("Raleway",Font.BOLD,38));
formno.setBounds(60,20,600,40);
add(formno);

//details

        JLabel details=new JLabel("Page 1: Personal Details");
        details.setFont(new Font("Ariel",Font.BOLD,20) );
        details.setBounds(170,70,500,40);
        add(details);

// name

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Ariel",Font.BOLD,20));
        name.setBounds(100,160,200,25);
        add(name);
         n=new JTextField();
        n.setBounds(300,160,200,25);
        n.setFont(new Font("ariel",Font.BOLD,15));
        add(n);



        //father name


        JLabel fname=new JLabel("Father's name :");
        fname.setFont(new Font("Ariel",Font.BOLD,20));
        fname.setBounds(100,200,200,25);
        add(fname);
             f=new JTextField();
            f.setBounds(300,200,200,25);
        f.setFont(new Font("ariel",Font.BOLD,15));
            add(f);

        //dob


        JLabel dob=new JLabel("Date of Birth :");
        dob.setFont(new Font("Ariel",Font.BOLD,20));
        dob.setBounds(100,240,200,25);
        add(dob);
         date=new JDateChooser();
date.setBounds(300,240,200,25);
date.setFont(new Font("ariel",Font.BOLD,10));
date.setForeground(Color.BLACK);
        date.setFont(new Font("ariel",Font.BOLD,15));
add(date);
        //Gender

        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Ariel",Font.BOLD,20));
        gender.setBounds(100,280,200,25);
        add(gender);
         male=new JRadioButton("Male");
        male.setBounds(300,280,100,25);
        add(male);
         Female=new JRadioButton("Female");
        Female.setBounds(400,280,100,25);
        add(Female);

        ButtonGroup g=new ButtonGroup();
        g.add(male);
        g.add(Female);



        //email

        JLabel email=new JLabel("Email Address :");
        email.setFont(new Font("Ariel",Font.BOLD,20));
        email.setBounds(100,320,200,25);
        add(email);
             e=new JTextField();
            e.setBounds(300,320,200,25);
        e.setFont(new Font("ariel",Font.BOLD,15));
            add(e);

        //martial status

        JLabel marry=new JLabel("Martial status :");
        marry.setFont(new Font("Ariel",Font.BOLD,20));
        marry.setBounds(100,360,200,25);
        add(marry);
         m=new JRadioButton("Married");
        m.setBounds(300,360,100,25);
        add(m);
         u=new JRadioButton("Unmarried");
        u.setBounds(400,360,100,25);
        add(u);
        ButtonGroup b=new ButtonGroup();
        b.add(m);
        b.add(u);


        //address

        JLabel add=new JLabel("Address :");
        add.setFont(new Font("Ariel",Font.BOLD,20));
        add.setBounds(100,400,200,25);
        add(add);
             a=new JTextField();
            a.setBounds(300,400,200,25);
        a.setFont(new Font("ariel",Font.BOLD,15));
            add(a);

            //city

            JLabel city=new JLabel("City :");
            city.setFont(new Font("Ariel",Font.BOLD,20));
            city.setBounds(100,440,200,25);
            add(city);
             c=new JTextField();
            c.setBounds(300,440,200,25);
        c.setFont(new Font("ariel",Font.BOLD,15));
            add(c);

            //state

            JLabel pincode=new JLabel("State :");
        pincode.setFont(new Font("Ariel",Font.BOLD,20));
        pincode.setBounds(100,480,200,25);
            add(pincode);
             s=new JTextField();
            s.setBounds(300,480,200,25);
        s.setFont(new Font("ariel",Font.BOLD,15));
            add(s);
//pincode

            JLabel state=new JLabel("Pincode :");
        state.setFont(new Font("Ariel",Font.BOLD,20));
        state.setBounds(100,520,200,25);
            add(state);
             p=new JTextField();
            p.setBounds(300,520,200,25);
        p.setFont(new Font("ariel",Font.BOLD,15));
            add(p);


             next=new JButton("Next");
            next.setBounds(440,590,100,25);
            next.setFont(new Font("ariel",Font.BOLD,15));
            next.setBackground(Color.yellow);
            next.addActionListener(this);
            add(next);

        setSize(600,700);
setLocation(100,30);
setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno=""+random;
        String name=n.getText();
        String fname=f.getText();
        String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if (male.isSelected()){
            gender="male";}
            else{
                gender="Female";
        }
            String email=e.getText();
            String martial=null;
            if (m.isSelected()){
                martial="Married";

            }
            else{
                martial="Unmarried";
            }
            String address =a.getText();
            String city =c.getText();
            String state=s.getText();
            String pincode=p.getText();

            try{
if(name.equals("")){
    JOptionPane.showMessageDialog(null,"name missing");

}
else {
    conn c = new conn();
String query="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
c.s.executeUpdate(query);

setVisible(false);
new signuptwo(formno).setVisible(true);
}
            }catch (Exception e){
                System.out.println(e);
            }

    }
        public static void main(String []args){
        new signupone();
        }


}