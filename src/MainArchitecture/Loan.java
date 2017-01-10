
package MainArchitecture;
import Managment.Manager;
public class Loan {
    private Account  MyAcc ;
    private double Money ;
    private  Manager Mymanager  ;
    private String StartDate ;
    private String EndData;
    private String permittivityTime ;
    private float profit ;
    private double permittivityMony;
    private int LoanID;
    private Customer Guarantor;
    public void setMyManager(Manager x)
    {
        this.Mymanager=x;
    }
    public Manager getMyManager()
    {
        return this.Mymanager;
    }
    public void setLocation ( Account x)
    {
       this.MyAcc=x; 
    }
    public Account getLocation  ()
    {
        return this.MyAcc;
    }
    public void setMoney(double x)
    {
        
        this.Money=x;
    }
    public double  getMony()
    {
        return this.Money;
    }
    public void setStartDate(String x)
    {
        this.StartDate=x;
        
    }
    public String getStartDate()
    {
        return this.StartDate;
    }
    public void setEndDate(String  x)
    {
      this.EndData=x;  
    }
    public String getEndDate()
    {
        return this.EndData;
    }
    public void setPermittivityTime(String x)
    {
        this.permittivityTime =x;
    }
    public String getPermittivityTime()
    {
        return this.permittivityTime;
    }
    public void setProfit(float  x)
    {
        this.profit=x;
    }
    public float getProfit()
    {
      return this.profit;  
    }
    public void setPermittivityMony(double  x)
    {
        this.permittivityMony=x;
    }
    public double  getPermittivityMony()
    {
        return this.permittivityMony;
    }
    public void setLoanID(int x)
    {
        this.LoanID=x;
    }
    public int getLoanID()
    {
        return this.LoanID;
    }
    public void setGuarantor(Customer x)
    {
        this.Guarantor=x;
    }
    public Customer getGuarantor()
    {
        return this.Guarantor;
    }
    
}
 