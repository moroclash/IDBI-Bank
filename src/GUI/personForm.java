
package GUI;

import MainArchitecture.Customer;
import MainArchitecture.Teller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class personForm extends standerForm{
    protected  JPanel personframe;
    protected JLabel Fname , Lname ,Ssn, Age , Address, Gander, Email, Country, Id, Phone, Username, Password;
    protected JTextField fnam , lnam , ssn , age, address, email, country, id, phon ;
    protected JRadioButton Male,Female;
    private ButtonGroup gander;
    private Customer man;
    public  personForm(String s)
    {
        super(s);
        
        
        personframe = new JPanel();
        personframe.setLayout(null);
        personframe.setBackground(Color.decode("#00836c"));
        personframe.setBounds(10,40,690,425);
        frame.add(personframe);
        
       
        Fname = new JLabel("FirestName");
        Fname.setBounds(25, 15, 120 , 25);
        setFont("Adobe Gurmukhi", 1, 19);
        Fname.setFont(f);
        Fname.setForeground(Color.white);
        personframe.add(Fname);
        
        
        
        
        fnam = new JTextField("" ,10);
        fnam.setBounds(Fname.getBounds().x+Fname.getBounds().width, Fname.getBounds().y-4,120, Fname.getBounds().height);
        personframe.add(fnam);
        
        
        Lname = new JLabel("LastName");
        Lname.setBounds(fnam.getBounds().x+Fname.getBounds().width+100, Fname.getBounds().y, fnam.getBounds().width , fnam.getBounds().height);
        Lname.setFont(f);
        Lname.setForeground(Color.white);
        personframe.add(Lname);
        
        lnam = new JTextField("" ,10);
        lnam.setBounds(Lname.getBounds().x+Lname.getBounds().width, fnam.getBounds().y,fnam.getBounds().width, fnam.getBounds().height);
        personframe.add(lnam);

        Ssn = new JLabel("Ssn");
        Ssn.setBounds(Fname.getBounds().x, Fname.getBounds().y + 40, Fname.getBounds().width , Fname.getBounds().height);
        Ssn.setFont(f);
        Ssn.setForeground(Color.white);
        personframe.add(Ssn);
        
        ssn = new JTextField("" ,20);
        ssn.setBounds(fnam.getBounds().x, Ssn.getBounds().y-4,fnam.getBounds().width+150, fnam.getBounds().height);
        personframe.add(ssn);
        
        
        Id = new JLabel("Id");
        Id.setBounds(Fname.getBounds().x, Ssn.getBounds().y + 40, Fname.getBounds().width , Fname.getBounds().height);
        Id.setFont(f);
        Id.setForeground(Color.white);
        //personframe.add(Id);
        
        
        id = new JTextField("" ,10);
        id.setBounds(fnam.getBounds().x, Id.getBounds().y-4,fnam.getBounds().width-30, fnam.getBounds().height);
       // personframe.add(id);
        
        
        Gander = new JLabel("Gander :");
        Gander.setBounds(Lname.getBounds().x+9, Id.getBounds().y, Fname.getBounds().width , Fname.getBounds().height);
        Gander.setFont(f);
        Gander.setForeground(Color.white);
        personframe.add(Gander);
        
        
        Male = new JRadioButton("Male");
        Female = new JRadioButton("Female");
        gander = new ButtonGroup();
        gander.add(Male);
        gander.add(Female);
        
        Male.setBounds(Gander.getBounds().x+Gander.getBounds().width,Gander.getBounds().y,90,Fname.getBounds().height);
        Male.setFont(f);
        Male.setForeground(Color.black);
        Male.setBackground(Color.decode("#00836c"));
        personframe.add(Male);
        Female.setBounds(Male.getBounds().x+Male.getBounds().width + 10,Male.getBounds().y,100,Fname.getBounds().height);
        Female.setFont(f);
        Female.setForeground(Color.black);
        Female.setBackground(Color.decode("#00836c"));
        personframe.add(Female);
        
        
        Email = new JLabel("Email");
        Email.setBounds(Id.getBounds().x,Id.getBounds().y + 40, Fname.getBounds().width , Fname.getBounds().height);
        Email.setFont(f);
        Email.setForeground(Color.white);
        personframe.add(Email);
        
        
        email = new JTextField("" ,25);
        email.setBounds(fnam.getBounds().x , Email.getBounds().y-4,fnam.getBounds().width+65, fnam.getBounds().height);
        personframe.add(email);
                
        
        Age = new JLabel("Age");
        Age.setBounds(Lname.getBounds().x +40,Email.getBounds().y, Fname.getBounds().width , Fname.getBounds().height);
        Age.setFont(f);
        Age.setForeground(Color.white);
        personframe.add(Age);
        
        age = new JTextField("" ,3);
        age.setBounds(lnam.getBounds().x , email.getBounds().y,fnam.getBounds().width-30, fnam.getBounds().height);
        personframe.add(age);

        Address = new JLabel("Address");
        Address.setBounds(Fname.getBounds().x,Email.getBounds().y+40, Fname.getBounds().width , Fname.getBounds().height);
        Address.setFont(f);
        Address.setForeground(Color.white);
        personframe.add(Address);
        
        address = new JTextField("" ,100);
        address.setBounds(fnam.getBounds().x , Address.getBounds().y-4,lnam.getBounds().x, fnam.getBounds().height);
        personframe.add(address);
        
        Phone = new JLabel("Phone");
        Phone.setBounds(Fname.getBounds().x,Address.getBounds().y+40, Fname.getBounds().width , Fname.getBounds().height);
        Phone.setFont(f);
        Phone.setForeground(Color.white);
        personframe.add(Phone);
        
        phon = new JTextField("" ,15);
        phon.setBounds(fnam.getBounds().x , Phone.getBounds().y-4,email.getBounds().width, fnam.getBounds().height);
        personframe.add(phon);
        
        
        
        Country = new JLabel("Country");
        Country.setBounds(Age.getBounds().x,Phone.getBounds().y, Fname.getBounds().width , Fname.getBounds().height);
        Country.setFont(f);
        Country.setForeground(Color.white);
        personframe.add(Country);
        
        
        country = new JTextField("" ,10);
        country.setBounds(age.getBounds().x , Country.getBounds().y-4,age.getBounds().width, fnam.getBounds().height);
        personframe.add(country);
      
        
        
        
    
    
    
    }

    @Override
    public  void actionPerformed(ActionEvent e){
        if(e.getSource() == submit)
        {
            man.setFname(fnam.getText());
            man.setlname(lnam.getText());
            man.setGender(gander.getSelection().toString());
            man.setEmail(email.getText());
            man.setAge(age.getText());
            man.setAddress(address.getText());
            man.setPhone(phon.getText());
            man.setCountry(country.getText());
            try {
                /// elmfroood nms7 el customer 2pl mndeeef mstnyyyen 4o8l poooda en el teeeler yms7 customer
                new Teller().addCustomer(man);
                massage.setForeground(Color.green);
                massage.setText("*Success");
            } catch (IOException|ClassNotFoundException ex) {
                    massage.setText("*sory cant't connect with system");
            } catch (Exception ex) {
                    massage.setText("*5let mn 3ndnaa ya 3oomar");
            }
            
        }
    
    };
    
    public void Reset1()
    {
        this.fnam.setText("");
        this.address.setText("");
        this.age.setText("");
        this.country.setText("");
        this.email.setText("");
        this.ssn.setText("");
        this.phon.setText("");
        this.id.setText("");
        this.lnam.setText("");    
    }

    public void setCustomer(Customer man) {
        this.man = man;
    }

    public Customer getCustomer() {
        return man;
    }
    
    
    
}
