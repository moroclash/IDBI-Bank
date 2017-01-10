
package GUI;

import java.awt.event.ActionEvent;


public class delete_DeptManager extends Delet_form{
    public delete_DeptManager() {
        super("Delete DeptartManager","ID");
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
