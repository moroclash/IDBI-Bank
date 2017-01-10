package MainArchitecture;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javax.swing.JOptionPane;
import sun.security.x509.Extension;

public class MyExption extends Exception{

   
    
    
    
    public static int intex()
    {
        boolean flage = true;
        int x = 0;
        while(flage)
        {
            flage= false;
            try{
                x = new Integer(JOptionPane.showInputDialog("please enter numper ")); 
                
            
            }
            catch(Exception e)
            {flage=true;}
        }
        return x;
    }
    
    public  static  Long longex()
    {
        long x=0;
        boolean flag= true;
        while(flag)
        {
            flag=false;
            try
            {
                x= new Long(JOptionPane.showInputDialog("please enter  number "));
                
            }
            catch(Exception e){flag = true;}
            
        }
        return x;
    }
    
    
public static double  isPositeve(double n)
{
  boolean flage = true;
  
  while (flage)
  {
      flage= false;
       if(n<0) { n= new Integer(JOptionPane.showInputDialog("please enter positive number"));flage= true;}
       
  }
  return  n;
}
public static long  isPositeve(long n)
{
  boolean flage = true;
  
  while (flage)
  {
      flage= false;
      if(n<0) { n= new Long(JOptionPane.showInputDialog("please enter positive number"));flage= true;}
  }
  return  n;
}
 public static String emailForm(String x)
 {
     
     String Email= new String();
     Email=x;
     boolean flag=true;
     while (flag) {
         flag=false;
       if(!Email.contains("@") || !Email.contains(".com"))
       {
         Email = JOptionPane.showInputDialog("Enter email contaian .com and @");
           flag=true;
       }
     }
     return Email;
 }
 
 public  static String  AgeRange(String a)
 {
  String Age= new String();
  Age=a;
  boolean flag= true;
  while(flag)
  {
       flag= false;
       if(Age!=null){
         int g= new Integer(Age); 
         if(g<18||g>120 )
      {
      Age = JOptionPane.showInputDialog("Age should be greater than or equals to 18 and lower than 120");
      flag= true;
      }
       }
       if(Age==null)
       {
          Age = JOptionPane.showInputDialog("Age should be greater than or equals to 18 and lower than 120");  
       }
  }
     return Age;
 }
 
 
 
 
 public  static  String password(String x)
 {
     String password= x;
     boolean flag = true;
     while(flag)
     {
         flag= false;
         if(password.length()<8)
         {
             flag=true;
             password= JOptionPane.showInputDialog("PassWord shoul me > 8 chrachter");  
         }
     }
     return password;
 }
 
 }