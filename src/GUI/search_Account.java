
package GUI;

import java.awt.event.ActionEvent;
import MainArchitecture.Teller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import MainArchitecture.Account;
import MainArchitecture.Customer;
import MainArchitecture.ComponyAccount;
import MainArchitecture.PersonalAccount;

public class search_Account extends Search_Form{

    public search_Account() {
        super("Search About Account","AccountNumber");        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit)
        {
            if(txfiled1.getText().equals("")||txfiled1.getText().equals("AccountNumber"))
                massage.setText("*Please Enter the AccountNumber");
            else
            {
                try {
                   Account man = (Account) new Teller().showAccount(Long.parseLong(txfiled1.getText()));
                   Show_Account q = new Show_Account(txfiled1.getText(),man);
                   q.Flage = 'T';
                   q.fname.setText(Long.toString(man.getAccountNum()));
                   q.age.setText(man.getMyCustomerType());
                   q.phone.setText(man.getProfit());
                   q.id.setText(Double.toString(man.getBalance()));
                   Customer owner = man.getMyOwner();
                   q.address.setText(owner.getFname() +" "+owner.getlname());
                   q.id2.setText(Integer.toString(owner.getID()));
                   q.username.setText(man.getUsername());
                   q.mail.setText(owner.getEmail());
                   q.jop.setText(owner.getJop());
                   q.cuntry.setText(owner.getCountry());
                   q.companyname.setVisible(false);
                   q.Compamnyname.setVisible(false);
                   q.CompanyPhone.setVisible(false);
                   q.companyphone.setVisible(false);
                   q.loction.setVisible(false);
                   q.Loction.setVisible(false);
                           
                   if(man instanceof ComponyAccount)
                   {
                       ComponyAccount me = (ComponyAccount) man;
                       q.companyname.setVisible(true);
                       q.companyname.setText(me.getComanyName());
                       q.Compamnyname.setVisible(true);
                       q.CompanyPhone.setVisible(true);
                       q.companyphone.setText(me.getTelephone());
                       q.companyphone.setVisible(true);
                       q.loction.setVisible(true);
                       q.loction.setText(me.getLoacation());
                       q.Loction.setVisible(true);
                       
                   }
                   mainfram.removeAll();
                   mainfram.add(q.getmainform());
                   mainfram.repaint();
                   
                  } catch (IOException|ClassNotFoundException ex) {/// will delet this exiption
                    massage.setText("*error 4o8l taha");
                  }
                    catch (Exception ex) {
                    massage.setText("*Soory the Account Not exist");
                  } 
                 
            }
        }
        else if(e.getSource()== reset)
        {
            txfiled1.setText("");
        }
    }
    
}
