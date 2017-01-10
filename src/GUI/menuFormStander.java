
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import sun.util.calendar.Gregorian;

public abstract class menuFormStander extends JFrame implements ActionListener,MouseListener{
    
    protected JPanel form,mainfram,components,welcoe;
    protected JButton sinout,ShowMyProfile;
    protected Font f;
    private JLabel image;
    protected JPanel menue;
    private JLabel background;
    
    public menuFormStander()
    {
        this.setTitle("IDBI");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  //elmfrood yp5reg mn sing out m4 mn hnaa 5leehaa DO_NOTHINK
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        
        background = new JLabel();
        background.setIcon(new ImageIcon("image//4.jpg"));
        
        
        mainfram =new JPanel();
        mainfram.setLayout(null);
       
        
        
        form = new JPanel();
        form.setBounds(0,0,273,565);
        form.setBackground(Color.decode("#00836c")); 
        form.setLayout(new GridLayout(10, 1, 0, 1));
        mainfram.add(form);
        f = new Font("Comic Sans MS",1,24);
        
        ShowMyProfile = new JButton("My Profile");
        ShowMyProfile.setFont(f);
        ShowMyProfile.setBackground(Color.decode("#f7ae57"));
        ShowMyProfile.setBorder(null);
        ShowMyProfile.setBorderPainted(false);
        ShowMyProfile.addMouseListener(this);
        ShowMyProfile.addActionListener(this);
        form.add(ShowMyProfile);
        
        sinout = new JButton("Sing out");
        sinout.setFont(f);
        sinout.setBackground(Color.decode("#f7ae57"));
        sinout.setBorder(null);
        sinout.setBorderPainted(false);
        sinout.addMouseListener(this);
        sinout.addActionListener(this);
        form.add(sinout);
        
        components = new JPanel();
        components.setLayout(null);
        components.setBounds(form.getBounds().width +16, form.getBounds().y,getBounds().width-form.getBounds().width-32 , 508);
        components.setBackground(Color.decode("#00836c"));
        mainfram.add(components);
        
        welcoe = new welcomepage().getmainframe();
        //welcoe.setBounds(0, 0, 700, 508);
        components.add(welcoe);
        
        
        
        image = new JLabel(new ImageIcon("image//rbna yostor.jpg"));
        image.setBounds(0,0,1000,557);
        mainfram.add(image);
        
        
        mainfram.setBounds(0, 0, 1000, 557);
        menue = new JPanel();
        menue.setLayout(null);
        menue.add(mainfram); 
        menue.setBounds(0,115,1000,557);
        this.add(menue);
        background.setBounds(0, 0, this.getSize().width,this.getSize().height);
        this.add(background);  
    }
    
    public JPanel getframemenu()
    {
        return this.mainfram;
    }
    
    public void setFont(String s , int type , int size)
    {
        this.f = new Font(s, type, size);
    }

    @Override
    public abstract void mouseClicked(MouseEvent e);

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       

    }

    @Override
    public  abstract void actionPerformed(ActionEvent e);
}
