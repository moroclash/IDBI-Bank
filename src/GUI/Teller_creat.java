
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import MainArchitecture.Account;
import MainArchitecture.ComponyAccount;
import MainArchitecture.PersonalAccount;

public class Teller_creat extends Button_3{

    public Teller_creat() {
        super("New Account","New Buisenes Account", "New Customer");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
    }

    @Override
    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            New_Account q = new New_Account("New Personal Account",new PersonalAccount());
            q.Flage = 'P'; //personal account
            q.companyname.setVisible(false);
            q.Companyname.setVisible(false);
            q.Companyphone.setVisible(false);
            q.companyphone.setVisible(false);
            q.location.setVisible(false);
            q.Loction.setVisible(false);
            
            mainform.removeAll();
            mainform.add(q.getmainform());
            mainform.repaint();
        }
        else if(e.getSource() == b2)
        {
            New_Account q = new New_Account("New Company Account",new ComponyAccount());
            q.Flage = 'C';
            mainform.removeAll();
            mainform.add(q.getmainform());
            mainform.repaint();
        }
        else if(e.getSource() == b3)
        {
            mainform.removeAll();
            mainform.add(new New_Customer().getmainform());
            mainform.repaint();
        }
    } 

     @Override
    public void mouseEntered(MouseEvent e) {
        Object x = e.getSource();
        if(x.equals(b1))
        {
            b1.setBackground(Color.decode("#3c5b7d"));
        }
        else if(x.equals(b2))
        {
            b2.setBackground(Color.decode("#3c5b7d"));
        }
        else if(x.equals(b3))
        {
            b3.setBackground(Color.decode("#3c5b7d"));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        b1.setBackground(Color.decode("#f89f35"));
        b2.setBackground(Color.decode("#f89f35"));
        b3.setBackground(Color.decode("#f89f35"));
    }
    
}
