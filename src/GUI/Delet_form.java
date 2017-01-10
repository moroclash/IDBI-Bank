
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public abstract class Delet_form extends form_one_std_filed{

    public Delet_form(String s,String ss) {
        super(s);
        tx1.setText("Delete");
        txfiled1.setText(ss);
        txfiled1.setForeground(Color.gray);
        txfiled1.addMouseListener(this);
        submit.setText("Search");
        submit.setText("Delete");
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
