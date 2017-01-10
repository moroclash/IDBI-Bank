
package MainArchitecture;


import Managment.Employee;
import Managment.Manager;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FilterOutputStream;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Teller  extends  Employee implements  Serializable{

Manager MyManager;
public  void setMymanager(Manager x)
{
    this.MyManager=x;
}
public  Manager getMydeptManager()
  {
     return this.MyManager;
  }

 public void  DeleteAccount ( long   AccountNumber ) throws ClassNotFoundException,FileNotFoundException,IOException
     {
         HashMap<Integer,Object> Customers= new HashMap<>();
         File CustomersFile = new File("CustomersFile");
         if(CustomersFile.length()==0) return;
         ObjectInputStream FRC= new ObjectInputStream(new FileInputStream(CustomersFile));
         Customers=(HashMap<Integer, Object>) FRC.readObject(); FRC.close(); 
         HashMap<Long ,String> AccountOfUsers= new HashMap<>();
         File userAccount= new File("userNames");
         if( userAccount.length()!=0)
         {
         ObjectInputStream FR =new ObjectInputStream (new FileInputStream (userAccount));
         AccountOfUsers=   (HashMap<Long, String>) FR.readObject();FR.close(); 
         String AccountUserName= AccountOfUsers.get(new Long(AccountNumber));
         System.out.println(AccountOfUsers.get(AccountNumber));
         AccountOfUsers.remove(new Long(AccountNumber));
         ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(userAccount));
         FW.writeObject(AccountOfUsers);
         FW.close();
         File Accounts =new File("AccountsFile");
         ObjectInputStream FRA= new ObjectInputStream(new FileInputStream(Accounts));
         HashMap<String,Object> hAccounts= new HashMap<>();
         hAccounts = (HashMap<String, Object>) FRA.readObject();
         FRA.close();
         if (hAccounts.get(AccountUserName)instanceof PersonalAccount)
         {
            PersonalAccount pe= (PersonalAccount) hAccounts.get(AccountUserName);
            System.out.println(pe.getAccountNum()+pe.getMyOwner().getID());
            int id= pe.getMyOwner().getID();
            Customer c=(Customer) Customers.get(new Integer(id));
            ArrayList <Long > accs= c.getMyAccounts();
            System.out.println(accs.indexOf(AccountNumber));
            accs.remove(pe.getAccountNum());
             
         }
          if (hAccounts.get(AccountUserName)instanceof ComponyAccount)
         {
          ComponyAccount co = (ComponyAccount) hAccounts.get(AccountUserName);
            int id= co.getMyOwner().getID();
            Customer c=(Customer) Customers.get(new Integer(id));
            ArrayList <Long > accs= c.getMyAccounts();
            accs.remove(co.getAccountNum());
         }
         this.deleteId(AccountNumber);
         hAccounts.remove(AccountUserName);
         ObjectOutputStream FWA = new ObjectOutputStream(new FileOutputStream(Accounts));
         FWA.writeObject(hAccounts);
         FWA.close();
         ObjectOutputStream FWC= new ObjectOutputStream(new FileOutputStream(CustomersFile));
         FWC.writeObject(Customers);
         FWC.close();
        }
     
     }
