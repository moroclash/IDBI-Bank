package Managment;

import MainArchitecture.Account;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
// it's supposed to varify the login
// Manager.ID  < 1000 
// Teller .ID  >= 1000 && even
// Cusomer.ID  >= 1000 && odd
public class Login /*implements ILogin*/ {
	
public Object login( String userName, char [] passwd ) throws FileNotFoundException, IOException, ClassNotFoundException {
	
	File file = new File( "FindindIDFile" );
	
	// FindingIDFIle cannot be empty, How can not-existing Enter?! 
	if( file.length() == 0 ) 
	{
		System.out.println( "File is Empty, return null :/ @#$%^&" );
		return null;
	} // file is empty , out of the function.......

	
	// FILE IS NOT EMPTY
	else {
		// READING FindingIDFile	
		HashMap< String, Integer > findingIDHashMap  = new HashMap<>();
		ObjectInputStream read = new ObjectInputStream( new FileInputStream("FindindIDFile"));
		findingIDHashMap = (HashMap< String, Integer >) read.readObject(); read.close();


		// GETTING ID
		Object  readID = findingIDHashMap.get(userName);
		if ( readID == null ) {
			System.out.println("userName is not exiting...");
			return null;
		}
		
		// ID is getten
		int ID = (Integer) readID; // SO userName is right
		
// CHECK
System.out.println(  findingIDHashMap  );		
// CHECKING 
System.out.println("Login is working... ^_^, ID =  " + ID );




////////////////////////////////////////////////////////////////
///////////////   Validating passwd   //////////////////////////
////////////////////////////////////////////////////////////////
			// 
	// CASE OF Teller LOGIN
	if ( ID >= 1000 && ID %2 == 0 /*true*/ ){
System.out.println( "Teller access" );
		/// "EmployeeFile" ///
	HashMap< Integer, Object > employeeHashMap = new HashMap<>();
	ObjectInputStream readEmployee = new ObjectInputStream( new FileInputStream("EmployeeFile" ) );
	employeeHashMap = ( HashMap< Integer, Object > ) readEmployee.readObject(); // Employee are Loaded

// CHECKING	
System.out.println( employeeHashMap );
	
BranchManager2 manager = new BranchManager2();
	Employee xEmployee = (Employee) manager.showEmployee(ID);
	if ( xEmployee == null )
			System.out.println( "xEmployee of Teller is null :/ " );
	else 
			System.out.println( "It's working " + xEmployee.getFname() );
	// valedating password
      
	if (Arrays.equals(xEmployee.getPassword(), passwd )   ) {
System.out.println( "Password is correct");
		return employeeHashMap.get( 1000 );	
	} // ACCESS

	else {
	System.out.println( "It's null, Not found" );
	return null;
	}
} // END Teller Validating...


	// CASE OF Manager LOGIN
	if ( ID  < 1000  /*true*/ ){
System.out.println( "Manager access" );
		/// "EmployeeFile" ///
/*	HashMap< Integer, Object > employeeHashMap = new HashMap<>();
	ObjectInputStream readEmployee = new ObjectInputStream( new FileInputStream("EmployeeFile" ) );
	employeeHashMap = ( HashMap< Integer, Object > ) readEmployee.readObject(); // Employee are Loaded
	readEmployee.close(); */

// CHECKING	
//System.out.println( employeeHashMap );
	

	BranchManager2 manager = new BranchManager2();
	// TO GET THE OBJECT xEmployee we use showEmployee
	Employee xEmployee = (Employee) manager.showEmployee(ID);
	if ( xEmployee == null ){
		System.out.println( "the read employee is null :/" );
	}
	else
System.out.println(  "الكائن شغال و ديه تجربة,The read xEmployee "  + xEmployee.getAddress() );
	// valedating password
	if ( Arrays.equals(xEmployee.getPassword(), passwd ) /*true*/  ) {
System.out.println( "Password is correct");
		return xEmployee;	
	} // ACCESS
} // END Manager Validating...
	
        
////////////////////////////////////////////////////////////////
///////////////   Validating passwd   //////////////////////////
////////////////////////////////////////////////////////////////
			// 
	// CASE OF CUSTOMERS( ACCOUNTS )
	if ( ID >= 1001 && ID %2 == 1) {
       File AccountsFile= new File ("AccountsFile");
       HashMap<String,Object> hAccounts= new HashMap<>();
       ObjectInputStream FRacc = new ObjectInputStream(new FileInputStream(AccountsFile));
       hAccounts= (HashMap<String, Object>) FRacc.readObject(); FRacc.close();
       Account xAccount =  (Account) hAccounts.get(userName);
       if(xAccount==null ) return null; 
       if(Arrays.equals(xAccount.getPassward(),passwd))
       {
        Object x= xAccount;
        return x;
       }
             
	} // END Accounts Validating...
		
} // END CASE OF FILE IS NOT EMPTY
		return null; // not exits
	} // end login

} // end Class
