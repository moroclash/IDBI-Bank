
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public abstract class Search_Form extends form_one_std_filed{

    public Search_Form(String s,String ss) {
        super(s);
        tx1.setText("Search");
        txfiled1.setText(ss);
        txfiled1.setForeground(Color.gray);
        txfiled1.addMouseListener(this);
        submit.setText("Search");
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
    public abstract void actionPerformed(ActionEvent e);
   
}
