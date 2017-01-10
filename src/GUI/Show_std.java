
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class Show_std extends standerForm{

    protected JLabel Fname,fname,Age,age,Phone,phone,Address,address,ID,id,Country,cuntry,Email,mail,Gander,gander,Jop,jop,Username,username,Password,password;
    protected Font f2;
    protected char Flage = 'B';
    public Show_std(String s) {
        super(s);
        submit.setText("Update");
        reset.setText("Delete");
        
        f2 = new Font("Adobe Gurmukhi",1,25);
        
        Fname = new JLabel("Name :");
        Fname.setBounds(25, 50, 150 , 30);
        setFont("Adobe Gurmukhi", 1, 20);
        Fname.setFont(f);
        Fname.setForeground(Color.white);
        frame.add(Fname);
        
        fname = new JLabel("any name");
        fname.setBounds(Fname.getBounds().x+Fname.getBounds().width-15, Fname.getBounds().y-2,200, Fname.getBounds().height+5);
        fname.setFont(f2);
        fname.setForeground(Color.decode("#f5fca5"));
        frame.add(fname);
        
        Age = new JLabel("Age  :");
        Age.setBounds(Fname.getBounds().x, Fname.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Age.setFont(f);
        Age.setForeground(Color.white);
        frame.add(Age);
        
        age = new JLabel("any name");
        age.setBounds(Fname.getBounds().x+Fname.getBounds().width-15, Age.getBounds().y-2,200, Fname.getBounds().height+5);
        age.setFont(f2);
        age.setForeground(Color.decode("#f5fca5"));
        frame.add(age);
        
        
        Phone = new JLabel("Phone :");
        Phone.setBounds(age.getBounds().x + age.getBounds().width+100, Age.getBounds().y,age.getBounds().width, Fname.getBounds().height+5);
        Phone.setFont(f);
        Phone.setForeground(Color.white);
        frame.add(Phone);
        
        phone = new JLabel("any name");
        phone.setBounds(Phone.getBounds().x+Phone.getBounds().width-122, Phone.getBounds().y-2,200, Fname.getBounds().height+5);
        phone.setFont(f2);
        phone.setForeground(Color.decode("#f5fca5"));
        frame.add(phone);
        
        
        ID = new JLabel("ID   :");
        ID.setBounds(Fname.getBounds().x, phone.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        ID.setFont(f);
        ID.setForeground(Color.white);
        frame.add(ID);
        
        id = new JLabel("any name");
        id.setBounds(Fname.getBounds().x+ID.getBounds().width-15, ID.getBounds().y-2,200, Fname.getBounds().height+5);
        id.setFont(f2);
        id.setForeground(Color.decode("#f5fca5"));
        frame.add(id);
        
        
        Gander = new JLabel("Gander :");
        Gander.setBounds(age.getBounds().x + age.getBounds().width+100, id.getBounds().y,age.getBounds().width, Fname.getBounds().height+5);
        Gander.setFont(f);
        Gander.setForeground(Color.white);
        frame.add(Gander);
        
        gander = new JLabel("any name");
        gander.setBounds(Gander.getBounds().x+Gander.getBounds().width-100, Gander.getBounds().y-2,100, Fname.getBounds().height+5);
        gander.setFont(f2);
        gander.setForeground(Color.decode("#f5fca5"));
        frame.add(gander);
        
        Address = new JLabel("Address :");
        Address.setBounds(Fname.getBounds().x, gander.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Address.setFont(f);
        Address.setForeground(Color.white);
        frame.add(Address);
        
        address = new JLabel("any name");
        address.setBounds(Address.getBounds().x+ID.getBounds().width-15, Address.getBounds().y-2,500, Fname.getBounds().height+5);
        address.setFont(f2);
        address.setForeground(Color.decode("#f5fca5"));
        frame.add(address);
        
        Email = new JLabel("Email :");
        Email.setBounds(Fname.getBounds().x, address.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Email.setFont(f);
        Email.setForeground(Color.white);
        frame.add(Email);
        
        mail = new JLabel("any name");
        mail.setBounds(Address.getBounds().x+ID.getBounds().width-15, Email.getBounds().y-2,400, Fname.getBounds().height+5);
        mail.setFont(f2);
        mail.setForeground(Color.decode("#f5fca5"));
        frame.add(mail);
        
        Jop = new JLabel("Job :");
        Jop.setBounds(Fname.getBounds().x, Email.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Jop.setFont(f);
        Jop.setForeground(Color.white);
        frame.add(Jop);
        
        jop = new JLabel("any name");
        jop.setBounds(Address.getBounds().x+ID.getBounds().width-15, Jop.getBounds().y-2,200, Fname.getBounds().height+5);
        jop.setFont(f2);
        jop.setForeground(Color.decode("#f5fca5"));
        frame.add(jop);
        
        Country = new JLabel("Country :");
        Country.setBounds(age.getBounds().x + age.getBounds().width+90, Jop.getBounds().y,age.getBounds().width, Fname.getBounds().height+5);
        Country.setFont(f);
        Country.setForeground(Color.white);
        frame.add(Country);
        
        cuntry = new JLabel("any name");
        cuntry.setBounds(phone.getBounds().x+18, Country.getBounds().y-2,150, Fname.getBounds().height+5);
        cuntry.setFont(f2);
        cuntry.setForeground(Color.decode("#f5fca5"));
        frame.add(cuntry);
        
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
    
}
