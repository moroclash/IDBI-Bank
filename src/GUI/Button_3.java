
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public abstract class  Button_3 extends Buttons_std{

    protected JButton b3;
    public Button_3(String p1, String p2,String p3) {
        super(p1, p2);
        b3 = new JButton(p3);
        b3.setBounds(200,b2.getBounds().y+50,300,40);
        b3.setBorder(null);
        b3.setBorderPainted(false);
        b3.setBackground(Color.decode("#f89f35"));
        mainform.add(b3);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

    @Override
    public abstract void mouseEntered(MouseEvent e);


    @Override
    public abstract void mouseExited(MouseEvent e);
    
}
