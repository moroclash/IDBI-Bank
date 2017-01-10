
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MY_Balance extends form_one_std_filed{
    
    protected JLabel Mybalance;
    public MY_Balance(String x)
    {
        super("MY Balance");
        submit.setVisible(false);
        reset.setVisible(false);
        txfiled1.setVisible(false);
        
        tx1.setText("My Balance : ");
        tx1.setBounds(100, 150, 200 , 30);
        
        Mybalance  = new JLabel(x);
        Mybalance.setBounds(txfiled1.getBounds().x+20,txfiled1.getBounds().y+4,txfiled1.getBounds().width , 33);
        Mybalance.setFont(fon);
        Mybalance.setForeground(Color.orange);
        frame.add(Mybalance);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
