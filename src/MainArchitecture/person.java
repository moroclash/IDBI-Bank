
package MainArchitecture;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class person implements Serializable{
    
    private String fName;
    private String lName;
    private String SSN;
    private String  Age;
    private String birthDate;
    private String address;
    private String gender;
    private String eMail;
    private String country;
    private int  id;
    private String phone;
   
         
        public void setFname(String fName)
        {
        this.fName=fName;    
        
        }
        public String getFname()
        {;
            return fName;
        }
        public void setlname(String lName)
        {
            this.lName=lName;
        }
        public String getlname()
        {
            return lName;
        }
         public void setSSN(String SSN)
        {
            long x ;
            try{
            
                x= Long.parseLong(SSN);
            
            }
            catch(Exception ex)
            {
                x = MyExption.longex();
            }
            if(x<0)
            {
                x = MyExption.isPositeve(x);
            }
            
            this.SSN=Long.toString(x);
            
        }
        public String getSSN()
        {
            return SSN;
        }
        
        
         public void setAge(String Age)
        {
            int x;
            String p = Age;
            try{
            
                x= Integer.parseInt(Age);
            
            }
            catch(Exception ex)
            {
                x = MyExption.intex();
            }
            if(x < 21 || x> 120)
            {
                p= MyExption.AgeRange(Integer.toString(x));
            }
            
            this.Age= p;
        }
        public String getAge()
        {
            return Age;
        }
         
         public void setAddress(String address)
        {
            this.address=address;
        }
        public String getAddress()
        {
            return address;
        }
        public void setGender(String gender)
        {
            
            this.gender=gender;
        }
        public String getGender()
        {
            return gender;
        }
         public void setEmail(String Email)
        {
            if(!Email.contains("@") || !Email.contains(".com"))
            {
            Email = MyExption.emailForm(Email);
            }
            this.eMail=Email;
        }
        public String getEmail()
        {
            return eMail;
        }
         public void setCountry(String country)
        {
            this.country=country;
        }
        public String getCountry()
        {
            return country;
        }
        public void setID(int id)
        {
           
            this.id = id;
        }
        public int   getID()
        {
            return this.id;
        }
        public void setPhone(String pho)
        {
            this.phone = pho;
        }
        public String getPhone()
        {
            return this.phone;
        }
     
}
