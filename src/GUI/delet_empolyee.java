
package GUI;

import java.awt.event.ActionEvent;


public class delet_empolyee extends Delet_form{

    public delet_empolyee() {
        super("Delete Employee","ID");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit)
        {
        
        }
        else if(e.getSource()== reset)
        {
            txfiled1.setText("");
        }
    }
    
}
