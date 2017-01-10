
package GUI;

import MainArchitecture.Teller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class teller_transfer_form extends form_2_std_filed
{
    private JLabel tx3,tx4 ;
    private JTextField txfield3,txfield4;
    
    public teller_transfer_form()
    {
        super("Transfer");
        tx1.setText("From ");
        txfiled1.setText("AccountNumber");
        tx2.setText("Sender Ssn ");
        txfiled2.setForeground(Color.ORANGE);
        
        tx3 = new JLabel("TO");
        tx3.setBounds(tx2.getBounds().x, tx2.getBounds().y +50, tx2.getBounds().width , tx2.getBounds().height);
        tx3.setFont(fon);
        tx3.setForeground(Color.white);
        frame.add(tx3);
        
        txfield3 = new JTextField();
        txfield3.setBounds(tx3.getBounds().x+tx3.getBounds().width, tx3.getBounds().y-4, txfiled2.getBounds().width , txfiled2.getBounds().height);
        txfield3.setFont(fon);        
        txfield3.setText("AccountNumber");
        txfield3.setForeground(Color.decode("#c2c9d0"));
        frame.add(txfield3);
        
        
        tx4 = new JLabel("Mony");
        tx4.setBounds(tx3.getBounds().x, tx3.getBounds().y +50, tx3.getBounds().width , tx3.getBounds().height);
        tx4.setFont(fon);
        tx4.setForeground(Color.white);
        frame.add(tx4);
        
        txfield4 = new JTextField();
        txfield4.setBounds(tx4.getBounds().x+tx4.getBounds().width, tx4.getBounds().y-4, txfiled2.getBounds().width , txfiled2.getBounds().height);
        txfield4.setFont(fon);
        txfield4.setForeground(Color.ORANGE);
        frame.add(txfield4);
        
        this.submit.setText("Transfer");
        txfiled1.addMouseListener(this);
        txfiled2.addMouseListener(this);
        txfield3.addMouseListener(this);
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if(x.equals(reset)){
            txfiled1.setText("");
            txfiled2.setText("");
            txfield3.setText("");
            txfield4.setText("");
        }
        else if(x.equals(submit))
        {
            if(txfiled1.getText().equals("")||txfiled1.getText().equals("AccountNumber"))
                massage.setText("*Please Enter the Sender AccountNumber");
            else if(txfiled2.getText().equals(""))
                massage.setText("*Please Enter the Sender Ssn");
            else if(txfield3.getText().equals("")||txfield3.getText().equals("AccountNumber"))
                massage.setText("*Please Enter the Reciver AccountNumber");
            else if(txfield4.getText().equals(""))
                massage.setText("*Please Enter the Mony you Want to Transfer");
            else
            {
                try {
                    int check = new Teller().Transfer(Long.parseLong(txfiled1.getText()), Long.parseLong(txfield3.getText()), Double.parseDouble(txfield4.getText()),txfiled2.getText());
                   if(check ==1)
                   {
                      massage.setForeground(Color.green);
                      massage.setText("*The deposit "+txfiled2.getText()+" is Success");
                   }
                   else if(check ==0)
                   {
                       massage.setText("*Sender not Exist");
                   }
                   else if(check ==2)
                   {
                       massage.setText("*Not Enugh mony");
                   }
                   else if(check ==3)
                   {
                       massage.setText("*Account not exist");
                   }
                } catch (IOException|ClassNotFoundException ex) {
                        massage.setText("*4o8l pooodaa el m3afn");
                } catch (Exception ex) {
                        massage.setText("*4o8ly anaa ely paayez");
                }
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== txfiled1)
           {
              txfiled1.setText("");
              txfiled1.setForeground(Color.ORANGE);
           }
         else if(e.getSource()==txfield3)
          {
             txfield3.setText("");
             txfield3.setForeground(Color.ORANGE);
          }
    }
}
