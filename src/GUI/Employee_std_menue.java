
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public abstract class Employee_std_menue extends menuFormStander{

       protected JButton creat,search;//,delet,update;
       
       public Employee_std_menue()
       {
            creat = new JButton("Creat");
            creat.setFont(f);
            creat.setBackground(Color.decode("#f7ae57"));
            creat.setBorder(null);
            creat.setBorderPainted(false);
            creat.addMouseListener(this);
            creat.addActionListener(this);
            form.add(creat);
            
            
            
            
            search = new JButton("Searsh");
            search.setFont(f);
            search.setBackground(Color.decode("#f7ae57"));
            search.setBorder(null);
            search.setBorderPainted(false);
            search.addMouseListener(this);
            search.addActionListener(this);
            form.add(search);
            
/*            
            delet = new JButton("Delete");
            delet.setFont(f);
            delet.setBackground(Color.decode("#f7ae57"));
            delet.setBorder(null);
            delet.setBorderPainted(false);
            delet.addMouseListener(this);
            delet.addActionListener(this);
            form.add(delet);
            
            
            
            update = new JButton("Update");
            update.setFont(f);
            update.setBackground(Color.decode("#f7ae57"));
            update.setBorder(null);
            update.setBorderPainted(false);
            update.addMouseListener(this);
            update.addActionListener(this);
            form.add(update);
       
       
  */     
       }
    
   
    @Override
    public abstract void mouseClicked(MouseEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
    
}
