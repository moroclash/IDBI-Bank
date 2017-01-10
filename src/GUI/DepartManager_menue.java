
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import Managment.Employee;
import Managment.BranchManager2;
import java.io.IOException;
import javax.swing.JOptionPane;

public class DepartManager_menue extends Employee_std_menue{
    private JButton show_all_employee,show_statistics,log_on;
    private Employee man;
    public DepartManager_menue(Employee man) {
        
        this.man = man;
        
        show_all_employee = new JButton("Show all Employee");
        show_all_employee.setFont(f);
        show_all_employee.setBackground(Color.decode("#f7ae57"));
        show_all_employee.setBorder(null);
        show_all_employee.setBorderPainted(false);
        show_all_employee.addMouseListener(this);
        show_all_employee.addActionListener(this);
        form.add(show_all_employee);
        
        
        
        show_statistics = new JButton("Show Statistics");
        show_statistics.setFont(f);
        show_statistics.setBackground(Color.decode("#f7ae57"));
        show_statistics.setBorder(null);
        show_statistics.setBorderPainted(false);
        show_statistics.addMouseListener(this);
        show_statistics.addActionListener(this);
        form.add(show_statistics);
        
        
        
        log_on = new JButton("Log on");
        log_on.setFont(f);
        log_on.setBackground(Color.decode("#f7ae57"));
        log_on.setBorder(null);
        log_on.setBorderPainted(false);
        log_on.addMouseListener(this);
        log_on.addActionListener(this);
        form.add(log_on);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object x = e.getSource();
         if(x.equals(sinout))
        {
            sinout.setBackground(Color.decode("#2baff3"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statistics.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(ShowMyProfile))
        {
            ShowMyProfile.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statistics.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(creat))
        {
            creat.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statistics.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(search))
        {
            search.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statistics.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(show_all_employee))
        {
            show_all_employee.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_statistics.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(show_statistics))
        {
            show_statistics.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(log_on))
        {
            log_on.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statistics.setBackground(Color.decode("#f7ae57"));
        }
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if(x.equals(sinout))
        {
            dispose();
            log_in exit = new log_in();
            exit.setVisible(true);
        }
        else if(x.equals(ShowMyProfile))
        {
          Show_Employee q = new Show_Employee("My Profile",man);
          q.reset.setVisible(false);
          q.Flage = 'T' ;
          
          q.address.setText(man.getAddress());
          q.age.setText(man.getAge());
          q.branch.setText(man.getBranch());
          q.cuntry.setText(man.getCountry());
          q.dpart.setText(man.getTellerDept());
          q.mail.setText(man.getEmail());
          q.fname.setText(man.getFname()+" "+man.getlname());
          q.gander.setText(man.getGender());
          q.id.setText(Integer.toString(man.getID()));
          q.jop.setText(man.getJobLevel());
          q.phone.setText(man.getPhone());
          q.salary.setText(man.getSalary());
          q.ssn.setText(man.getSSN());
          q.username.setText(man.getUsername());
          components.removeAll();
          components.add(q.getmainform());
          components.repaint();
        }
        else if(x.equals(creat))
        {
          components.removeAll();
          components.add(new Dept_Manager_Creat(man).getmainform());
          components.repaint();
        }
        else if(x.equals(search))
        {
          components.removeAll();
          components.add(new DepartManager_Search().getmainform());
          components.repaint();
        }
        else if(x.equals(show_all_employee))
        {
            try {
                 Show_table q = new Show_table("All Manager", new BranchManager2().showAllEmployees(), man.getTellerDept(),'E');
                q.Flage = 'E';
                components.removeAll();
                components.add(q.getmainform());
                components.repaint();
            } catch (IOException|ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "8lt whwaa pyrg3 el hash map pta3et show all employee at Department");
            } 
        }
        else if(x.equals(show_statistics))
        {
        
        
        }
        else if(x.equals(log_on))
        {
        
        
        }
        
    }
    
    
}
