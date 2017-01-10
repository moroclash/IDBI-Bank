
package GUI;

import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset; 
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class Circle_grafe extends ApplicationFrame implements WindowListener{
  private String n1,n2,n3,n4;
    private int num1,num2,num3,num4;
    public Circle_grafe( String title ,String n1,String n2,String n3,String n4,int num1,int num2,int num3,int num4) {     
       super( title );     
       this.n1 = n1;
       this.n2 = n2;
       this.n3 = n3;
       this.n4 = n4;
       this.num1 = num1;
       this.num2 = num2;
       this.num3 = num3;
       this.num4 = num4;
       this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setContentPane(createDemoPanel( ));  
  }  
     private  PieDataset createDataset( ){    
     DefaultPieDataset dataset = new DefaultPieDataset( ); 
        dataset.setValue( this.n1 , new Double( num1 ) ); 
        dataset.setValue( this.n2 , new Double( num2 ) ); 
        dataset.setValue( this.n3 , new Double( num3 ) );
        dataset.setValue( this.n4 , new Double( num4 ) ); 
        return dataset;            
     }   
      private static JFreeChart createChart( PieDataset dataset ){  
        JFreeChart chart = ChartFactory.createPieChart( 
               "Statistic",
               dataset,
               true,
               true,
               false
      );  
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
       plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.005);
          return chart;    
      }  
     public  JPanel createDemoPanel( ){   
         JFreeChart chart = createChart(createDataset( ) ); 
         return new ChartPanel( chart ); 
     } 
     
     public void windowClosing(WindowEvent we)
     {
         dispose();
         dispose();
         Pranch_Manager_menu x = new Pranch_Manager_menu();
         x.setVisible(true);
     }

    public void windowClosed(WindowEvent we)
    {
    
    
    }
      
 }
