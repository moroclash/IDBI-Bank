
package GUI;

import java.awt.event.ActionEvent;


public class delet_Account extends Delet_form{

    public delet_Account() {
        super("Delete Account","AccountNumber");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit)
        {
            if(txfiled1.getText().equals(""))
                massage.setText ("*Please Enter AccountNumber");
        }
        else if(e.getSource()== reset)
        {
            txfiled1.setText("");
        }
    }
    
    
}
