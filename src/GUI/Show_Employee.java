
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import Managment.Employee;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Managment.BranchManager2;
import Managment.History;

public class Show_Employee extends Show_std{

    protected JLabel Salary,salary,Branch,branch,Dpart,dpart,Ssn,ssn ;
    private Employee man;
    public Show_Employee(String s,Employee man) {
        super(s);
        this.man=man;
        Branch = new JLabel("Branch :");
        Branch.setBounds(Jop.getBounds().x, Jop.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Branch.setFont(f);
        Branch.setForeground(Color.white);
        frame.add(Branch);
        
        branch = new JLabel("any name");
        branch.setBounds(jop.getBounds().x, Branch.getBounds().y-2,170, Fname.getBounds().height+5);
        branch.setFont(f2);
        branch.setForeground(Color.decode("#f5fca5"));
        frame.add(branch);
        
        
        Salary = new JLabel("Salary :");
        Salary.setBounds(Country.getBounds().x, Branch.getBounds().y,Fname.getBounds().width, Fname.getBounds().height+5);
        Salary.setFont(f);
        Salary.setForeground(Color.white);
        frame.add(Salary);
        
        salary = new JLabel("any name");
        salary.setBounds(gander.getBounds().x-10, Salary.getBounds().y-2,170, Fname.getBounds().height+5);
        salary.setFont(f2);
        salary.setForeground(Color.decode("#f5fca5"));
        frame.add(salary);
        
        
        Ssn = new JLabel("Ssn :");
        Ssn.setBounds(Branch.getBounds().x, Branch.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Ssn.setFont(f);
        Ssn.setForeground(Color.white);
        frame.add(Ssn);
        
        ssn = new JLabel("any name");
        ssn.setBounds(jop.getBounds().x, Ssn.getBounds().y-2,300, Fname.getBounds().height+5);
        ssn.setFont(f2);
        ssn.setForeground(Color.decode("#f5fca5"));
        frame.add(ssn);
        
        Dpart = new JLabel("Department :");
        Dpart.setBounds(Country.getBounds().x, Ssn.getBounds().y,Fname.getBounds().width+20, Fname.getBounds().height+5);
        Dpart.setFont(f);
        Dpart.setForeground(Color.white);
        frame.add(Dpart);
        
        dpart = new JLabel("any name");
        dpart.setBounds(Dpart.getBounds().x+Dpart.getBounds().width-50, Dpart.getBounds().y-2,100, Fname.getBounds().height+5);
        dpart.setFont(f2);
        dpart.setForeground(Color.decode("#f5fca5"));
        frame.add(dpart);
        
        Username = new JLabel("Username :");
        Username.setBounds(Branch.getBounds().x, ssn.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Username.setFont(f);
        Username.setForeground(Color.white);
        frame.add(Username);
        
        username = new JLabel("any name");
        username.setBounds(ssn.getBounds().x, Username.getBounds().y-2,200, Fname.getBounds().height+5);
        username.setFont(f2);
        username.setForeground(Color.decode("#f5fca5"));
        frame.add(username);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if(x.equals(submit)) //to update
        {
            Employee myteller = man;
            EmoployeeForm  q= new EmoployeeForm("Update My Profile",man);
            q.flage = 'U';
            q.submit.setText("Update");
            q.reset.setVisible(false); 
            q.fnam.setText(myteller.getFname());
            q.lnam.setText(myteller.getlname());
            q.email.setText(myteller.getEmail());
            q.age.setText(myteller.getAge());
            q.address.setText(myteller.getAddress());
            q.phon.setText(myteller.getPhone());
            q.country.setText(myteller.getCountry());
            q.salary.setText(myteller.getSalary());
            q.joplvl.setSelectedItem(myteller.getJobLevel());
            q.Dept.setSelectedItem(myteller.getTellerDept());
            q.username.setText(myteller.getUsername());
            if(myteller.getGender().equals("Male"))
               q.Male.setSelected(true);
            else 
               q.Female.setSelected(true);
            q.id.setText(Integer.toString(myteller.getID()));
            q.ssn.setText(myteller.getSSN());
            
            if(Flage == 'T') // to update
            {
                q.ssn.setVisible(false);
                q.Ssn.setVisible(false);

                q.id.setVisible(false);
                q.Id.setVisible(false);

                q.salary.setVisible(false);
                q.Sallary.setVisible(false);

                q.Department.setVisible(false);
                q.Dept.setVisible(false);
                q.Joplevl.setVisible(false);
                q.joplvl.setVisible(false);
            }
            else if(Flage == 'D')
            {
                q.ssn.setVisible(false);
                q.Ssn.setVisible(false);
               
                q.id.setVisible(false);
                q.Id.setVisible(false);
            }
            
            mainfram.removeAll();
            mainfram.add(q.getmainform());
            mainfram.repaint();
        }
        else if(x.equals(reset)) //to delet
        {
           int check = JOptionPane.showConfirmDialog(this, "Are you sure?", "Delete",0); //taha ely 2ly
           if(check == 0) //press ok
           {
               try {
                   new BranchManager2().deleteEmployee(man.getID());
                   massage.setForeground(Color.GREEN);
                   massage.setText("*Delete is Success");
               } catch (IOException|ClassNotFoundException ex) {
                   massage.setText("sory can't connect with server");
               } 
           }
           
        }
    }
    
    
    
}
