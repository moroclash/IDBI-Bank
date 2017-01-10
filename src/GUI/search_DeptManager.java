
package GUI;

import Managment.BranchManager2;
import Managment.Manager;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Managment.Employee;

public class search_DeptManager  extends Search_Form{
   
    public search_DeptManager() {
        super("Search About DepartManager","ID");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit)
        {
            if(txfiled1.getText().equals("")||txfiled1.getText().equals("ID"))
                massage.setText("*Pleas Enter ID");
            else
            {
                try {
                    int s = new Integer(txfiled1.getText());
                    Employee newEmployee = (Manager) new BranchManager2().showEmployee(s);
                    Show_Employee q = new Show_Employee("Update",newEmployee);             
                    q.address.setText(newEmployee.getAddress());
                    q.age.setText(newEmployee.getAge());
                    q.branch.setText(newEmployee.getBranch());
                    q.cuntry.setText(newEmployee.getCountry());
                    q.dpart.setText(newEmployee.getTellerDept());
                    q.mail.setText(newEmployee.getEmail());
                    q.fname.setText(newEmployee.getFname());
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
                    massage.setText("*error 4ol tahaa"); // mtnssaa4 tms7 el catch deh
                }
                catch (Exception ex) {
                    massage.setText("*Manager not Found");
                }
                
            }
        
        }
        else if(e.getSource()== reset)
        {
            txfiled1.setText("");
        }
    }
    
}
