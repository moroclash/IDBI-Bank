
package GUI;

import MainArchitecture.Account;
import MainArchitecture.ComponyAccount;
import MainArchitecture.PersonalAccount;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Account_transfer extends form_2_std_filed{
    private Account man;
    public Account_transfer(Account man)
    {
        super("Transfer");
        this.man = man ;
        tx1.setText("To");
        tx2.setText("Mony");
        txfiled1.setText("AccointNumper");
        txfiled1.setForeground(Color.GRAY);
        txfiled1.addMouseListener(this);
        txfiled2.addMouseListener(this);
        submit.setText("Transfer");
    }
    
    
   @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== txfiled1)
           {
              txfiled1.setText("");
              txfiled1.setForeground(Color.ORANGE);
           }
          else if(e.getSource()==txfiled2)
          {
             txfiled2.setForeground(Color.ORANGE);
          }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit)
        {
            if(txfiled1.getText().equals(""))
                massage.setText("*Please Enter AccountNmber where you send");
            else if(txfiled2.getText().equals(""))
                massage.setText("*Please Enter Monye");
            else
            {
                int check = 0;   // to check if transfer is success or not
               if(man instanceof PersonalAccount)
                {
                    try {
                        check = new PersonalAccount().transfer(Long.parseLong(txfiled1.getText()),Double.parseDouble(txfiled2.getText()));
                    } catch (IOException|ClassNotFoundException ex) {
                                massage.setText("4ol poda el zpaaalaaa");
                    } catch (Exception ex) {
                                massage.setText("4olyyy anaa el gmiiil");
                    }
                }
                else if(man instanceof ComponyAccount)
                {
                    try {
                    check = new ComponyAccount().transfer(Long.parseLong(txfiled1.getText()),Double.parseDouble(txfiled2.getText()));
                    } catch (IOException|ClassNotFoundException ex) {
                                massage.setText("4ol poda el zpaaalaaa");
                    } catch (Exception ex) {
                                massage.setText("4olyyy anaa el gmiiil");
                    }
                }
                if(check == 1)   
                    {
                        massage.setForeground(Color.green);
                        massage.setText("it's Withdrawn "+txfiled1.getText());
                    }
                else if(check == 2) massage.setText("*Not Enugh Mony");
                else if(check == 0) massage.setText("*Account Not Found");
            }
        }
        else if(e.getSource() == reset)
        {
            txfiled1.setText("");
            txfiled2.setText("");
        }
    }
    
    
}
