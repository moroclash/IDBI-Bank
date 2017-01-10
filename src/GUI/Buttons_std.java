
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Buttons_std extends JFrame implements ActionListener,MouseListener{

    protected JButton b1,b2;
    protected JPanel mainform;
    public Buttons_std(String p1,String p2)
    {
        this.setSize(695, 508);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        
        mainform = new JPanel();
        mainform.setBounds(0, 0, 1000, 700);
        mainform.setBackground(Color.decode("#00836c"));
        mainform.setLayout(null);
        this.add(mainform);
        
        
        b1 = new JButton(p1);
        b1.setBounds(200,100,300,40);
        b1.setBorder(null);
        b1.setBorderPainted(false);
        b1.setBackground(Color.decode("#f89f35"));
        mainform.add(b1);
        
        b2 = new JButton(p2);
        b2.setBounds(200,b1.getBounds().y+50,300,40);
        b2.setBorder(null);
        b2.setBorderPainted(false);
        b2.setBackground(Color.decode("#f89f35"));
        mainform.add(b2);
        
        
        
        
        
    }
    
    public JPanel getmainform()
    {
        return this.mainform;
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

    @Override
    public  void mouseClicked(MouseEvent e){
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public abstract void mouseEntered(MouseEvent e) ;

    @Override
    public abstract void mouseExited(MouseEvent e) ;
        
    
}
