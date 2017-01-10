/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainArchitecture;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
public class Account implements Serializable{
private long    AccountNum;
private  String CustomerType;
private  double Balance ;
private  int  MyOwner;// in function set we will take cusomer Id and in get we will return customer
//Branch
private  String profit;
private String username;
private char[] passward;

    public void setUsername(String userName)
        {
               this.username=userName;
        }
        public String getUsername()
        {
            return this.username;
        }
         public void setPassward(char[] Password)
        {
            this.passward = Password;
        }
        public char[] getPassward()
        {
            return this.passward;
        }
 public void setMyCutomerType(String x)
{
    this.CustomerType=x;
}
 public String getMyCustomerType()
{
    return this.CustomerType;
}   
 public void setMyOwner(int id)
{
    this.MyOwner=id;
}
 public Customer getMyOwner() throws IOException, ClassNotFoundException
{
    HashMap<Integer,Object> cu= new HashMap<>();
   File customr= new File("CustomersFile");
    ObjectInputStream FR= new ObjectInputStream(new FileInputStream(customr));
    cu= (HashMap<Integer, Object>) FR.readObject(); FR.close();
    return  (Customer) cu.get(this.MyOwner);
}        
public void setAccountNum(Long  y)
{
     this.AccountNum=y;
}
 public long   getAccountNum()
 {
     
  return this.AccountNum;
 }
   public void setBalance(double p)
  {
                if(p<0)
                {
                    p = MyExption.isPositeve(p);
                }	
        Balance=p;
  }
 public double getBalance()
 {
      return Balance ;
 }
 public void setProfit(String   x)
 {
     
  this.profit=x;    
 }
  public String getProfit()
 {
     return this.profit;
 }
  
    
}
