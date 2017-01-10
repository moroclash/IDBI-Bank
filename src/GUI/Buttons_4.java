package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public abstract class Buttons_4 extends Button_3{
    protected JButton b4;
    public Buttons_4(String p1, String p2, String p3,String p4) {
        super(p1, p2, p3);
        b4 = new JButton(p4);
        b4.setBounds(200,b3.getBounds().y+50,300,40);
        b4.setBorder(null);
        b4.setBorderPainted(false);
        b4.setBackground(Color.decode("#f89f35"));
        mainform.add(b4);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

    @Override
    public abstract void mouseEntered(MouseEvent e);

    @Override
    public abstract void mouseExited(MouseEvent e) ;

    
}
