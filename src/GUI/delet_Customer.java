
package GUI;

import java.awt.event.ActionEvent;


public class delet_Customer extends Delet_form{

    public delet_Customer() {
        super("Delet Customer","CustomerID");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit)
        {
            if(txfiled1.getText().equals(""))
                massage.setText("*Please Enter Customer ID");
        }
        else if(e.getSource()== reset)
        {
            txfiled1.setText("");
        }
    
    }
    
    
}
