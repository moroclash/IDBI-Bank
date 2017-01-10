
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public abstract class  standerForm extends JFrame implements ActionListener,MouseListener{
    protected JPanel frame,buttons,mainfram;
    protected JLabel head,massage;
    protected JButton  submit,reset,cancel;
    protected Font f = new Font("Segoe Script", 1, 30);
    public standerForm(String s)
    {
        this.setSize(710,525);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);
        mainfram = new JPanel();
        mainfram.setBounds(0, 0, 710, 508);
        mainfram.setBackground(Color.decode("#00836c"));
        this.setLayout(null);
        mainfram.setBounds(0, 0, mainfram.getBounds().width-5, 508);
        this.add(mainfram);
        mainfram.setLayout(null);
                        
        frame  =new JPanel();
        frame.setBounds(0, 0, 705, 470);
        frame.setBackground(Color.decode("#00836c"));
        mainfram.add(frame);
        
        buttons = new JPanel();
        buttons.setBounds(0, frame.getBounds().height, frame.getBounds().width,mainfram.getBounds().height+20-frame.getBounds().height);
        buttons.setBackground(Color.decode("#00836c"));
        mainfram.add(buttons);
        buttons.setLayout(null);
        
        submit = new JButton("Submit");
        submit.setBounds(5, 5, 120, 30);
        submit.setForeground(Color.white);
        submit.setFont(f.deriveFont(15f));
        submit.addMouseListener(this);
        submit.setBorderPainted(false);
        submit.setBackground(Color.decode("#f89f35"));
        submit.addActionListener(this);
        buttons.add(submit);
        reset = new JButton("Reset");
        reset.addMouseListener(this);
        reset.setBounds(submit.getBounds().x + submit.getBounds().width + 10,submit.getBounds().y , 100, 30);
        reset.setForeground(Color.white);
        reset.setFont(f.deriveFont(15f));
        reset.setBorderPainted(false);
        reset.setBackground(Color.decode("#f89f35"));
        reset.addActionListener(this);
        buttons.add(reset);
        /*cancel = new JButton("Cancel");
        cancel.setBounds(reset.getBounds().x + reset.getBounds().width  + 10,reset.getBounds().y , 100, 35);
        cancel.setForeground(Color.white);
        cancel.setFont(f.deriveFont(15f));
        cancel.setBorderPainted(false);
        cancel.addMouseListener(this);
        cancel.setBackground(Color.decode("#f89f35"));
        cancel.addActionListener(this);
        buttons.add(cancel);*/
        
        
        
        head = new JLabel(s);
  
        frame.setLayout(null);
        TitledBorder t = new TitledBorder(head.getText());
        t.setTitleColor(Color.decode("#f89f35"));
        t.setTitleFont(f);
        frame.setBorder(t);
        
        massage = new JLabel("");
        massage.setForeground(Color.red);
        massage.setFont(new Font("Myriad Pro", 1, 14));
        massage.setBounds(220, 435, 350, 30);
        frame.add(massage);
        
        
        f = null;
        
    }

    @Override
    abstract  public  void actionPerformed(ActionEvent e);
    
    public JPanel getmainform()
    {
        return this.mainfram;
    }
    
    public void setFont(String s , int type , int size)
    {
        this.f = new Font(s, type, size);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object x = e.getSource();
        if(x.equals(submit))
        {
            submit.setBackground(Color.decode("#3c5b7d"));
        }
        else if(x.equals(reset))
        {
            reset.setBackground(Color.decode("#3c5b7d"));
        }else if(x.equals(cancel))
        {
           cancel.setBackground(Color.decode("#3c5b7d"));        
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        submit.setBackground(Color.decode("#f89f35"));
        reset.setBackground(Color.decode("#f89f35"));
       // cancel.setBackground(Color.decode("#f89f35"));
    }
}
