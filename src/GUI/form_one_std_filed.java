package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class form_one_std_filed extends standerForm {
    
    protected JLabel tx1;
    protected JTextField txfiled1;
    protected Font fon ;
    public form_one_std_filed(String s) {
        super(s);
        fon = new Font("Impact",2,30);
        tx1 = new JLabel("any txt");
        tx1.setBounds(100, 150, 150 , 30);
        tx1.setFont(fon);
        tx1.setForeground(Color.white);
        frame.add(tx1);
        
        txfiled1 = new JTextField();
        txfiled1.setBounds(tx1.getBounds().x+tx1.getBounds().width, tx1.getBounds().y-4, 250 , 30);
        txfiled1.setFont(fon);
        txfiled1.setForeground(Color.decode("#c2c9d0"));
        frame.add(txfiled1);
        
    }

    @Override
    public abstract void actionPerformed(ActionEvent e) ;

    
    

   
}
