
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Managment.Employee;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.krb5.internal.NetClient;
import Managment.Manager;
import MainArchitecture.Teller;
import Managment.BranchManager2;
import Managment.History;

public class EmoployeeForm extends personForm{

    protected JLabel Sallary,Joplevl,Department,Password2;
    protected JTextField salary,username;
    protected JPasswordField password,password2;
    protected JComboBox joplvl,Dept;
    private Object man;
    protected char flage;
    public EmoployeeForm(String s,Object man) {
        super(s);
        this.man = man;
        submit.setText("Create");
        Sallary = new JLabel("Sallary");
        Sallary.setBounds(Fname.getBounds().x,Phone.getBounds().y+40, Fname.getBounds().width , Fname.getBounds().height);
        Sallary.setFont(f);
        Sallary.setForeground(Color.white);
        personframe.add(Sallary);
        
        salary = new JTextField();
        salary = new JTextField("" ,10);
        salary.setBounds(Sallary.getBounds().x +Sallary.getBounds().width, Sallary.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(salary);
        
        
        Joplevl = new  JLabel("Job lvl");
        Joplevl.setBounds(Country.getBounds().x,Sallary.getBounds().y, Fname.getBounds().width , Fname.getBounds().height);
        Joplevl.setFont(f);
        Joplevl.setForeground(Color.white);
        personframe.add(Joplevl);
        
        joplvl = new JComboBox(new String[] {"Employee","Manager"});
        joplvl.setBounds(country.getBounds().x, Joplevl.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(joplvl);
        
        
        Department = new  JLabel("Department");
        Department.setBounds(Fname.getBounds().x-20,Joplevl.getBounds().y+40, Fname.getBounds().width , Fname.getBounds().height);
        Department.setFont(f);
        Department.setForeground(Color.white);
        personframe.add(Department);
        
        Dept = new JComboBox(new String[] {"Accounting Dept","Human Resources","Complaints"});
        Dept.setBounds(fnam.getBounds().x, Department.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(Dept);
        
        Username = new  JLabel("Username");
        Username.setBounds(Fname.getBounds().x,Department.getBounds().y+40, Fname.getBounds().width , Fname.getBounds().height);
        Username.setFont(f);
        Username.setForeground(Color.white);
        personframe.add(Username);
        
        username = new JTextField();
        username.setBounds(fnam.getBounds().x, Username.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(username);
        
        Password = new  JLabel("Password");
        Password.setBounds(Country.getBounds().x-20,Username.getBounds().y, Fname.getBounds().width+20 , Fname.getBounds().height);
        Password.setFont(f);
        Password.setForeground(Color.white);
        personframe.add(Password);
        
        password = new JPasswordField();
        password.setBounds(country.getBounds().x, Username.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(password);
        
        Password2 = new  JLabel("re Password");
        Password2.setBounds(Password.getBounds().x-20,Password.getBounds().y+40, Fname.getBounds().width+20 , Fname.getBounds().height);
        Password2.setFont(f);
        Password2.setForeground(Color.white);
        personframe.add(Password2);
        
        password2 = new JPasswordField();
        password2.setBounds(country.getBounds().x, Password2.getBounds().y-4,phon.getBounds().width-20, fnam.getBounds().height);
        personframe.add(password2);
            
    }

    @Override
    public  void actionPerformed(ActionEvent e)
    {
            if(e.getSource() == submit)
            {
                    if(fnam.getText().equals("")||lnam.getText().equals("")||ssn.getText().equals("")||email.getText().equals("")||address.getText().equals("")||phon.getText().equals("")||country.getText().equals("")||age.getText().equals("")||salary.getText().equals("")||username.getText().equals("")||password.getText().equals("")||password2.getText().equals(""))
                    {
                        massage.setForeground(Color.red);
                        massage.setText("*pleas enter All Form");
                    }
                    else{
                            if(man instanceof Manager)
                            {
                             Manager newTeller = (Manager) man;
                             newTeller.setAddress(address.getText());
                            newTeller.setAge(age.getText());
                            newTeller.setBranch("El Zmalek");
                            newTeller.setCountry(country.getText());
                            newTeller.setEmail(email.getText());
                            newTeller.setFname(fnam.getText());
                            if(Male.isSelected())
                                newTeller.setGender("Male");
                            else
                                newTeller.setGender("Female");
                          //  newTeller.setID(Integer.parseInt(id.getText()));
                            newTeller.setJobLevel( joplvl.getSelectedItem().toString());
                            newTeller.setlname(lnam.getText());
                            newTeller.setPhone(phon.getText());
                            newTeller.setSSN(ssn.getText());
                            // 4ooo5l boooda X
                            newTeller.setSalary(salary.getText());
                            newTeller.setTellerDept(Dept.getSelectedItem().toString());
                            newTeller.setUsername(username.getText());
                            char[]p = password.getPassword();                  
                            char[]p2 = password2.getPassword();
                            
                            if(p.length != 0 && p2.length != 0)
                              {
                                        if(newTeller.getPassword() == null||flage == 'C')
                                        {
                                            if(Arrays.equals(p, p2))
                                            {
                                                newTeller.setPassword(p);
                                                try {
                                                                 System.out.println("haaa");
                                                                 int id = new BranchManager2().addEmployee(newTeller);
                                                                 new BranchManager2().addNewID(id, newTeller.getUsername());
                                                                 System.out.println("3");
                                                                 System.out.printf(newTeller.getFname());
                                                                 massage.setForeground(Color.GREEN);
                                                                 massage.setText("*Success");
                                                                 Reset();
                                                    } catch (IOException|ClassNotFoundException ex) {
                                                            massage.setText("*sooory can't conect whith system");
                                                    }
                                            }
                                            else
                                            {
                                                massage.setText("*Invalid Password");
                                            }
                                        }
                                        else if(newTeller.getPassword().length != 0&&flage == 'U')
                                        {
                                            if(flage == 'P') // pranch manger to chang any think
                                            {
                                                newTeller.setPassword(p2);
                                                try {
                                                                 new BranchManager2().updateEmployee(newTeller);
                                                                 System.out.println("1");
                                                                 massage.setForeground(Color.GREEN);
                                                                 massage.setText("*Success");
                                                                 Reset();
                                                       } catch (IOException|ClassNotFoundException ex) {
                                                           massage.setText("*sooory can't conect whith system");
                                                      }
                                            }
                                            else if(Arrays.equals(p, newTeller.getPassword()))
                                             {
                                                 newTeller.setPassword(p2);
                                                 try {
                                                                 new BranchManager2().updateEmployee(newTeller);
                                                                 System.out.println("1");
                                                                 massage.setForeground(Color.GREEN);
                                                                 massage.setText("*Success");
                                                                 Reset();
                                                       } catch (IOException|ClassNotFoundException ex) {
                                                           massage.setText("*sooory can't conect whith system");
                                                      }
                                             }
                                            else
                                            {
                                                massage.setText("*Invalied Password");
                                            }             
                                        }        
                              }
                              else
                              {
                                    massage.setText("*Enter Password");
                              }
                            }
                            
                            
                            else if(man instanceof Teller)
                            {
                            Teller newTeller = (Teller) man;
                                System.out.println("aaaaaaaaaaaaaaa");
                            newTeller.setAddress(address.getText());
                            newTeller.setAge(age.getText());
                            newTeller.setBranch("El Zmalek");
                            newTeller.setCountry(country.getText());
                            newTeller.setEmail(email.getText());
                            newTeller.setFname(fnam.getText());
                            if(Male.isSelected())
                                newTeller.setGender("Male");
                            else
                                newTeller.setGender("Female");
                          //  newTeller.setID(Integer.parseInt(id.getText()));
                            newTeller.setJobLevel( joplvl.getSelectedItem().toString());
                            newTeller.setlname(lnam.getText());
                            newTeller.setPhone(phon.getText());
                            newTeller.setSSN(ssn.getText());
                            // 4ooo5l boooda X
                            newTeller.setSalary(salary.getText());
                            newTeller.setTellerDept(Dept.getSelectedItem().toString());
                            newTeller.setUsername(username.getText());
                            char[]p = password.getPassword();                  
                            char[]p2 = password2.getPassword();
                                System.out.println("1");
                            if(p.length != 0 && p2.length != 0)
                              {
                                                                        System.out.println("2");

                                        if(newTeller.getPassword() == null|| flage == 'C')
                                        {
                                                                            System.out.println("3");

                                            if(Arrays.equals(p, p2))
                                            {
                                                newTeller.setPassword(p);
                                                try {
                                                                                                 System.out.println("4");

                                                                 int id = new BranchManager2().addEmployee(newTeller);
                                                                 System.out.println("bbbbbbbbbbbbbb");
                                                                 System.out.println(id);
                                                                 new BranchManager2().addNewID(id, newTeller.getUsername());
                                                                 System.out.println("ccccccccccccccccccccc");
                                                                 massage.setForeground(Color.GREEN);
                                                                 massage.setText("*Success");
                                                                 Reset();
                                                    } catch (IOException|ClassNotFoundException ex) {
                                                            massage.setText("*sooory can't conect whith system");
                                                                                            System.out.println("5");

                                                    }
                                            }
                                            else
                                            {
                                                massage.setText("*Invalid Password");
                                            }
                                        }
                                        else if(newTeller.getPassword().length != 0 && flage == 'U')
                                        {
                                            if(flage == 'P') // pranch manger to chang any think
                                            {
                                                newTeller.setPassword(p2);
                                                try {
                                                                 System.out.println("11");
                                                                 new BranchManager2().updateEmployee(newTeller);
                                                                 System.out.println("1");
                                                                 massage.setForeground(Color.GREEN);
                                                                 massage.setText("*Success");
                                                                 Reset();
                                                       } catch (IOException|ClassNotFoundException ex) {
                                                           massage.setText("*sooory can't conect whith system");
                                                      }
                                            }
                                            else if(Arrays.equals(p, newTeller.getPassword()))
                                             {
                                                 newTeller.setPassword(p2);
                                                 try {
                                                                 new BranchManager2().updateEmployee(newTeller);
                                                                 massage.setForeground(Color.GREEN);
                                                                 massage.setText("*Success");
                                                                 Reset();
                                                       } catch (IOException|ClassNotFoundException ex) {
                                                           massage.setText("*sooory can't conect whith system");
                                                      }
                                             }
                                            else
                                            {
                                                massage.setText("*Invalied Password");
                                            }             
                                        }        
                              }
                              else
                              {
                                    massage.setText("*Enter Password");
                              }
                            
                            }
                            
                     }
            }
            
            else if(e.getSource() == reset)
            {
                    Reset();
            }

    }
    
    private void Reset()
    {
        Reset1();
        salary.setText("");
        username.setText("");
        password.setText("");
        password2.setText("");
    }
    
}
