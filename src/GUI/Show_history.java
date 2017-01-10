
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Show_history extends standerForm{

    private JLabel Mass;
    private JPanel man;
    private final int x = 10,w =700,h=20;
    public Show_history(String s,ArrayList<String> data) {
        super(s);
        int y =50;
        submit.setVisible(false);
        reset.setVisible(false);
         JScrollPane scrrol = new JScrollPane(frame);
         //scrrol.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         scrrol.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         scrrol.setPreferredSize(new Dimension(500, 900));
         scrrol.setBounds(0, 0,706, 460);
        mainfram.add(scrrol);
        for(String q : data)
        {
            Mass  = new JLabel();
            Mass.setForeground(Color.white);
            Mass.setFont(new Font("Myriad Pro", 1, 20));
            Mass.setBounds(x, y+10, w, h);
            Mass.setText(q);
            frame.setSize(0, 0);
            frame.add(Mass);
            y +=17 ;
        }
        mainfram.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    
}
