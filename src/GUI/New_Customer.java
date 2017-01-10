
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import MainArchitecture.Customer;
import MainArchitecture.PersonalAccount;
import Managment.BranchManager2;
import MainArchitecture.Teller;
import Managment.History;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;


public class New_Customer extends personForm{
    
    protected JLabel Jop,AccountNum,Balance,Profit,Username,Password,custype;
    protected JTextField jop,accountNum,balance,username;
    protected JPasswordField password;
    private JComboBox CusType,profit;
    protected boolean Flage;
    
    public New_Customer() {
        super("Creat New Customer");
        submit.setText("Creat");
       
        Jop = new JLabel("Jop");
        Jop.setBounds(Phone.getBounds().x,Phone.getBounds().y+40, Fname.getBounds().width , Fname.getBounds().height);
        Jop.setFont(f);
        Jop.setForeground(Color.white);
        personframe.add(Jop);
        
        jop = new JTextField();
        jop = new JTextField("" ,10);
        jop.setBounds(Jop.getBounds().x +Jop.getBounds().width, Jop.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(jop);
        
        Username = new JLabel("Username");
        Username.setBounds(Phone.getBounds().x,jop.getBounds().y+40, Fname.getBounds().width , Fname.getBounds().height);
        Username.setFont(f);
        Username.setForeground(Color.white);
        personframe.add(Username);
        
        
        username = new JTextField();
        username = new JTextField("" ,10);
        username.setBounds(Jop.getBounds().x +Jop.getBounds().width, Username.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(username);
        
        Password = new JLabel("Password");
        Password.setBounds(Country.getBounds().x,Username.getBounds().y, Fname.getBounds().width , Fname.getBounds().height);
        Password.setFont(f);
        Password.setForeground(Color.white);
        personframe.add(Password);
        
        
        password = new JPasswordField();
        password.setBounds(lnam.getBounds().x , Password.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(password);

        AccountNum = new JLabel("AccountNumber");
        AccountNum.setBounds(2,Password.getBounds().y+40, Fname.getBounds().width+30 , Fname.getBounds().height);
        AccountNum.setFont(f);
        AccountNum.setForeground(Color.white);
      //  personframe.add(AccountNum);
        
        accountNum = new JTextField();
        accountNum = new JTextField("" ,10);
        accountNum.setBounds(Jop.getBounds().x +Jop.getBounds().width, AccountNum.getBounds().y-4,phon.getBounds().width, fnam.getBounds().height);
       // personframe.add(accountNum);
        
        custype = new JLabel("CustomerType");
        custype.setBounds(Lname.getBounds().x,AccountNum.getBounds().y, Fname.getBounds().width+30 , Fname.getBounds().height);
        custype.setFont(f);
        custype.setForeground(Color.white);
        personframe.add(custype);
        
        CusType = new JComboBox(new String[]{"General","Vip"});
        CusType.setBounds(lnam.getBounds().x, custype.getBounds().y-4,jop.getBounds().width, fnam.getBounds().height);
        personframe.add(CusType);
        
        
        Balance = new JLabel("Balance");
        Balance.setBounds(Phone.getBounds().x,AccountNum.getBounds().y+40, Fname.getBounds().width+30 , Fname.getBounds().height);
        Balance.setFont(f);
        Balance.setForeground(Color.white);
        personframe.add(Balance);
        
        
        balance = new JTextField();
        balance = new JTextField("" ,10);
        balance.setBounds(Jop.getBounds().x +Jop.getBounds().width, Balance.getBounds().y-4,jop.getBounds().width, fnam.getBounds().height);
        personframe.add(balance);
        
        
        Profit = new JLabel("Profit"); 
        Profit.setBounds(Password.getBounds().x,Balance.getBounds().y, Fname.getBounds().width+30 , Fname.getBounds().height);
        Profit.setFont(f);
        Profit.setForeground(Color.white);
        personframe.add(Profit);
        
        
        
        profit = new JComboBox(new String []{"%5","%6","%7","%8","%9","%10"});
        profit.setBounds(password.getBounds().x , Profit.getBounds().y-4,jop.getBounds().width, fnam.getBounds().height);
        personframe.add(profit);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            if(!Flage&&fnam.getText().equals("")||lnam.getText().equals("")||balance.getText().equals("")||phon.getText().equals("")||address.getText().equals("")||ssn.getText().equals("")||age.getText().equals("")||email.getText().equals("")||Country.getText().equals("")||username.getText().equals("")||password.getText().equals("")||jop.getText().equals(""))
                    massage.setText("*Please Enter All Form");
            else
            {
                Customer man = new Customer();
                PersonalAccount Myacc = new PersonalAccount();
                man.setAddress(address.getText());
                man.setAge(age.getText());
                man.setCountry(country.getText());
                man.setEmail(email.getText());
                man.setFname(fnam.getText());
                man.setGender(Gander.getText());
                man.setPhone(phon.getText());
                man.setSSN(ssn.getText());
                man.setlname(lnam.getText());
                man.SetJop(jop.getText());
                Myacc.setBalance(Double.parseDouble(balance.getText()));
                Myacc.setMyCutomerType(CusType.getSelectedItem().toString());
                Myacc.setPassward(password.getPassword());
                Myacc.setProfit(profit.getSelectedItem().toString());
                Myacc.setUsername(username.getText());
                try {
                    int id = new Teller().addCustomer(man);
                    Myacc.setMyOwner(id);
                    new Teller().addAccount(Myacc);
                    massage.setForeground(Color.green);
                    massage.setText("*Success");
                    re();
                    
                } catch (IOException|ClassNotFoundException ex) {
                        massage.setText("*soory can't connect with system");
                } catch (Exception ex)
                { 
                    massage.setText("*el laaat mn 3ndy anaaa");
                }
            }
        }       
        else if(e.getSource()==reset)
        {
            re();
        }
            
        
    }
    
    private void re()
    {
        accountNum.setText("");
            balance.setText("");
            jop.setText("");
            password.setText("");
            username.setText("");
            Reset1();
    
    }
    
}
