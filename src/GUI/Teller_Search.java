
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class Teller_Search extends Buttons_std{

    public Teller_Search() {
        super("Customer", "Account");
        b1.addMouseListener(this);
        b1.addActionListener(this);
        b2.addMouseListener(this);
        b2.addActionListener(this);
    }

    @Override
    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            mainform.removeAll();
            mainform.add(new search_Customer().getmainform());
            mainform.repaint();
        }
        else if(e.getSource() == b2)
        {
            mainform.removeAll();
            mainform.add(new search_Account().getmainform());
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
