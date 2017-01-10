
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import MainArchitecture.Account;
import MainArchitecture.ComponyAccount;
import MainArchitecture.Customer;
import MainArchitecture.PersonalAccount;
import MainArchitecture.Teller;
import Managment.History;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class New_Account extends standerForm{

    protected JLabel AccountNumper,Username,Passward,OwnerID,Profit,Balance,CustomerType,OwnerSsn,Agpassword,Companyname,Loction,Companyphone;
    protected JTextField accountnumper,username,ownerid,balance,ownerssn,companyname,companyphone,location;
    protected JPasswordField agpassword,passward;
    protected JComboBox AccountType,profit; 
    protected char Flage;  //check if account is personal'p' or CompanyAccount'C'
    protected Object  man;
    public New_Account(String s,Object man) {
        super(s);
        this.man=man;
        submit.setText("Creat");
        setFont("Adobe Gurmukhi", 1, 19);
        
        AccountNumper = new JLabel("AccountNumper");
        AccountNumper.setBounds(23, 70, 150 , 20);
        AccountNumper.setFont(f);
        AccountNumper.setForeground(Color.white);
      //  frame.add(AccountNumper);
        
        
        accountnumper = new JTextField(20);
        accountnumper.setBounds(AccountNumper.getBounds().x+AccountNumper.getBounds().width,AccountNumper.getBounds().y,250,20);
    //    frame.add(accountnumper);
        
        
        Username = new JLabel("Username");
        Username.setBounds(AccountNumper.getBounds().x+30,AccountNumper.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        Username.setFont(f);
        Username.setForeground(Color.white);
        frame.add(Username);
        
        username = new JTextField(20);
        username.setBounds(accountnumper.getBounds().x,Username.getBounds().y,accountnumper.getBounds().x-50,accountnumper.getBounds().height);
        frame.add(username);

        
        Passward  = new JLabel("Passward");
        Passward.setBounds(username.getBounds().x +username.getBounds().width+40,username.getBounds().y, AccountNumper.getBounds().width+20, AccountNumper.getBounds().height);
        Passward.setFont(f);
        Passward.setForeground(Color.white);
        frame.add(Passward);
        
        passward = new JPasswordField(10);
        passward.setBounds(Passward.getBounds().x+Passward.getBounds().width-50,username.getBounds().y,accountnumper.getBounds().x-50,accountnumper.getBounds().height);
        frame.add(passward);
        
        OwnerID = new JLabel("OwnerID");
        OwnerID.setBounds(Username.getBounds().x,Username.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        OwnerID.setFont(f);
        OwnerID.setForeground(Color.white);
        frame.add(OwnerID);
        
        
        ownerid = new JTextField(10);
        ownerid.setBounds(username.getBounds().x,OwnerID.getBounds().y,accountnumper.getBounds().x-50,accountnumper.getBounds().height);
        frame.add(ownerid);
        
        Agpassword = new JLabel("Password");
        Agpassword.setBounds(Passward.getBounds().x,OwnerID.getBounds().y, ownerid.getBounds().width+20, AccountNumper.getBounds().height);
        Agpassword.setFont(f);
        Agpassword.setForeground(Color.white);
        frame.add(Agpassword);
        
        agpassword = new JPasswordField(10);
        agpassword.setBounds(passward.getBounds().x,Agpassword.getBounds().y,accountnumper.getBounds().x-50,accountnumper.getBounds().height);
        frame.add(agpassword);
        
        
        
        OwnerSsn  = new JLabel("Owner Ssn");
        OwnerSsn.setBounds(Username.getBounds().x,OwnerID.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        OwnerSsn.setFont(f);
        OwnerSsn.setForeground(Color.white);
        frame.add(OwnerSsn);
        
        ownerssn = new JTextField(20);
        ownerssn.setBounds(username.getBounds().x,OwnerSsn.getBounds().y,accountnumper.getBounds().x-50,accountnumper.getBounds().height);
        frame.add(ownerssn);
        
        
        CustomerType = new JLabel("CustomerType");
        CustomerType.setBounds(Passward.getBounds().x,OwnerSsn.getBounds().y, OwnerSsn.getBounds().width, AccountNumper.getBounds().height);
        CustomerType.setFont(f);
        CustomerType.setForeground(Color.white);
        frame.add(CustomerType);
        
        
        AccountType = new JComboBox(new String[]{"General","Vip"});
        AccountType.setBounds(passward.getBounds().x,CustomerType.getBounds().y,accountnumper.getBounds().x-50,accountnumper.getBounds().height);
        frame.add(AccountType);
        
        
        
        Profit = new JLabel("Profit");
        Profit.setBounds(Username.getBounds().x,OwnerSsn.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        Profit.setFont(f);
        Profit.setForeground(Color.white);
        frame.add(Profit);
        
        
        profit = new JComboBox(new String[]{"%5","%6","%7","%8","%9","%10"});
        profit.setBounds(username.getBounds().x,Profit.getBounds().y,accountnumper.getBounds().x-50,accountnumper.getBounds().height);
        frame.add(profit);
        
        
        Balance = new JLabel("Balance");
        Balance.setBounds(Username.getBounds().x,Profit.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        Balance.setFont(f);
        Balance.setForeground(Color.white);
        frame.add(Balance);
        
        balance = new JTextField(100);
        balance.setBounds(username.getBounds().x,Balance.getBounds().y,accountnumper.getBounds().x-20,accountnumper.getBounds().height);
        frame.add(balance);
        
        
        
        Companyname = new JLabel("CompanyName");
        Companyname.setBounds(Balance.getBounds().x-25,Balance.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        Companyname.setFont(f);
        Companyname.setForeground(Color.white);
        frame.add(Companyname);
        
        companyname = new JTextField(100);
        companyname.setBounds(balance.getBounds().x,Companyname.getBounds().y,accountnumper.getBounds().x,accountnumper.getBounds().height);
        frame.add(companyname);
        
        Loction = new JLabel("Location");
        Loction.setBounds(Balance.getBounds().x-25,companyname.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        Loction.setFont(f);
        Loction.setForeground(Color.white);
        frame.add(Loction);
        
        location = new JTextField(100);
        location.setBounds(balance.getBounds().x,Loction.getBounds().y,accountnumper.getBounds().x+100,accountnumper.getBounds().height);
        frame.add(location);
        
        Companyphone = new JLabel("CompanyPhone");
        Companyphone.setBounds(Loction.getBounds().x-10,Loction.getBounds().y+40, AccountNumper.getBounds().width, AccountNumper.getBounds().height);
        Companyphone.setFont(f);
        Companyphone.setForeground(Color.white);
        frame.add(Companyphone);
        
        companyphone = new JTextField(100);
        companyphone.setBounds(balance.getBounds().x,Companyphone.getBounds().y,accountnumper.getBounds().x-20,accountnumper.getBounds().height);
        frame.add(companyphone);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
           if(Flage == 'P')   // if personal Acc
           {
             if(username.getText().equals("")||passward.getText().equals("")||ownerid.getText().equals("")||balance.getText().equals("")||ownerssn.getText().equals(""))
                    massage.setText("*Please Enter All Form");
             else
             {
                 if (man instanceof PersonalAccount)
                 {
                 PersonalAccount x = (PersonalAccount) man;
                //man.setAccountNum(Long.parseLong(accountnumper.getText()));
                x.setMyCutomerType(AccountType.getSelectedItem().toString());
                x.setBalance(Double.parseDouble(balance.getText()));
                x.setProfit(profit.getSelectedItem().toString());
                x.setUsername(username.getText());
                 try {  
                     System.out.println("0");
                     x.setMyOwner(Integer.parseInt(ownerid.getText()));
                     System.out.println("2");
                     boolean f =false;
                     System.out.println("3");
                char[]p = passward.getPassword(); 
                System.out.println("4");
                char[]p2 = agpassword.getPassword();
                System.out.println("5");
                         if(p.length != 0 && p2.length != 0)
                         {
                                       System.out.println("6");
                                     if(Arrays.equals(p, p2))
                                     {
                                        System.out.println("7");
                                        x.setPassward(p);
                                        System.out.println("8");
                                        f = true;
                                         try {
                                                if(e.getActionCommand().equals("Update"))
                                                 new Teller().DeleteAccount(Long.parseLong(accountnumper.getText()));
                                                 new Teller().addAccount(x);
                                                 massage.setForeground(Color.GREEN);
                                                 massage.setText("*Success");
                                                 reset();
                                         } catch (ClassNotFoundException|IOException ex) {
                                                massage.setText("*Soory can't connect with system");
                                         } 
                                     }
                                     else
                                     {
                                         massage.setText("*password is inValid");
                                     }
                         }
                 } catch (Exception ex) {
                            System.out.println(ex);//massage.setText("*4o8lyy payez");
                 }
                 }
                
            }
           }
           else if(Flage == 'C') //if Company Acc
           {
               if(location.getText().equals("")||companyphone.getText().equals("")||companyname.getText().equals("")||username.getText().equals("")||passward.getText().equals("")||ownerid.getText().equals("")||balance.getText().equals("")||ownerssn.getText().equals(""))
                    massage.setText("*Please Enter All Form");
               else
                {
                 if(man instanceof ComponyAccount)
                 {
                ComponyAccount me = (ComponyAccount) man;
                me.setAccountNum(Long.parseLong(accountnumper.getText()));
                me.setMyCutomerType(AccountType.getSelectedItem().toString());
                me.setBalance(Double.parseDouble(balance.getText()));
                me.setProfit(profit.getSelectedItem().toString());
                me.setUsername(username.getText());
                   try {
                            me.setMyOwner(Integer.parseInt(ownerid.getText()));
                            me.setCompanyName(companyname.getText());
                            me.setTelephone(companyphone.getText());
                            me.setLocation(location.getText());
                            boolean f =false;
                            char[]p = passward.getPassword();                  
                            char[]p2 = agpassword.getPassword();
                            if(p.length != 0 && p2.length != 0)
                         {
                                     if(Arrays.equals(p, p2))
                                     {
                                        me.setPassward(p);
                                        f = true;
                                         try {
                                                if(e.getActionCommand().equals("Update"))
                                                        new Teller().DeleteAccount(Long.parseLong(accountnumper.getText()));
                                                 new Teller().addAccount(me);
                                                 massage.setForeground(Color.GREEN);
                                                 massage.setText("*Success");
                                                 reset();
                                         } catch (ClassNotFoundException|IOException ex) {
                                                massage.setText("*Soory can't connect with system");
                                         } 
                                     }
                                     else
                                     {
                                         massage.setText("*password is inValid");
                                     }
                         }
                   } catch (Exception ex) {
                            massage.setText("*4o8lyy payez");
                   }
                
                 }
                    System.out.println("0000");
               }
           }
              
           
        }       
        else if(e.getSource()==reset)
        {
            reset();
        }
    }
    
    
    private void reset()
    {
            accountnumper.setText("");
            username.setText("");
            passward.setText("");
            ownerid.setText("");
            balance.setText("");
            ownerssn.setText("");
            agpassword.setText("");
            companyname.setText("");
            companyphone.setText("");
            location.setText("");
    }
    
}
