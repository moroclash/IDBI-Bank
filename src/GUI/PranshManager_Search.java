
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class PranshManager_Search extends Buttons_4{
    public PranshManager_Search() {
        super("Customer","Account", "Employee","DepartManager");
        b1.addActionListener(this);
        b1.addMouseListener(this);
        b2.addActionListener(this);
        b2.addMouseListener(this);
        b3.addActionListener(this);
        b3.addMouseListener(this);
        b4.addActionListener(this);
        b4.addMouseListener(this);
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
        else if(e.getSource() == b3)
        {
            mainform.removeAll();
            mainform.add(new search_Employee().getmainform());
            mainform.repaint();
        }
        else if(e.getSource() == b4)
        {
            mainform.removeAll();
            mainform.add(new search_DeptManager().getmainform());
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
        else if(x.equals(b3))
        {
            b3.setBackground(Color.decode("#3c5b7d"));
        }
        else if(x.equals(b4))
        {
            b4.setBackground(Color.decode("#3c5b7d"));
        }
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        b1.setBackground(Color.decode("#f89f35"));
        b2.setBackground(Color.decode("#f89f35"));
        b3.setBackground(Color.decode("#f89f35"));
        b4.setBackground(Color.decode("#f89f35"));
    }

    
    
}
