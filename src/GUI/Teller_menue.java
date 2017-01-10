
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import Managment.Employee;

public class Teller_menue extends Employee_std_menue{

    private JButton withdraw,deposit,transfer;
    private Employee man;
    public Teller_menue(Employee man) {
        
        this.man = man;
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(f);
        withdraw.setBackground(Color.decode("#f7ae57"));
        withdraw.setBorder(null);
        withdraw.setBorderPainted(false);
        withdraw.addMouseListener(this);
        withdraw.addActionListener(this);
        form.add(withdraw);
        
        
        deposit = new  JButton("Deposit");
        deposit.setFont(f);
        deposit.setBackground(Color.decode("#f7ae57"));
        deposit.setBorder(null);
        deposit.setBorderPainted(false);
        deposit.addMouseListener(this);
        deposit.addActionListener(this);
        form.add(deposit);
        
        
        transfer = new JButton("Transfer");
        transfer.setFont(f);
        transfer.setBackground(Color.decode("#f7ae57"));
        transfer.setBorder(null);
        transfer.setBorderPainted(false);
        transfer.addMouseListener(this);
        transfer.addActionListener(this);
        form.add(transfer);
        
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Object x = e.getSource();
        if(x.equals(creat))
        {
            creat.setBackground(Color.decode("#2baff3"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            deposit.setBackground(Color.decode("#f7ae57"));
        }
        else if(x.equals(withdraw))
        {
            withdraw.setBackground(Color.decode("#2baff3"));
            creat.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            deposit.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(search))
        {
            search.setBackground(Color.decode("#2baff3"));
            creat.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            deposit.setBackground(Color.decode("#f7ae57"));
        }
        else if(x.equals(transfer))
        {
            transfer.setBackground(Color.decode("#2baff3"));
            creat.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            deposit.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(ShowMyProfile))
        {
            ShowMyProfile.setBackground(Color.decode("#2baff3"));
            creat.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            deposit.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(sinout))
        {
            sinout.setBackground(Color.decode("#2baff3"));
            creat.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            deposit.setBackground(Color.decode("#f7ae57"));
        }
         else if(x.equals(deposit))
        {
            deposit.setBackground(Color.decode("#2baff3"));
            creat.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            search.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if(x.equals(sinout))
        {
            super.dispose();
            log_in exit = new log_in();
            exit.setVisible(true);
        }
        else if(x.equals(ShowMyProfile))
        {
          Show_Employee q = new Show_Employee("MY Profile",man);
          
            q.reset.setVisible(false);
            q.Flage = 'T';
            q.address.setText(man.getAddress());
            q.age.setText(man.getAge());
            q.cuntry.setText(man.getCountry());
            q.mail.setText(man.getEmail());
            q.fname.setText(man.getFname() +" "+ man.getlname());
            q.gander.setText(man.getGender());
            q.id.setText(Integer.toString(man.getID()));
            q.jop.setText(man.getJobLevel());
//            q.password.setText("taha123");
            q.phone.setText(man.getPhone());
            q.username.setText(man.getUsername());
            q.ssn.setText(man.getSSN());
            q.salary.setText(man.getSalary());
            q.branch.setText(man.getBranch());
            q.dpart.setText(man.getTellerDept());
            components.removeAll();
            components.add(q.getmainform());
            components.repaint();  
        }
        else if(x.equals(creat))
        {
          components.removeAll();
          components.add(new Teller_creat().getmainform());
          components.repaint();
        }
        else if(x.equals(search))
        {
          components.removeAll();
          components.add(new Teller_Search().getmainform());
          components.repaint();
        }
        else if(x.equals(withdraw))
        {
          components.removeAll();
          components.add(new teller_withdraw().getmainform());
          components.repaint();
        }
        else if(x.equals(deposit))
        {
          components.removeAll();
          components.add(new tellet_deposit().getmainform());
          components.repaint();
        }
        else if(x.equals(transfer))
        {
          components.removeAll();
          components.add(new teller_transfer_form().getmainform());
          components.repaint();
        }
    }
    
}