public void EditCustomer(Customer x) throws FileNotFoundException, IOException, ClassNotFoundException
{
    File cf= new File("CustomersFile");
    ObjectInputStream FR= new ObjectInputStream(new FileInputStream(cf));
    HashMap<Integer,Customer> customers= new HashMap<>();
    customers= (HashMap<Integer, Customer>) FR.readObject(); FR.close();
    customers.put(x.getID(), x);
    ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(cf));
    FW.writeObject(customers); FW.close();
     
}
public  void EditAccount(Object x) throws FileNotFoundException, IOException, ClassNotFoundException
{
    File AC= new File("AccountsFile");
    ObjectInputStream FR = new ObjectInputStream(new FileInputStream(AC));
    HashMap <String,Object> Accounts= new HashMap();
    Accounts = (HashMap<String, Object>) FR.readObject();
    if(x instanceof  PersonalAccount)
    {
      PersonalAccount pe= new PersonalAccount();
      pe = (PersonalAccount) x;
      Accounts.put(pe.getUsername(), pe);
    }
    if(x instanceof ComponyAccount)
    {
       ComponyAccount co =(ComponyAccount) x;
       Accounts.put(co.getUsername(), co);
    }
    ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(AC));
    FW.writeObject(Accounts); FW.close();
}
 
 
 
 
public void  addAccount (Object  x) throws IOException, ClassNotFoundException,NullPointerException
  {
    File CustomersFile= new File("CustomersFile");
    File AccountsFile=new File ("AccountsFile");
    File userNameFile= new File("userNames");
    File lasstId= new File("LastId");
    int id;
       
    HashMap<Long,String> userName= new HashMap<>();
    HashMap<String ,Object> Accounts= new HashMap<>();
    HashMap <Integer,Customer> Customers= new HashMap<>();
    if(x instanceof PersonalAccount)
    {
        PersonalAccount pe = (PersonalAccount) x;
       if(userNameFile.length()==0)
     {
            
       if(lasstId.length()==0) 
      {
          id=1001;
       ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      } // end of end if lastId
      else{
       ObjectInputStream FR = new ObjectInputStream(new FileInputStream(lasstId));
      id = FR.readInt(); FR.close();
      id= id+2;
      ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      }//end of LastId Lenrth else  
         if(pe.getMyOwner()==null) {JOptionPane.showMessageDialog(null, "you should enter correct customer ID");return;}
         pe.setAccountNum(new Long (1001));
         userName.put(new Long(1001), pe.getUsername());
         Accounts.put(pe.getUsername(), pe);
         ObjectOutputStream writeUserName= new ObjectOutputStream(new FileOutputStream(userNameFile));
         writeUserName.writeObject(userName);writeUserName.close();
         ObjectOutputStream WriteAccouts= new ObjectOutputStream(new FileOutputStream(AccountsFile));
         WriteAccouts.writeObject(Accounts); WriteAccouts.close();
         this.AddID(pe.getUsername(),1001);
     /*****************************Adding the Account in the Customer Accounts**************/
       ObjectInputStream readCustomers= new ObjectInputStream(new FileInputStream(CustomersFile));
       Customers= (HashMap<Integer, Customer>) readCustomers.readObject(); readCustomers.close();
       Customer c=Customers.get(new Integer(pe.getMyOwner().getID()));
       ArrayList<Integer> acc= new ArrayList<>();
       acc=c.getMyAccounts();
       acc.add(1001);
       c.setMyaccounts(acc); 
       Customers.put(pe.getMyOwner().getID(), c);
       ObjectOutputStream writeCustomers= new ObjectOutputStream(new FileOutputStream(CustomersFile));
       writeCustomers.writeObject(Customers); writeCustomers.close();
       } // end of there is no accounts 
       else
       {
           
        ObjectInputStream readUsersnme= new ObjectInputStream(new FileInputStream(userNameFile));
        userName=  (HashMap<Long, String>) readUsersnme.readObject(); readUsersnme.close();
       if(userName.containsValue(pe.getUsername())) {JOptionPane.showMessageDialog(null,"the user name is exst pleas enter another namw");return;}
       if(lasstId.length()==0) 
      {
          id=1001;
       ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      } // end of end if lastId
      else{
       ObjectInputStream FR = new ObjectInputStream(new FileInputStream(lasstId));
      id = FR.readInt(); FR.close();
      id= id+2;
      ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      }//end of LastId Lenrth else
         pe.setAccountNum(new Long(id));
        userName.put(pe.getAccountNum(), pe.getUsername()); System.out.println("hhh"+id);
        ObjectOutputStream WriteUsersname= new ObjectOutputStream(new FileOutputStream(userNameFile));
        WriteUsersname.writeObject(userName);WriteUsersname.close();
        ObjectInputStream readAccounts= new ObjectInputStream(new FileInputStream(AccountsFile));
        Accounts= (HashMap<String, Object>) readAccounts.readObject(); readAccounts.close();
        Accounts.put(pe.getUsername(), pe);
        ObjectOutputStream WriteAccounts= new ObjectOutputStream(new FileOutputStream(AccountsFile));
        WriteAccounts.writeObject(Accounts); WriteAccounts.close();
          this.AddID(pe.getUsername(),id);
         /*****************************Adding the Account in the Customer Accounts**************/
       ObjectInputStream readCustomers= new ObjectInputStream(new FileInputStream(CustomersFile));
        Customers= (HashMap<Integer, Customer>) readCustomers.readObject(); readCustomers.close();
        //System.out.println(Customers.size());
        Customer c=Customers.get(pe.getMyOwner().getID());
       // System.out.println("tttt"+pe.getAccountNum());
        ArrayList<Long > acc;
        acc=c.getMyAccounts();
        acc.add(new Long(id));
        //System.out.println(acc.size());
        c.setMyaccounts(acc);
        Customers.put(new Integer(pe.getMyOwner().getID()) , c);
        ObjectOutputStream writeCustomers= new ObjectOutputStream(new FileOutputStream(CustomersFile));
       writeCustomers.writeObject(Customers); writeCustomers.close();
        
       } 
    } 
   ////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////// 
   //////////////////////////////////////////////////////////////////////////////////////////// 
    
    
    if(x instanceof ComponyAccount)
    {
         ComponyAccount co= (ComponyAccount) x;
          if(userNameFile.length()==0)
       {
           
       if(lasstId.length()==0) 
      {
          id=1001;
       ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      } // end of end if lastId
      else{
       ObjectInputStream FR = new ObjectInputStream(new FileInputStream(lasstId));
      id = FR.readInt(); FR.close();
      id= id+2;
      ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      }//end of LastId Lenrth else
         co.setAccountNum(new Long(1001));
         userName.put(new Long (1001), co.getUsername());
         Accounts.put(co.getUsername(), co);
         ObjectOutputStream writeUserName= new ObjectOutputStream(new FileOutputStream(userNameFile));
         writeUserName.writeObject(userName);writeUserName.close();
         ObjectOutputStream WriteAccouts= new ObjectOutputStream(new FileOutputStream(AccountsFile));
         WriteAccouts.writeObject(Accounts); WriteAccouts.close();
           this.AddID(co.getUsername(),id );
         /*****************************Adding the Account in the Customer Accounts**************/
       ObjectInputStream readCustomers= new ObjectInputStream(new FileInputStream(CustomersFile));
        Customers= (HashMap<Integer, Customer>) readCustomers.readObject(); readCustomers.close();
        Customer c=Customers.get(co.getMyOwner().getID());
        ArrayList<Integer> acc= new ArrayList<>();
        acc=c.getMyAccounts();
        acc.add(1001);
        c.setMyaccounts(acc);
        Customers.put(co.getMyOwner().getID(), c);
         ObjectOutputStream writeCustomers= new ObjectOutputStream(new FileOutputStream(CustomersFile));
         writeCustomers.writeObject(Customers); writeCustomers.close();
        
       } 
       else
       {
           
       ObjectInputStream readUsersnme= new ObjectInputStream(new FileInputStream(userNameFile));
       userName=  (HashMap<Long, String>) readUsersnme.readObject(); readUsersnme.close();
      if(userName.containsValue(co.getUsername())) {JOptionPane.showMessageDialog(null,"the user name is exst pleas enter another namw");return;}
       if(lasstId.length()==0) 
      {
          id=1001;
       ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      } // end of end if lastId
      else{
       ObjectInputStream FR = new ObjectInputStream(new FileInputStream(lasstId));
      id = FR.readInt(); FR.close();
      id= id+2;
      ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
      }//end of LastId Lenrth else
        co.setAccountNum(new Long(id));
        userName.put(new Long (id), co.getUsername());
        ObjectOutputStream WriteUsersname= new ObjectOutputStream(new FileOutputStream(userNameFile));
        WriteUsersname.writeObject(userName);WriteUsersname.close();
        ObjectInputStream readAccounts= new ObjectInputStream(new FileInputStream(AccountsFile));
        Accounts= (HashMap<String, Object>) readAccounts.readObject(); readAccounts.close();
        Accounts.put(co.getUsername(), co);
        ObjectOutputStream WriteAccounts= new ObjectOutputStream(new FileOutputStream(AccountsFile));
        WriteAccounts.writeObject(Accounts); WriteAccounts.close();
          this.AddID(co.getUsername(),id);
        /*****************************Adding the Account in the Customer Accounts**************/
       ObjectInputStream readCustomers= new ObjectInputStream(new FileInputStream(CustomersFile));
        Customers= (HashMap<Integer, Customer>) readCustomers.readObject(); readCustomers.close();
        Customer c=Customers.get(co.getMyOwner().getID());
        ArrayList<Long> acc= new ArrayList<>();
        acc=c.getMyAccounts();
        acc.add(new Long(id));
        c.setMyaccounts(acc);
        Customers.put(co.getMyOwner().getID(), c);
         ObjectOutputStream writeCustomers= new ObjectOutputStream(new FileOutputStream(CustomersFile));
         writeCustomers.writeObject(Customers); writeCustomers.close();
        
       } 
    }
    
  }
 
  public boolean deposit(long AccountNumber,double  Money) throws FileNotFoundException, IOException, ClassNotFoundException
  {
      //returm false if therse no accounts or the account number not correct
      // return true if sucs
      HashMap<String,Object> hAccounts= new HashMap<>();
      HashMap<Long,String> AccountOfUsers= new HashMap<>();
      File userNameFile= new File("userNames");
        if(userNameFile.length()==0) return false;
        if( userNameFile.length()!=0)
        {
         ObjectInputStream FR =new ObjectInputStream (new FileInputStream (userNameFile));
         AccountOfUsers= (HashMap<Long, String>) FR.readObject(); 
         String AccountUserName= AccountOfUsers.get(new Long(AccountNumber));
         FR.close(); 
         File Accounts =new File("AccountsFile");
         ObjectInputStream FRA= new ObjectInputStream(new FileInputStream(Accounts));
         hAccounts= (HashMap<String, Object>) FRA.readObject();
         if(hAccounts.get(AccountUserName)instanceof PersonalAccount)
         {
             PersonalAccount pe = (PersonalAccount) hAccounts.get(AccountUserName);
             double balance = pe.getBalance();
             balance= balance+ Money;
             pe.setBalance(balance);
             hAccounts.put(AccountUserName, pe);
             ObjectOutputStream FWA= new ObjectOutputStream(new FileOutputStream(Accounts));
             FWA.writeObject(hAccounts);
             FWA.close();
         }
         else 
         if 
         (hAccounts.get(AccountUserName) instanceof ComponyAccount)
         {
            ComponyAccount co = (ComponyAccount) hAccounts.get(AccountUserName);
             double balance = co.getBalance();
             balance= balance+ Money;
             co.setBalance(balance);
             hAccounts.put(AccountUserName, co);
             ObjectOutputStream FWA= new ObjectOutputStream(new FileOutputStream(Accounts));
             FWA.writeObject(hAccounts);
             FWA.close(); 
         }
         if 
         (hAccounts.get(AccountUserName) instanceof ComponyAccount) {JOptionPane.showInputDialog("the accountnum not found");return false;}
        }
        return true;
  }
  
  
  
  public  Object showAccount(long AccountNumber) throws IOException, ClassNotFoundException
  {
      
      HashMap<String,Object> hAccounts= new HashMap<>();
      HashMap<Long,String> AccountOfUsers= new HashMap<>();
      File userNameFile= new File("userNames");
        if( userNameFile.length()!=0)
      {
      ObjectInputStream FR =new ObjectInputStream (new FileInputStream (userNameFile));
      AccountOfUsers= (HashMap<Long, String>) FR.readObject(); FR.close();
      String AccountUserName= AccountOfUsers.get(new Long(AccountNumber)); 
      if(AccountUserName==null) {JOptionPane.showMessageDialog(null, "Account number not founf"); return null;}
      File Accounts =new File("AccountsFile");
      ObjectInputStream FRA= new ObjectInputStream(new FileInputStream(Accounts));
      hAccounts= (HashMap<String, Object>) FRA.readObject();
      return hAccounts.get(AccountUserName);     
      }
      return null;
  }
  
  
  
  public  int withdraw(long Accountnumber,double  Money,String SSN) throws FileNotFoundException, IOException, ClassNotFoundException
  {
      
      // if account not found return 0
      // return 1 sucss
      // return 2 if mony > balance
      // if SSN Not cOOrect return 0
    File CustomersFile= new File("CustomersFile");
    HashMap <Integer,Customer> Customers= new HashMap<>();
    HashMap<String,Object> hAccounts= new HashMap<>();
    HashMap<Long,String> AccountOfUsers= new HashMap<>();
    File userNameFile= new File("userNames");
    File Accounts =new File("AccountsFile");
    ObjectInputStream FR= new ObjectInputStream(new FileInputStream(userNameFile));
    AccountOfUsers = (HashMap<Long, String>) FR.readObject();
    String x = AccountOfUsers.get(new Long(Accountnumber));
    FR.close();
    ObjectInputStream FRH= new ObjectInputStream(new FileInputStream(Accounts));
    hAccounts= (HashMap<String, Object>) FRH.readObject();
    FRH.close();
    if (hAccounts.get(x) instanceof  PersonalAccount)
    {
        ObjectInputStream FRC= new ObjectInputStream(new FileInputStream(CustomersFile));
        Customers= (HashMap<Integer, Customer>) FRC.readObject();FRC.close();
        PersonalAccount pe = (PersonalAccount) hAccounts.get(x);
        if(pe==null) return 0;
        if(pe.getBalance()<Money)return 2;
         Customer c= Customers.get(pe.getMyOwner().getID());
         if(!c.getSSN().equals(SSN))return 0;
        pe.setBalance(pe.getBalance()-Money);
        hAccounts.put(x, pe);
        ObjectOutputStream FWH= new ObjectOutputStream(new FileOutputStream(Accounts));
        FWH.writeObject(hAccounts);
        FWH.close();
    }
     if (hAccounts.get(x) instanceof  ComponyAccount)
    {
        ObjectInputStream FRC= new ObjectInputStream(new FileInputStream(CustomersFile));
        Customers= (HashMap<Integer, Customer>) FRC.readObject();FRC.close();
        ComponyAccount co =  (ComponyAccount) hAccounts.get(x);
        if(co == null) {JOptionPane.showMessageDialog(null, "this Account not found");return 0;}
        if(co.getBalance()<Money )return 2;
        Customer c= Customers.get(co.getMyOwner().getID());
        if(!c.getSSN().equals(SSN)) {JOptionPane.showMessageDialog(null, "The SSN not correct"); ; return 0;}
        co.setBalance(co.getBalance()-Money);
        hAccounts.put(x, co);
        ObjectOutputStream FWH= new ObjectOutputStream(new FileOutputStream(Accounts));
        FWH.writeObject(hAccounts);
        FWH.close();
    }
  return 1;
  }
  
  
  
  public  int Transfer(long AccountNumber,long  trToAccountNumber,double  money,String SSN) throws IOException, ClassNotFoundException
  {
       // if account not found return 0
      // return 1 sucss
      // if money > balance return 2
      // if SSN Not cOOrect return 0
      // return 3 if the trnsfer or transfer to not found
  //    //                                             //
    File CustomersFile= new File("CustomersFile");
    HashMap <Integer,Customer> Customers= new HashMap<>();
    
    //              b
    File userNameFile= new File("userNames");
    File Accounts =new File("AccountsFile");
    ObjectInputStream FR= new ObjectInputStream(new FileInputStream(userNameFile));
    HashMap<String,Object> hAccounts= new HashMap<>();FR.close();
    HashMap<Long ,String> AccountOfUsers= new HashMap<>();
    ObjectInputStream FRU= new ObjectInputStream(new FileInputStream(userNameFile));
    AccountOfUsers = (HashMap<Long, String>) FRU.readObject(); FRU.close();
    ObjectInputStream FRA= new ObjectInputStream(new FileInputStream(Accounts));
    hAccounts = (HashMap<String, Object>) FRA.readObject(); FRA.close();
    String x= AccountOfUsers.get(new Long (AccountNumber));
    String y= AccountOfUsers.get(new Long(trToAccountNumber));
    if(hAccounts.get(x)instanceof PersonalAccount)
    {   ObjectInputStream FRC= new ObjectInputStream(new FileInputStream(CustomersFile));
        Customers= (HashMap<Integer, Customer>) FRC.readObject();FRC.close();
        PersonalAccount pe1,pe2 = new PersonalAccount();
        pe1= (PersonalAccount) hAccounts.get(x);
        if(pe1== null)return 0;
        Customer  c= Customers.get(pe1.getMyOwner().getID());
        if(!c.getSSN().equals(SSN)) {JOptionPane.showInputDialog("THE SSN NOT CORRECT") ; return 0;}
        pe2= (PersonalAccount) hAccounts.get(y);
        if(pe2 ==null) return 3;
        if(pe1.getBalance()<money)return 2;
        pe1.setBalance(pe1.getBalance()-money);
        pe2.setBalance(pe2.getBalance()+money);
        hAccounts.put(y, pe2);
        hAccounts.put(x, pe1);
        ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(Accounts));
        FW.writeObject(hAccounts);FW.close();
    }
    if(hAccounts.get(x)instanceof ComponyAccount)
    {
       ObjectInputStream FRC= new ObjectInputStream(new FileInputStream(CustomersFile));
       Customers= (HashMap<Integer, Customer>) FRC.readObject();FRC.close();
      ComponyAccount co1 =new ComponyAccount();
       ComponyAccount co2 = new ComponyAccount();
        co1=  (ComponyAccount) hAccounts.get(x);
        if(co1==null)return 0;
        Customer c= Customers.get(co1.getMyOwner().getID());
        if(!c.getSSN().equals(SSN)) {JOptionPane.showInputDialog("THE SSN NOT CORRECT") ; return 0;}
        co2=  (ComponyAccount) hAccounts.get(y);
        if(co2 ==null) return 3;
        if(co1.getBalance()<money)return 2;
        co1.setBalance(co1.getBalance()-money);
        co2.setBalance(co2.getBalance()+money);
        hAccounts.put(y, co2);
        hAccounts.put(x, co1);
        ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(Accounts));
        FW.writeObject(hAccounts);FW.close();
    }
        
    return 1;
  }
  
  
  public  Customer ShowCustomer(int ID) throws IOException, ClassNotFoundException
  {
      HashMap<Integer,Object> Customers= new HashMap<>();
      File CustomersFile = new File("CustomersFile");
      if(CustomersFile.length()==0) {JOptionPane.showInputDialog("There is no Customers To show"); return null ;}
       ObjectInputStream FR= new ObjectInputStream(new FileInputStream(CustomersFile));
       Customers= (HashMap<Integer, Object>) FR.readObject();
       Customer x= new Customer();
       x=(Customer) Customers.get(new Integer(ID));
       return x;
  }
  
  
  
  
  public  int addCustomer(Customer x) throws IOException, ClassNotFoundException
  {
        File lasstId= new File("LastIdCus");
    int id;
       if(lasstId.length()==0) 
      {
          id=10;
       ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();}
      else{
       ObjectInputStream FR = new ObjectInputStream(new FileInputStream(lasstId));
      id = FR.readInt(); FR.close();
      id= id+10;
      ObjectOutputStream FW= new ObjectOutputStream (new FileOutputStream(lasstId));
         FW.writeInt(id);FW.close();
       }
      HashMap<Integer,Object> Customers= new HashMap<>();
      File CustomersFile = new File("CustomersFile");
      if(CustomersFile.length()!=0)
      {
       ObjectInputStream FR= new ObjectInputStream(new FileInputStream(CustomersFile));
       Customers=(HashMap<Integer, Object>) FR.readObject(); FR.close();
       x.setID(id); System.out.println(id);
       Customers.put(new Integer(id), x);
       ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(CustomersFile));
       FW.writeObject(Customers);  FW.close();
      }
      if(CustomersFile.length()==0)
      {
      Customers.put(10, x);
      x.setID(10);
      ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(CustomersFile));
      FW.writeObject(Customers); FW.close();
      
      }
      return id;
  }
  
 
  public  void DeleteCustomer(int id) throws FileNotFoundException, IOException, ClassNotFoundException
  {
     HashMap<Integer,Object> Customers= new HashMap<>();
      File CustomersFile = new File("CustomersFile");
      if(CustomersFile.length()==0)return;  
      ObjectInputStream FR= new ObjectInputStream(new FileInputStream(CustomersFile));
      Customers=(HashMap<Integer, Object>) FR.readObject();   FR.close();  
      Customer x=(Customer) Customers.get(id);
        if(x==null) {JOptionPane.showInputDialog("your Id is not founf");return;}
          ArrayList<Long > acc= x.getMyAccounts();
          for(Long i:acc)
          {
              this.DeleteAccount(i);
          }
       Customers.remove(id);
       ObjectOutputStream FW= new ObjectOutputStream(new FileOutputStream(CustomersFile));
       FW.writeObject(Customers);FW.close(); 
      
  }
  
  
  
  private void  AddID(String userName,long IDACC) throws IOException, ClassNotFoundException
 {
    Integer Id =(int)(long) IDACC;
  File check = new  File( "FindindIDFile" );
  HashMap<String,Integer> ids= new HashMap<>();
  if(check.length()==0)
  {
     
      ObjectOutputStream fr= new ObjectOutputStream(new FileOutputStream(check));
      ids.put(userName,Id);
      fr.writeObject(ids);
      fr.close();
  }
  else 
  {
      ObjectInputStream fr= new ObjectInputStream(new FileInputStream(check));
      ids= (HashMap<String, Integer>) fr.readObject();fr.close();
      ids.put(userName,Id);
      ObjectOutputStream fw= new ObjectOutputStream(new FileOutputStream(check));
      ids.put(userName ,Id);
      fw.writeObject(ids);
      fw.close();
      
  }
 }
 private void deleteId(long  IDACC) throws FileNotFoundException, IOException, ClassNotFoundException
 {
     int id= (int)(long) IDACC;
     File check = new  File( "FindindIDFile" );
     HashMap<String,Integer> ids= new HashMap<>();
     ObjectInputStream fr= new ObjectInputStream(new FileInputStream(check));
     ids=  (HashMap<String, Integer>) fr.readObject();fr.close();
     ids.remove(id);
     ObjectOutputStream fw= new ObjectOutputStream(new FileOutputStream(check));
     ids.remove(id);
      fw.writeObject(ids);
      fw.close();
 }
  
  
}
