package GUI;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.RoundingMode;
import java.util.Arrays;
import javafx.scene.layout.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import MainArchitecture.Teller;
import MainArchitecture.Account;
import Managment.History;
import Managment.Login;
import Managment.Manager;
import static java.awt.image.ImageObserver.WIDTH;



public class log_in extends JFrame{
    
        JTextField user;
        JPasswordField pass;
        JButton ok ;
        JLabel imag,error;
        
        public log_in()
        {
            this.setSize(800,500);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("IDBI");
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            imag = new JLabel(new ImageIcon("image//Untitled-pank1.jpg"));
            user = new JTextField("Username", 20);
            pass = new JPasswordField("Password", 20);
            ok = new JButton("Sign in");
            Container cp =getContentPane();
            cp.setLayout(null);
            Font f = new Font("Segoe Print",3, 24);
            error = new JLabel("");
            
            
            
            
            user.setBounds(270, 220, 250, 30);
            user.setBackground(Color.decode("#2baff3"));
            user.setBorder(null);
            user.setFont(f);
            user.setForeground(Color.decode("#b1c0c2"));
            user.setDoubleBuffered(false);
            user.setHorizontalAlignment(JTextField.CENTER);
            user.addMouseListener(new events());
            cp.add(user);
           
            
            pass.setBounds(270, 280, 250, 30);
            pass.setBackground(Color.decode("#2baff3"));
            pass.setBorder(null);
            pass.setForeground(Color.decode("#b1c0c2"));
            pass.setHorizontalAlignment(JTextField.CENTER);
            pass.addMouseListener(new events());
            cp.add(pass);
            
            
            ok.setBounds(345,340,100,40);
            ok.setBackground(Color.decode("#2074a0"));
            ok.setForeground(Color.decode("#3093c6"));
            ok.setBorderPainted(false);
            ok.addActionListener(new events());
            cp.add(ok);
            
            
            error.setBounds(250, 390, 350, 30);
            error.setForeground(Color.red);
            cp.add(error);
            
            imag.setBounds(0, 0, 800, 500);
            cp.add(imag);
        }
           
            
           
         private class events implements ActionListener,MouseListener
           {

                @Override
                public void mouseClicked(MouseEvent e) {
                      if(e.getSource()== user)
                    {
                        user.setText("");
                        user.setForeground(Color.WHITE);
                        ok.setForeground(Color.WHITE);
                        error.setText("");
                    }
                    else if(e.getSource()==pass)
                    {
                        pass.setText("");
                        pass.setForeground(Color.WHITE);
                        ok.setForeground(Color.WHITE);
                        error.setText("");
                    }
                }

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
        public void actionPerformed(ActionEvent e) {
            Object x = e.getSource();
                if(x.equals(ok))
                {
                    String userNam = user.getText();
                    char pp[] = pass.getPassword();
                    String p = new String(pp);
                    char pas[] = {'P','a','s','s','w','o','r','d'};
                    
                    // admin username & password
                    String adminusername = "admin";
                    //char adminpass[] = {'t','a','h','a','1','2','3'};
                    String adminpass = "admin" ;
                    ///////////////////        
                            
                    if(userNam.equalsIgnoreCase("Username") || userNam.length()==0)
                    {
                          error.setText("* pleas Enter your username and password ");
                    }
                    else if(pass.getPassword().length == 0 || Arrays.equals(pass.getPassword(), pas))
                    {
                        error.setText("* pleas Enter your password ");
                    }
                    else
                    {
                        Login check = new Login();
                        Object f = new Object();
                        if(userNam.equals(adminusername) && p.equals(adminpass))
                        {
                            dispose();
                            Pranch_Manager_menu men = new Pranch_Manager_menu();
                            men.setVisible(true);
                            System.out.println("1aaaaaaaaa");
                        }
                        else{
                            try {
                                System.out.println("Enter try");
                                f = check.login(userNam, pass.getPassword());
                                System.out.println("1");
                                if(f == null)
                                        {
                                            System.out.println("helooo");
                                            error.setText("*Sory The Password or Username is invalied");
                                        }
                                else{
                                    System.out.println("Enter else1");
                                dispose();
                                if(f instanceof Manager)
                                {
                                    Manager man = (Manager) f;
                                    DepartManager_menue men = new DepartManager_menue(man);
                                    men.setVisible(true);
                                }
                                else if(f instanceof Teller)
                                {
                                    System.out.println("3");
                                    Teller man = (Teller) f;
                                    System.out.println("4");
                                    Teller_menue men = new Teller_menue(man);
                                    men.setVisible(true);
                                }
                                
                                else if(f instanceof Account)
                                {
                                    System.out.println("5");
                                    Account man = (Account) f;
                                    System.out.println("6");
                                    Account_menue men = new Account_menue(man);
                                    men.setVisible(true);
                                }
                            }
                                
                            } catch (IOException|ClassNotFoundException ex) {
                                System.out.println("7");
                                error.setText("*Sory The Password or Username is invalied");
                            }
//                            } catch (Exception ex) {
//                                   error.setText("*4o8ly anaa");
//                            } 
                            
                            
                        }
                       
                        
                    }//end else1
                }//end if(ok)
        }//end action
    }            
} //end class
