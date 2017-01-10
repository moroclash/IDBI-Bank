
package GUI;

import java.awt.event.ActionEvent;
import MainArchitecture.Teller;
import Managment.BranchManager2;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class search_Employee extends Search_Form{
    
    public search_Employee() {
        super("Search About Employee","ID");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit)
        {
            if(txfiled1.getText().equals("")||txfiled1.getText().equals("ID"))
            {
                massage.setText("*Pleas Enter The Emplyee ID");
            }
            else
            {
                try {
                    int s = new Integer(txfiled1.getText());
                    Teller newEmployee =(Teller) new BranchManager2().showEmployee(s);
                    Show_Employee q = new Show_Employee("Update",newEmployee);             
                    q.address.setText(newEmployee.getAddress());
                    q.age.setText(newEmployee.getAge());
                    // q.Branch.setText(newEmployee.getBranch());
                    q.cuntry.setText(newEmployee.getCountry());
                    q.dpart.setText(newEmployee.getTellerDept());
                    q.mail.setText(newEmployee.getEmail());
                    q.fname.setText(newEmployee.getFname() + " " +newEmployee.getlname());
                    q.gander.setText(newEmployee.getGender());
                    q.id.setText(Integer.toString(newEmployee.getID()));
                    q.jop.setText(newEmployee.getJobLevel());
                    q.phone.setText(newEmployee.getPhone());
                    q.salary.setText(newEmployee.getSalary());
                    q.ssn.setText(newEmployee.getSSN());
                    q.username.setText(newEmployee.getUsername());
                    q.Flage = 'D';
                    mainfram.removeAll();
                    mainfram.add(q.getmainform());
                    mainfram.repaint();
                } catch (IOException|ClassNotFoundException ex) {
                      massage.setText("4o8l tahaa feeeh error w mtnsaaa4 tms7 el exiption dh");
                }catch (Exception ex) {
                    massage.setText("*Employee not found");
                  } 
            }
        
        }
        else if(e.getSource()== reset)
        {
            txfiled1.setText("");
        }
    }
    
}
