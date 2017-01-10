
package GUI;

import java.awt.event.ActionEvent;
import MainArchitecture.Customer;
import MainArchitecture.Teller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class search_Customer extends Search_Form{

    public search_Customer() {
        super("Search About Customer","CustomerID");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit)
        {
             if(txfiled1.getText().equals(""))
                 massage.setText("*Please Enter Customer ID");
             else
             {
                 try {
                    System.out.println("0");
                    Customer  man = new Teller().ShowCustomer(Integer.parseInt(txfiled1.getText())); 
                    System.out.println(man.getFname());
                    Show_Customer q =new Show_Customer(man);
                    System.out.println("2");
                    q.Flage = 'T';
                    q.fname.setText(man.getFname()+" "+man.getlname());
                    q.address.setText(man.getAddress());
                    q.age.setText(man.getAge());
                    q.cuntry.setText(man.getCountry());
                    q.mail.setText(man.getEmail());
                    q.phone.setText(man.getPhone());
                    q.id.setText(Integer.toString(man.getID()));
                    q.gander.setText(man.getGender());
                    q.jop.setText(man.getJop());
                    mainfram.removeAll();
                    mainfram.add(q.getmainform());
                    mainfram.repaint();
                 } catch (IOException|ClassNotFoundException ex) {
                            massage.setText("*4o8l poooda el zft");
                 } //catch (Exception ex) {
                            //massage.setText("*4o8lyyy anaaa");
                    // System.err.println(e);
                // }
             }
        }
        else if(e.getSource()== reset)
        {
            txfiled1.setText("");
        }
    }
    
}
