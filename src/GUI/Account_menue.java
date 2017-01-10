package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import MainArchitecture.Account;
import MainArchitecture.ComponyAccount;
import MainArchitecture.PersonalAccount;
import MainArchitecture.Customer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account_menue extends menuFormStander implements MouseListener{

    private JButton Mypalance,withdraw,transfer,repayloan;
    private Account man;
    public Account_menue(Account man)
    {
        this.man = man;
        
        Mypalance = new JButton("MyPalance");
        Mypalance.setFont(f);
        Mypalance.setBackground(Color.decode("#f7ae57"));
        Mypalance.setBorder(null);
        Mypalance.setBorderPainted(false);
        Mypalance.addMouseListener(this);
        Mypalance.addActionListener(this);
        form.add(Mypalance);
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(f);
        withdraw.setBackground(Color.decode("#f7ae57"));
        withdraw.setBorder(null);
        withdraw.setBorderPainted(false);
        withdraw.addMouseListener(this);
        withdraw.addActionListener(this);
        form.add(withdraw);
        
        
        transfer = new JButton("Transfer");
        transfer.setFont(f);
        transfer.setBackground(Color.decode("#f7ae57"));
        transfer.setBorder(null);
        transfer.setBorderPainted(false);
        transfer.addMouseListener(this);
        transfer.addActionListener(this);
        form.add(transfer);
        
        repayloan = new JButton("Repay Loan");
        repayloan.setFont(f);
        repayloan.setBackground(Color.decode("#f7ae57"));
        repayloan.setBorder(null);
        repayloan.setBorderPainted(false);
        repayloan.addMouseListener(this);
        repayloan.addActionListener(this);
        form.add(repayloan);   
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
                Show_Account q  = new Show_Account("My Preofile",man);
                q.reset.setVisible(false);
                q.Flage = 'C';    // make flage c "Company Acc"
                q.fname.setText(Long.toString(man.getAccountNum()));
                q.age.setText(man.getMyCustomerType());
                q.phone.setText(man.getProfit());
                q.id.setText(Double.toString(man.getBalance()));
                Customer me;
            try {
                me = man.getMyOwner();
                q.address.setText(me.getFname() + " "+me.getlname());
                q.id2.setText(Integer.toString(me.getID()));
                q.username.setText(man.getUsername());
                q.mail.setText(me.getEmail());
                q.jop.setText(me.getJop());
                q.cuntry.setText(me.getCountry());
            } catch (IOException|ClassNotFoundException ex) {
                    //most7yyyyl y7saaal;
            }
                
                
                if(man instanceof ComponyAccount)
                {
                    ComponyAccount company = (ComponyAccount) man;
                    q.companyname.setText(company.getComanyName());
                    q.companyphone.setText(company.getTelephone());
                    q.loction.setText(company.getLoacation());
                }
                else if(man instanceof PersonalAccount)
                {
                    q.reset.setVisible(false);
                    q.Flage = 'P';       // make flage p "personal Acc"
                    q.Compamnyname.setVisible(false);
                    q.companyname.setVisible(false);
                    q.CompanyPhone.setVisible(false);
                    q.companyphone.setVisible(false);
                    q.Loction.setVisible(false);
                    q.loction.setVisible(false);
                }
                q.submit.setText("Update");
                components.removeAll();
                components.add(q.getmainform());
                components.repaint();
         }
        else if(x.equals(withdraw))
        {
          components.removeAll();
          components.add(new Account_withdraw(man).getmainform());
          components.repaint();
            
        }
        else if(x.equals(transfer))
        {
          components.removeAll();
          components.add(new Account_transfer(man).getmainform());
          components.repaint();
        
        }
        else if(x.equals(repayloan))
        {
        
            
        }
        else if(x.equals(Mypalance))
        {
          components.removeAll();
          components.add(new MY_Balance(Double.toString(man.getBalance())).getmainform());
          components.repaint();
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Object x = e.getSource();
        if(x.equals(withdraw))
        {
            withdraw.setBackground(Color.decode("#2baff3"));
            repayloan.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            Mypalance.setBackground(Color.decode("#f7ae57"));
        }
        else if(x.equals(transfer))
        {
            transfer.setBackground(Color.decode("#2baff3"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            repayloan.setBackground(Color.decode("#f7ae57"));
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            Mypalance.setBackground(Color.decode("#f7ae57"));
        }
        else if(x.equals(repayloan))
        {
            repayloan.setBackground(Color.decode("#2baff3"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57")); 
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
            Mypalance.setBackground(Color.decode("#f7ae57"));
        
        }else if(x.equals(ShowMyProfile))
        {
            ShowMyProfile.setBackground(Color.decode("#2baff3"));
            sinout.setBackground(Color.decode("#f7ae57"));
            transfer.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            repayloan.setBackground(Color.decode("#f7ae57"));
            Mypalance.setBackground(Color.decode("#f7ae57"));
        }
        else if(x.equals(sinout))
        {
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#2baff3"));
            transfer.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            repayloan.setBackground(Color.decode("#f7ae57"));
            Mypalance.setBackground(Color.decode("#f7ae57"));
        }
        else if(x.equals(Mypalance))
        {
            ShowMyProfile.setBackground(Color.decode("#f7ae57"));
            Mypalance.setBackground(Color.decode("#2baff3"));
            transfer.setBackground(Color.decode("#f7ae57"));
            withdraw.setBackground(Color.decode("#f7ae57"));
            repayloan.setBackground(Color.decode("#f7ae57"));
            sinout.setBackground(Color.decode("#f7ae57"));
        }
    }

    
 
    
}
