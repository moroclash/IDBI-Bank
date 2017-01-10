/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import MainArchitecture.Teller;
import Managment.Employee;
import Managment.Manager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Pranch_manager_Creat extends Buttons_std{

    public Pranch_manager_Creat() {
        super("New Employee", "New Manager");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.addMouseListener(this);
        b2.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            EmoployeeForm q =new EmoployeeForm("NEW Employee",new Teller());
            q.flage = 'C';
            mainform.removeAll();
            mainform.add(q.getmainform());
            mainform.repaint();
        }
        else if(e.getSource() == b2)
        {
            EmoployeeForm q =new EmoployeeForm("NEW Manager",new Manager());
            q.flage = 'C';
            mainform.removeAll();
            mainform.add(q.getmainform());
            mainform.repaint();
        }

    }

      @Override
    public void mouseEntered(MouseEvent e) {
        Object x = e.getSource();
        if(x.equals(b1))
        {
            b1.setBackground(Color.decode("#3c5b7d"));
        }
        else if(x.equals(b2))
        {
            b2.setBackground(Color.decode("#3c5b7d"));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        b1.setBackground(Color.decode("#f89f35"));
        b2.setBackground(Color.decode("#f89f35"));
    }
    
}
