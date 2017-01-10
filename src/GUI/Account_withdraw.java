
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import MainArchitecture.Account;
import MainArchitecture.ComponyAccount;
import MainArchitecture.PersonalAccount;
import javax.swing.JOptionPane;


public class Account_withdraw extends form_one_std_filed{
    
    private Account man;
    public Account_withdraw(Account man) {
        super("Withdraw");
        this.man= man;
        tx1.setText("Mony");
        txfiled1.addMouseListener(this);
        submit.setText("Withdraw");
    }
    @Override
    public void mouseClicked(MouseEvent e) {
            if(e.getSource() == txfiled1)
            {
              txfiled1.setText("");
              txfiled1.setForeground(Color.ORANGE);            
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit)
        {
            if(txfiled1.getText().equals(""))
                massage.setText("*Please Enter Monye");
            else
            {
                int check =0;
                if(man instanceof PersonalAccount)
                {
                    check = new PersonalAccount().withdraw(Double.parseDouble(txfiled1.getText()));
                }
                else if(man instanceof ComponyAccount)
                {
                    check = new ComponyAccount().withdraw(Double.parseDouble(txfiled1.getText()));
                }
                if(check == 1)
                    {
                        massage.setForeground(Color.green);
                        massage.setText("it's Withdrawn "+txfiled1.getText());
                    }
                else if(check == 0)massage.setText("*Not Enugh Mony");
                else if(check == 2)JOptionPane.showMessageDialog(this,"*Sory the Amount is very huge you can withdraw from any pransh");
            }
        
        }
        else if(e.getSource() == reset)
        {
            txfiled1.setText("");
        }
    }
    
}
