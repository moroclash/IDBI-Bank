/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import MainArchitecture.Customer;
import MainArchitecture.Teller;
import Managment.BranchManager2;
import Managment.History;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

public class Show_Customer extends Show_std{
    
    private Customer man;
    protected JLabel MyAccounts;
    protected JComboBox myaccounts;
    
    public Show_Customer(Object man) {
        super("Customer");
        this.man = (Customer) man;
        submit.setText("Update");
        reset.setText("Delete");
        
        MyAccounts = new JLabel("His Accounts :");
        MyAccounts.setBounds(Fname.getBounds().x, Jop.getBounds().y+40,150,30);
        MyAccounts.setFont(f);
        MyAccounts.setForeground(Color.white);
        frame.add(MyAccounts);
        int i =0;
        
        myaccounts = new JComboBox(this.man.getMyAccounts().toArray());
        myaccounts.setBounds(MyAccounts.getBounds().x+MyAccounts.getBounds().width, MyAccounts.getBounds().y,age.getBounds().width+50, 30);
        frame.add(myaccounts);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if(x.equals(submit))
        {
            personForm q = new personForm(null);
            if(Flage == 'T')
            {
                q.ssn.setText(man.getSSN());
                q.id.setText(Integer.toString(man.getID()));
                q.address.setText(man.getAddress());
                q.age.setText(man.getAge());
                q.country.setText(man.getCountry());
                if(man.getGender().equals("Male"))
                    q.Male.setSelected(true);
                else
                    q.Female.setSelected(true);
                q.fnam.setText(man.getFname());
                q.lnam.setText(man.getlname());
                q.email.setText(man.getEmail());
                q.phon.setText(man.getPhone());
                q.country.setText(man.getCountry());
                q.setCustomer(man);
                
                q.ssn.setVisible(false);
                q.Ssn.setVisible(false);
                
                q.id.setVisible(false);
                q.Id.setVisible(false);
                
                q.submit.setText("Update");
                q.reset.setVisible(false);
            }
            
            
            mainfram.removeAll();
            mainfram.add(q.getmainform());
            mainfram.repaint();
        }
        else if(e.getSource() == reset)//Delllet customer
        {
                int check = JOptionPane.showConfirmDialog(this, "Are you Shure?", "Delete", 0);
                if(check == 0)
                {
                    try {
                     new Teller().DeleteCustomer(man.getID());
                     massage.setForeground(Color.GREEN);
                     massage.setText("*Delete is Success");
                     } catch (IOException|ClassNotFoundException ex) {
                     massage.setText("sory can't connect with server");
                        } 
                }
            
            
        }
    }
    
}
