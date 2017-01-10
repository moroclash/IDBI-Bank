/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylaptop;

import java.io.Serializable;

/**
 *
 * @author sediek
 */

    //import java.io.Serializable;

public class Person implements Serializable{
    
    private String fName;
    private String lName;
    private String SSN;
    private String  Age;
    private String birthDate;
    private String address;
    private String gender;
    private String eMail;
    private String country;
    private String  id;
    private String phone;

         
        public void setFname(String fName)
        {
        this.fName=fName;    
        
        }
        public String getFname()
        {
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
            this.SSN=SSN;
        }
        public String getSSN()
        {
            return SSN;
        }
         public void setAge(String Age)
        {
            this.Age= Age;
        }
        public String getAge()
        {
            return Age;
        }
         public void setBirthDate(String birthDate)
        {
            this.birthDate=birthDate;
        }
        public String getBirthDate()
        {
            return birthDate;
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
         public void setEmail(String eMail)
        {
            this.eMail=eMail;
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
        public void setID(String id)
        {
            this.id = id;
        }
        public String   getID()
        {
            return this.id;
        }
        public void setPhone(String phone)
        {
            this.phone = phone;
        }
        public String getPhone()
        {
            return this.phone;
        }

}

    

