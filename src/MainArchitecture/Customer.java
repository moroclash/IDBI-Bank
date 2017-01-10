/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainArchitecture;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends person implements Serializable{
    String jop;
    
  public void SetJop (String x) 
   {
       this.jop=x;
   }
   public String getJop()
   {
       return this.jop;
   }
  private ArrayList<Integer> MyAccounts= new ArrayList<>();
  public void setMyaccounts(ArrayList x )
  {
     this.MyAccounts=x;
  }
  public ArrayList getMyAccounts ( )
  {
      return this.MyAccounts;
  }
  
  
   
  
     
    
    
}
