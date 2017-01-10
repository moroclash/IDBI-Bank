package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import Managment.BranchManager2;
import Managment.Employee;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import java.util.HashMap;


public class Pranch_Manager_menu extends Employee_std_menue{

    private JButton show_statisics,show_all_Managers,show_all_employee,log_on;
    private BranchManager2 man;
    
    public Pranch_Manager_menu()
    {
        show_all_employee = new JButton("Show all Employee");
        show_all_employee.setFont(f);
        show_all_employee.setBackground(Color.decode("#f7ae57"));
        show_all_employee.setBorder(null);
        show_all_employee.setBorderPainted(false);
        show_all_employee.addMouseListener(this);
        show_all_employee.addActionListener(this);
        form.add(show_all_employee);
        
        
        show_all_Managers = new JButton("Show all Managers");
        show_all_Managers.setFont(f);
        show_all_Managers.setBackground(Color.decode("#f7ae57"));
        show_all_Managers.setBorder(null);
        show_all_Managers.setBorderPainted(false);
        show_all_Managers.addMouseListener(this);
        show_all_Managers.addActionListener(this);
        form.add(show_all_Managers);
        
        
        show_statisics = new JButton("Show Statistics");
        show_statisics.setFont(f);
        show_statisics.setBackground(Color.decode("#f7ae57"));
        show_statisics.setBorder(null);
        show_statisics.setBorderPainted(false);
        show_statisics.addMouseListener(this);
        show_statisics.addActionListener(this);
        form.add(show_statisics);
        
        
        
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
            show_statisics.setBackground(Color.decode("#f7ae57"));
            show_all_Managers.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));  
        }
        else if(x.equals(ShowMyProfile))
        {
            ShowMyProfile.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statisics.setBackground(Color.decode("#f7ae57"));
            show_all_Managers.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(creat))
        {
            creat.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statisics.setBackground(Color.decode("#f7ae57"));
            show_all_Managers.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else  if(x.equals(search))
        {
            search.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_statisics.setBackground(Color.decode("#f7ae57"));
            show_all_Managers.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
        else   if(x.equals(show_all_employee))
        {
            show_all_employee.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_statisics.setBackground(Color.decode("#f7ae57"));
            show_all_Managers.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(show_statisics))
        {
            show_statisics.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_all_Managers.setBackground(Color.decode("#f7ae57"));
            log_on.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(show_all_Managers))
        {
            show_all_Managers.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            show_statisics.setBackground(Color.decode("#f7ae57"));
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
            show_statisics.setBackground(Color.decode("#f7ae57"));
            show_all_employee.setBackground(Color.decode("#f7ae57"));
            show_all_Managers.setBackground(Color.decode("#f7ae57"));
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
          Show_Employee q =  new Show_Employee("My profile",new Employee());
            q.Flage = 'T';
            q.address.setText("7 st, Osama El-Abiad, Giza");
            q.age.setText("20");
            q.cuntry.setText("Egypt");
            q.mail.setText("TahaMagdy@fcih.helwan.edu.eg");
            q.fname.setText("Taha" + " Magdy");
            q.gander.setText("Mall");
            q.id.setText("2");
            q.jop.setText("SW.Egineer");
//            q.password.setText("taha123");
            q.phone.setText("01148462144");
            q.username.setText("taha_admin");
            q.ssn.setText("2960222100552");
            q.salary.setText("1.5 EL");
            q.branch.setText("El Zamalek");
            q.Dpart.setVisible(false);
            q.dpart.setVisible(false);
            q.reset.setVisible(false);
            q.submit.setVisible(false);
            components.removeAll();
            components.add(q.getmainform());
            components.repaint();
        }
        else if(x.equals(creat))
        {
          components.removeAll();
          components.add(new Pranch_manager_Creat().getmainform());
          components.repaint();
        }
        else if(x.equals(search))
        {
          components.removeAll();
          components.add(new PranshManager_Search().getmainform());
          components.repaint();
        }
        else if(x.equals(show_all_Managers))
        {
            try {
                 HashMap< Integer, Object> data= new BranchManager2().showAllEmployees();
                 Show_table q = new Show_table("All Manager",data, "" , 'M');
                 components.removeAll();
                 components.add(q.getmainform());
                 components.repaint();
            } catch (IOException|ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "8lt whwaa pyrg3 el hash map pta3et show all Manager");
            } 
        }
        else if(x.equals(show_all_employee))
        {
            try {
                Show_table q = new Show_table("All Employee", new BranchManager2().showAllEmployees(), "",'E');
                components.repaint();
                components.removeAll();
                components.add(q.getmainform());
                components.repaint();
            } catch (IOException|ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "8lt whwaa pyrg3 el hash map pta3et show all employee");
            } 
        }
        else if(x.equals(show_statisics))
        {
        
            dispose();
            Circle_grafe q = new Circle_grafe("Statistic", "Customer Number", "Employee Number", "Withdraws", "Deposits", 500, 30, 40, 60);
            q.setSize(500, 500);
            //q.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            q.setLocationRelativeTo(null);
            q.setVisible(true);
        }
        else if(x.equals(log_on))
        {
             Search_histry q = new Search_histry();
             components.removeAll();
             components.add(q.getmainform());
             components.repaint();
        }
    }
    
}
