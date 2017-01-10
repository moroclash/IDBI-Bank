
package GUI;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class welcomepage extends JFrame{
    
        private JLabel image;
        private JPanel mainframe;
        public  welcomepage()
        {
            this.setSize(710, 508);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLayout(null);
            
            image = new JLabel(new ImageIcon("image//welcompage.jpg"));
            image.setBounds(0, 0, 710, 508);
            
            mainframe = new JPanel();
            mainframe.setBounds(0, 0, 710, 508);
            this.add(mainframe);
            
            mainframe.add(image);
            mainframe.setBackground(Color.decode("#00836c"));
            mainframe.setBorder(null);
        
        }
        
        public JPanel getmainframe()
        {
            return this.mainframe;
        }
                
    
}
