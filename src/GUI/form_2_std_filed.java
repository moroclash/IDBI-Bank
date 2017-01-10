
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;


public abstract class form_2_std_filed extends form_one_std_filed{

    protected JLabel tx2;
    protected JTextField txfiled2;
    
    public form_2_std_filed(String s)
    {
        super(s);
        tx2 = new JLabel("any txt");
        tx2.setBounds(tx1.getBounds().x, tx1.getBounds().y +50, tx1.getBounds().width , tx1.getBounds().height);
        tx2.setFont(fon);
        tx2.setForeground(Color.white);
        frame.add(tx2);
        
        txfiled2 = new JTextField();
        txfiled2.setBounds(tx2.getBounds().x+tx2.getBounds().width, tx2.getBounds().y-4, txfiled1.getBounds().width , txfiled1.getBounds().height);
        txfiled2.setFont(fon);
        txfiled2.setForeground(Color.decode("#c2c9d0"));
        frame.add(txfiled2);
    
    }
    
    
    
    @Override
    public abstract void actionPerformed(ActionEvent e);
    
}
