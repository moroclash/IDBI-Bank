
package GUI;

import Managment.History;
import Managment.HistoryObject;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Search_histry extends form_one_std_filed{

    public Search_histry() {
        super("Hestory");
        tx1.setText("Search");
        submit.setText("Searsh");
        submit.addActionListener(this);
        reset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit)
        {
            HistoryObject data;
            try {
                data = new History().showHisoryOf(Integer.parseInt(txfiled1.getText()));
                frame.removeAll();
                frame.add(new Show_history("History", data.getHistory()).getmainform());
                frame.repaint();
            } catch (IOException|ClassNotFoundException ex) {
                    massage.setText("*ID not Exist");
            } catch (Exception ex) {
                massage.setText("*4o8ly payez");
            }
        }
        else if(e.getSource() == reset)
        {
            txfiled1.setText("");
        }
    }
    
}
