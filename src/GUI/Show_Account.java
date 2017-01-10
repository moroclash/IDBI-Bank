
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import MainArchitecture.Account;
import MainArchitecture.Customer;
import MainArchitecture.ComponyAccount;
import MainArchitecture.Teller;
import Managment.History;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Show_Account extends Show_std{
    protected JLabel ID2,id2,Compamnyname,companyname,Loction,loction,CompanyPhone,companyphone;
    private Account man;
    public Show_Account(String s,Account man) {
        super(s);
        this.man = man;
        submit.setText("Update");
        submit.addActionListener(this);
        reset.setText("Delete");
        reset.addActionListener(this);
        
        
        Fname.setText("AccNumber :");
        Age.setText("CusType :");
        Phone.setText("Profit :");
        ID.setText("Balance :");
        
        Address.setText("Owner :");
        Gander.setVisible(false);
        gander.setVisible(false);
        
        ID2 = new JLabel("ID :");
        ID2.setBounds(Gander.getBounds().x, Jop.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        ID2.setFont(f);
        ID2.setForeground(Color.white);
        frame.add(ID2);
        
        id2 = new JLabel("any name");
        id2.setBounds(cuntry.getBounds().x, ID2.getBounds().y-2,200, Fname.getBounds().height+5);
        id2.setFont(f2);
        id2.setForeground(Color.decode("#f5fca5"));
        frame.add(id2);
        
        Username = new JLabel("Username :");
        Username.setBounds(Jop.getBounds().x, Jop.getBounds().y+40,Fname.getBounds().width, Fname.getBounds().height+5);
        Username.setFont(f);
        Username.setForeground(Color.white);
        frame.add(Username);
        
        username = new JLabel("any name");
        username.setBounds(jop.getBounds().x, Username.getBounds().y-2,200, Fname.getBounds().height+5);
        username.setFont(f2);
        username.setForeground(Color.decode("#f5fca5"));
        frame.add(username);
        
        
        Compamnyname = new JLabel("Company name :");
        Compamnyname.setBounds(Username.getBounds().x, Username.getBounds().y+40,Fname.getBounds().width+30, Fname.getBounds().height+5);
        Compamnyname.setFont(f);
        Compamnyname.setForeground(Color.white);
        frame.add(Compamnyname);
        
        companyname = new JLabel("any name");
        companyname.setBounds(Username.getBounds().x+Username.getBounds().width+20, Compamnyname.getBounds().y-2,300, Fname.getBounds().height+5);
        companyname.setFont(f2);
        companyname.setForeground(Color.decode("#f5fca5"));
        frame.add(companyname);
        
        
        Loction = new JLabel("Loction :");
        Loction.setBounds(Compamnyname.getBounds().x, companyname.getBounds().y+40,Fname.getBounds().width+30, Fname.getBounds().height+5);
        Loction.setFont(f);
        Loction.setForeground(Color.white);
        frame.add(Loction);
        
        loction = new JLabel("any name");
        loction.setBounds(username.getBounds().x, Loction.getBounds().y-2,400, Fname.getBounds().height+5);
        loction.setFont(f2);
        loction.setForeground(Color.decode("#f5fca5"));
        frame.add(loction);
        
        
        CompanyPhone = new JLabel("CompanyPhone :");
        CompanyPhone.setBounds(Loction.getBounds().x, Loction.getBounds().y+40,Fname.getBounds().width+30, Fname.getBounds().height+5);
        CompanyPhone.setFont(f);
        CompanyPhone.setForeground(Color.white);
        frame.add(CompanyPhone);
        
        companyphone = new JLabel("any name");
        companyphone.setBounds(companyname.getBounds().x, CompanyPhone.getBounds().y-2,200, Fname.getBounds().height+5);
        companyphone.setFont(f2);
        companyphone.setForeground(Color.decode("#f5fca5"));
        frame.add(companyphone);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if(x.equals(submit))  // to update
        {
            New_Account q = new New_Account("Update",man);
            q.Passward.setText("New Password");
            q.Agpassword.setText("Old Password");
            
            q.accountnumper.setText(Long.toString(man.getAccountNum()));
            Customer owner;
            try {
                owner = man.getMyOwner();
                q.ownerid.setText(Integer.toString(owner.getID()));
                q.ownerssn.setText(owner.getSSN());
                q.balance.setText(Double.toString(man.getBalance()));
                q.profit.setSelectedItem(man.getProfit());
                q.username.setText(man.getUsername());
                q.Flage ='P';
            } catch (IOException|ClassNotFoundException ex) {
                Logger.getLogger(Show_Account.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(Flage == 'C')
            {
                q.Flage = 'C';
                ComponyAccount myaccount = (ComponyAccount) man;
                q.companyname.setText(myaccount.getComanyName());
                q.companyphone.setText(myaccount.getTelephone());
                q.location.setText(myaccount.getLoacation());
            }
            
            q.passward.setText(man.getPassward().toString());
            q.agpassword.setText(man.getPassward().toString());

            
            if(Flage == 'P'|| Flage=='C')   //if account is personal or company acc
            {
                    q.AccountNumper.setVisible(false);
                    q.accountnumper.setVisible(false);

                    q.OwnerID.setVisible(false);
                    q.ownerid.setVisible(false);
       
                    q.OwnerSsn.setVisible(false);
                    q.ownerssn.setVisible(false);

                    q.CustomerType.setVisible(false);
                    q.AccountType.setVisible(false);
                    
                    q.Balance.setVisible(false);
                    q.balance.setVisible(false);
                   
                    q.Profit.setVisible(false);
                    q.profit.setVisible(false);
                    
                    q.companyname.setVisible(false);
                    q.Companyname.setVisible(false);
                    
                    q.companyphone.setVisible(false);
                    q.Companyphone.setVisible(false);

                    q.location.setVisible(false);
                    q.Loction.setVisible(false);
                    
                    if(Flage == 'C')
                    {
                        q.companyphone.setVisible(true);
                        q.Companyphone.setVisible(true);

                        q.location.setVisible(true);
                        q.Loction.setVisible(true);
                    }
                   
            }
             else if(Flage == 'T')
            {
                    
                    q.AccountNumper.setVisible(false);
                    q.accountnumper.setVisible(false);

                    q.Balance.setVisible(false);
                    q.balance.setVisible(false);
           }
            
                    q.submit.setText("Update");
                    q.reset.setVisible(false);
                    
                    mainfram.removeAll();
                    mainfram.add(q.getmainform());
                    mainfram.repaint();
        }
        else if(e.getSource() == reset) //to deleate
        {
            int i = JOptionPane.showConfirmDialog(this, "Are You shure ?", "Delet Account", 0);
            if(i == 0)
            {
                try {
                    new Teller().DeleteAccount(man.getAccountNum());
                    massage.setForeground(Color.green);
                    massage.setText("*Success");
                    } catch (ClassNotFoundException|IOException ex) {
                        massage.setText("*sory can't connect with system");
                    } catch (Exception ex) {
                     massage.setText("*el lt mn 3ndnaaa");
                    }
            }
        }
        
    }
    
}
