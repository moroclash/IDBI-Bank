
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.HashMap;
import java.util.Map;
import MainArchitecture.Teller;
import Managment.Manager;
import java.awt.Font;


public class Show_table extends standerForm{
    protected char Flage;
    private JTable table;
    public Show_table(String head,HashMap<Integer,Object> puredata,String Department,char flage) {
        super(head);
        this.Flage = flage;
        submit.setVisible(false);
        reset.setVisible(false); //7
        frame.setSize(frame.getBounds().width-25, frame.getBounds().height+buttons.getBounds().height-20);
        this.setResizable(true);
        String []coulms = {"Fname","Lname","Ssn","Age","phone","Salary","Department","Jop","ID"};
        Object[][] data= new Object[puredata.size()][9];
        int i = 0;
   
            for(Object value : puredata.values())
            {
                if(Flage == 'E' && Department.equals(""))
                {
                    if(value instanceof Teller)
                    {
                        Teller x = (Teller) value;
                        data[i][0]= x.getFname();
                        data[i][1]= x.getlname();
                        data[i][2]= x.getSSN();
                        data[i][3]= x.getAge();
                        data[i][4]= x.getPhone();
                        data[i][5]= x.getSalary();
                        data[i][6]= x.getTellerDept();
                        data[i][7]= x.getJobLevel();
                        data[i][8]= x.getID();
                        i++;
                    }
                }
                else if(Flage == 'M' && Department.equals(""))
                {
                    if(value instanceof Manager)
                    {
                        Manager x = (Manager) value;
                        data[i][0]= x.getFname();
                        data[i][1]= x.getlname();
                        data[i][2]= x.getSSN();
                        data[i][3]= x.getAge();
                        data[i][4]= x.getPhone();
                        data[i][5]= x.getSalary();
                        data[i][6]= x.getTellerDept();
                        data[i][7]= x.getJobLevel();
                        data[i][8]= x.getID();
                        i++;
                    }
                }
                
                else if(Flage == 'E' && !Department.equals(""))
                {
                    if(value instanceof Teller)
                    {
                        Teller x = (Teller) value;
                        if(x.getTellerDept().equals(Department))
                        {
                            data[i][0]= x.getFname();
                            data[i][1]= x.getlname();
                            data[i][2]= x.getSSN();
                            data[i][3]= x.getAge();
                            data[i][4]= x.getPhone();
                            data[i][5]= x.getSalary();
                            data[i][6]= x.getTellerDept();
                            data[i][7]= x.getJobLevel();
                            data[i][8]= x.getID();
                            i++;
                        }
                    }
                }
            }
        
        frame.setLayout(new FlowLayout());
        
        table =  new JTable(data, coulms);
        table.setPreferredScrollableViewportSize(new Dimension(frame.getBounds().width-30,frame.getBounds().height+buttons.getBounds().height-150));
        table.setFillsViewportHeight(true);
        table.setBackground(Color.decode("#00836c"));
        table.setForeground(Color.white);
        table.getTableHeader().setBackground(Color.decode("#fcb354"));
        table.getTableHeader().setFont(new Font("Courier",1,10));
        table.getTableHeader().setForeground(Color.white);
        
        table.setBorder(null);
       
        
        JScrollPane scrol = new JScrollPane(table);
        frame.add(scrol);
        this.pack();
      
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
