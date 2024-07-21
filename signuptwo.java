package ATM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class signuptwo extends JFrame implements ActionListener{

    JButton next;
    JTextField pan,aadhar;
    JRadioButton syes ,sno,eyes,eno;
    JComboBox religion,category ,income ,qualification,occupation;
    String formno;
    signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("Signuptwo");



//details

        JLabel details=new JLabel(" Additional Details - Page 2: ");
        details.setFont(new Font("Ariel",Font.BOLD,20) );
        details.setBounds(150,50,700,60);
        add(details);

// religion

        JLabel name=new JLabel("Religion :");
        name.setFont(new Font("Ariel",Font.BOLD,20));
        name.setBounds(100,160,200,25);
        add(name);
String valReligion[]={"Hindu","Muslim","sikh","christian","other"};
         religion=new JComboBox(valReligion);
        religion.setBounds(300,160,200,25);
        add(religion);



        //Category


        JLabel fname=new JLabel("Category :");
        fname.setFont(new Font("Ariel",Font.BOLD,20));
        fname.setBounds(100,200,200,25);
        add(fname);

        String cat[]={"General","OBC","Sc","St"};
         category=new JComboBox(cat);
        category.setBounds(300,200,200,25);
        add(category);


        //Income


        JLabel dob=new JLabel("Income :");
        dob.setFont(new Font("Ariel",Font.BOLD,20));
        dob.setBounds(100,240,200,25);
        add(dob);

        String incom[]={"0","<1lakh","1lakh-2lakk"};
         income=new JComboBox(incom);
        income.setBounds(300,240,200,25);
        add(income);

        //Educaton

        JLabel gender=new JLabel("Educational ");
        gender.setFont(new Font("Ariel",Font.BOLD,20));
        gender.setBounds(100,280,200,25);
        add(gender);

        //Qualification

        JLabel email=new JLabel("Qualification :");
        email.setFont(new Font("Ariel",Font.BOLD,20));
        email.setBounds(100,320,200,25);
        add(email);
        String q[]={"10th pass","12th pass","Graduate","Post-Graduate"};
         qualification=new JComboBox(q);
        qualification.setBounds(300,300,200,25);
        add(qualification);


//occupation


        JLabel marry=new JLabel("Occupation :");
        marry.setFont(new Font("Ariel",Font.BOLD,20));
        marry.setBounds(100,360,200,25);
        add(marry);
        String occ[]={"bussiness","private job","student","housewife"};
         occupation=new JComboBox(occ);
        occupation.setBounds(300,360,200,25);
        add(occupation);



        //pan no.

        JLabel add=new JLabel("PAN no. :");
        add.setFont(new Font("Ariel",Font.BOLD,20));
        add.setBounds(100,400,200,25);
        add(add);
        pan=new JTextField();
        pan.setBounds(300,400,200,25);
        pan.setFont(new Font("ariel",Font.BOLD,15));
        add(pan);

        //aadhar no.

        JLabel city=new JLabel("Aadhar no. :");
        city.setFont(new Font("Ariel",Font.BOLD,20));
        city.setBounds(100,440,200,25);
        add(city);
        aadhar=new JTextField();
        aadhar.setBounds(300,440,200,25);
        aadhar.setFont(new Font("ariel",Font.BOLD,15));
        add(aadhar);


        //senior citizen

        JLabel pincode=new JLabel("Senior Citizen :");
        pincode.setFont(new Font("Ariel",Font.BOLD,20));
        pincode.setBounds(100,480,200,25);
        add(pincode);
         syes=new JRadioButton("yes");
        syes.setBounds(400,480,100,25);
        add(syes);
         sno=new JRadioButton("no");
        sno.setBounds(300,480,100,25);
        add(sno);
        ButtonGroup b=new ButtonGroup();
        b.add(syes);
        b.add(sno);

//existing acc.

        JLabel state=new JLabel("Existing Account :");
        state.setFont(new Font("Ariel",Font.BOLD,20));
        state.setBounds(100,520,200,25);
        add(state);
         eyes=new JRadioButton("yes");
        eyes.setBounds(400,520,100,25);
        add(eyes);
         eno=new JRadioButton("no");
        eno.setBounds(300,520,100,25);
        add(eno);
        ButtonGroup c=new ButtonGroup();
        c.add(eyes);
        c.add(eno);



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
        String sreligion=(String)  religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seducation=(String) qualification.getSelectedItem();

                String seniorcitizen=null;
        if (syes.isSelected()){
            seniorcitizen="yes";}
        else {
            seniorcitizen="no";
        }

        String existingaccount=null;
        if (eyes.isSelected()){
            existingaccount="yes";

        }
        else {
            existingaccount="no";
        }
        String span =pan.getText();
        String saadhar =aadhar.getText();

        try{

                conn c = new conn();
               String query="insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

                //signup3 object
            setVisible(false);
            new signupthree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String []args){
        new signuptwo("");
    }}



