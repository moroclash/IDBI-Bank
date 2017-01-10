
package GUI;

import MainArchitecture.Teller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class teller_withdraw extends form_2_std_filed{

   private JLabel Mony;
   private JTextField mony;
   public  teller_withdraw()
   {
       super("Withdraw");
       tx1.setText("From");
       txfiled1.setText("AccountNumper");
       txfiled1.setForeground(Color.gray);
       txfiled1.addMouseListener(this);
       txfiled2.setForeground(Color.ORANGE);
       tx2.setText("Ssn");
       txfiled2.addMouseListener(this);
       
       Mony = new JLabel("Mony");
       Mony.setBounds(tx1.getBounds().x, tx2.getBounds().y+50, 150 , 30);
       Mony.setFont(fon);
       Mony.setForeground(Color.white);
       frame.add(Mony);
       
       mony = new JTextField();
       mony.setBounds(Mony.getBounds().x+Mony.getBounds().width, Mony.getBounds().y-4, 250 , 30);
       mony.setFont(fon);
       mony.setForeground(Color.ORANGE);
       frame.add(mony);
       
       
       submit.setText("Withdraw");
   
   }
   
   @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== txfiled1)
           {
              txfiled1.setText("");
              txfiled1.setForeground(Color.ORANGE);
           }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if(x.equals(reset)){
            txfiled1.setText("");
            txfiled2.setText("");
            mony.setText("");
        }
        else if(x.equals(submit))
        {
            if(txfiled1.getText().equals("")||txfiled1.getText().equals("AccountNumber"))
                massage.setText("*Please Enter the AccountNumber");
            else if(txfiled2.getText().equals(""))
                massage.setText("*Please Enter the Customer Ssn");
            else if(mony.getText().equals(""))
                massage.setText("*Please Enter the  Mony");
            else
            {
                try {
                    int check = new Teller().withdraw(Long.parseLong(txfiled1.getText()),Double.parseDouble(mony.getText()), txfiled2.getText()); //if have enuph mony or not
                    if(check == 1)
                    {
                        massage.setForeground(Color.green);
                        massage.setText("*It was withdrawn amount " + mony.getText());
                    }
                    else if(check == 2)
                    {
                       massage.setText("*Sory Not enough Mony");
                    }
                    else if(check == 0)
                    {
                        massage.setText("*Account Not Exist");
                    }
                } catch (IOException|ClassNotFoundException ex) {
                    massage.setText("*4ol poooda el zft");
                } catch (Exception ex) {
                    massage.setText("*4olyyyy anaaa el zft");
                }
            
            
            }
        }
    }
    
}
