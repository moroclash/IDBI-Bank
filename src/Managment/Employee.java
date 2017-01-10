package Managment;
import MainArchitecture.MyExption;
import MainArchitecture.person;
import java.io.Serializable;

public class Employee extends person implements Serializable {

    
        private char[] Password;
        public char[] getPassword() {
            return Password;
        }

        public void setPassword(char[] Password) {
            
            this.Password = Password;
        }
        
    
    
        private String Username;
        public String getUsername() {
            return Username;
        }

        public void setUsername(String Username) {
            this.Username = Username;
        }
        
        // salary
        private String salary;
	public void setSalary( String salary ){
             double x = 0;
                try
                {
                   x = Double.parseDouble(salary);
                }
                catch(Exception ex)
                {
                    x= MyExption.intex();
                }
                if(x<0)
                {
                    x = MyExption.isPositeve(x);
                }
		this.salary = Double.toString(x);
	}
	public String getSalary(){
		return this.salary;
	}
	// String jobLevel
	private String jobLevel;
	public void setJobLevel( String jobLevel ) {
		this.jobLevel = jobLevel;
	}
	public String getJobLevel( ){
		return this.jobLevel;
	}
	private String myBranch;
	public void setBranch( String myBranch ){
		this.myBranch = myBranch;
	}
	public String getBranch( ){
		return this.myBranch;
	}

	// department
	private String tellerDept;
	public void setTellerDept( String tellerDept ){
		this.tellerDept = tellerDept;
	}
	public String getTellerDept( ){
		return this.tellerDept;
	}
	


	
	
}
