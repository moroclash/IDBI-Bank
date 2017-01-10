
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import sun.awt.EmbeddedFrame;
import Managment.Employee;
import MainArchitecture.Account;


public class Dept_Manager_Creat extends Buttons_4{
    private Employee man ;
    public Dept_Manager_Creat(Employee man) {
        super("New Personal Account", "New Besines Account", "New Customer", "New Employee");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
        b4.addMouseListener(this);
        this.man = man;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            New_Account q = new New_Account("New Account",new Account());
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
            New_Account q = new New_Account("New Account",new Account());
            q.Flage = 'C' ; //Company account 
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
        else if(e.getSource() == b4)
        {
            EmoployeeForm q = new EmoployeeForm("New Employee",new Employee());
            q.Joplevl.setVisible(false);
            q.joplvl.setVisible(false);
            q.joplvl.setSelectedItem("Employee");
            q.Department.setVisible(false);
            q.Dept.setVisible(false);
            q.Dept.setSelectedItem(man.getTellerDept());
            mainform.removeAll();
            mainform.add(q.getmainform());
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
        else if(x.equals(b4))
        {
            b4.setBackground(Color.decode("#3c5b7d"));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        b1.setBackground(Color.decode("#f89f35"));
        b2.setBackground(Color.decode("#f89f35"));
        b3.setBackground(Color.decode("#f89f35"));
        b4.setBackground(Color.decode("#f89f35"));
    }
    
}
