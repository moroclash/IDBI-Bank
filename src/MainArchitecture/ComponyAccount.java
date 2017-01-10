
package MainArchitecture;
import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ComponyAccount extends Account implements ITransaction{
    private String CompanyName;
    private  String Location;
    private  String Telephone ;
   public  void setCompanyName(String x)
   {
       this.CompanyName=x;
   }
    
   public  String getComanyName()
   {
       return this.CompanyName;
   }
   public void setLocation(String x)
   {
       this.Location=x;
   }
   public  String getLoacation()
   {
       return this.Location;
   }
   public void setTelephone(String x )
   {
       this.Telephone=x;
   }
   public String getTelephone()
   {
       return this.Telephone;
   }
   public int withdraw(double  money)
  { 
        try {
            File withdrawCounter= new File ("withdrawCounter");
            if(withdrawCounter.length()==0)
            { ObjectOutputStream  FWC= new ObjectOutputStream(new FileOutputStream(withdrawCounter));
            FWC.writeInt(0);FWC.close();}
            ObjectInputStream FWR= new ObjectInputStream(new FileInputStream(withdrawCounter));
            int i= FWR.readInt();FWR.close();
            // return 1 sucss
            // return 2 money > 10000
            // retern  0 money> balance
            if(money > this.getBalance())return 0;
            if (money <this.getBalance())
            {
                ObjectInputStream FRA= null;
                try {
                    if(money >10000)
                    {
                        JOptionPane.showMessageDialog(null, "you cannont withdraw more than 10000 dolar");
                        return 2;
                        
                    }       File userNameFile= new File("userNames");
                    File Accounts =new File("AccountsFile");
                    HashMap<String,Object> hAccounts= new HashMap<>();
                    FRA = new ObjectInputStream(new FileInputStream(Accounts));
                    hAccounts= (HashMap<String, Object>) FRA.readObject();
                    FRA.close();
                    Account aa= (Account) hAccounts.get(this.getUsername());
                    double b=this.getBalance();
                    b=b-money;
                    aa.setBalance(b);
                    ObjectOutputStream FR= new ObjectOutputStream(new FileOutputStream(Accounts));
                    FR.writeObject(hAccounts);
                    FR.close();
                    i= i+1;
                    ObjectOutputStream FWC= new ObjectOutputStream(new FileOutputStream(withdrawCounter));
                    FWC.writeInt(i);FWC.close();
                } catch (IOException ex) {
                    Logger.getLogger(ComponyAccount.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ComponyAccount.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        FRA.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ComponyAccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ComponyAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
     return 1;   
  }
  
  
  
  
public int transfer (long   AccountNumber,double  money )throws IOException,FileNotFoundException,ClassNotFoundException
   {
       
         //if money > blance return 2
        // if trnsfer to not found return 0
        // return 1 sucsess
         File t= new File("TransferCounter");
         if(t.length()==0)
         {
             ObjectOutputStream FW= new  ObjectOutputStream(new FileOutputStream(t));
             FW.writeInt(0);FW.close();
         }
         ObjectInputStream FRt= new ObjectInputStream(new FileInputStream(t));
         int i = FRt.readInt(); FRt.close();
         
       if(money > this.getBalance()) return 2;
       else 
       if(money <  this.getBalance())
       {
        File userNameFile= new File("userNames");
        File Accounts =new File("AccountsFile");
        HashMap<String,Object> hAccounts= new HashMap<>();
        HashMap<Long ,String> AccountOfUsers= new HashMap<>();
        ObjectInputStream FR= new ObjectInputStream(new FileInputStream(userNameFile));
        AccountOfUsers =  (HashMap<Long, String>) FR.readObject();FR.close();
        String x= AccountOfUsers.get(new Long(AccountNumber));
        if(x==null) {System.out.println("NOT FOUND"); return 0;}
        ObjectInputStream FRA= new ObjectInputStream(new FileInputStream(Accounts));
        hAccounts= (HashMap<String, Object>) FRA.readObject();  FRA.close();
        ComponyAccount co = (ComponyAccount) hAccounts.get(x);
        ComponyAccount co2 = (ComponyAccount) hAccounts.get(this.getUsername());
        co2.setBalance(this.getAccountNum()-money);
        co.setBalance(co.getBalance()+money);
        hAccounts.put(x, co);
        hAccounts.put(this.getUsername(), co2);
        ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(Accounts));
        FW.writeObject(hAccounts); FW.close();
        i=i+1;
        ObjectOutputStream FWt= new ObjectOutputStream(new FileOutputStream(t));
        FWt.writeInt(i);FWt.close();
       }
          
   return 1;
  
   }
}