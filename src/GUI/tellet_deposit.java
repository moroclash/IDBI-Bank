
package GUI;

import MainArchitecture.Teller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class tellet_deposit extends form_2_std_filed{

    public tellet_deposit() {
        super("Deposit");
        tx1.setText("Deposit in");
        tx2.setText("Mony");
        txfiled1.setText("AccountNumber");
        txfiled1.setForeground(Color.GRAY);
        txfiled1.addMouseListener(this);
        txfiled2.setForeground(Color.ORANGE);
        
        submit.setText("Deposit");
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
        }
        else if(x.equals(submit))
        {
            if(txfiled1.getText().equals("")||txfiled1.getText().equals("AccountNumber"))
                massage.setText("*Please Enter the  AccountNumber");
            else if(txfiled2.getText().equals(""))
                massage.setText("*Please Enter the Mony");
            else
            {
                try {
                    boolean check = new Teller().deposit(Long.parseLong(txfiled1.getText()),Double.parseDouble(txfiled2.getText()));
                    if(check){
                        massage.setForeground(Color.green);
                        massage.setText("*The deposit "+txfiled2.getText()+" is Success");
                    }
                    else
                        massage.setText("*Account Not Found");
                } catch (IOException|ClassNotFoundException ex) {
                        massage.setText("*4o8l pooodaa el m3afn");
                } catch (Exception ex) {
                        massage.setText("*4o8ly anaa ely paayez");
                }
                
            }
        }
    }
    
}
