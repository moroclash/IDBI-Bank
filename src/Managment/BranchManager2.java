package Managment;
import MainArchitecture.Loan;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import MainArchitecture.Teller;
import Managment.Manager;

public class BranchManager2 {
	
// RETURNS int -> THE >>genereated ID<< to be used in FindingIDFile
public int addEmployee ( Object newEmployee ) throws IOException, ClassNotFoundException
{
	
File tellerLastID = new File( "TellerLastIDs" );

int x = 1000;
if ( tellerLastID.length() == 0 ) {
ObjectOutputStream write1 = new ObjectOutputStream( new FileOutputStream( "TellerLastIDs" ) );
write1.writeInt(x); write1.close();}

File managerLastID = new File( "ManagerLastID" );
int y = 1;
if( managerLastID.length() == 0){
ObjectOutputStream write2 = new ObjectOutputStream( new FileOutputStream( "ManagerLastID" ) );
write2.writeInt(y); write2.close();	
}

	

/////////////////////////////////////////////////////////			
	File EmployeeFile = new File( "EmployeeFile" );/////	
/////////////////////////////////////////////////////////			

	// CHECKING IF THE newEmployee is Teller
	if ( newEmployee instanceof Teller ) {
 System.out.println( "The passed object is of Teller Class\nI'm working ^_^" );
 

	// if the File was Empty
	if ( EmployeeFile.length() == 0)
	{
	// second teller = 
	
	// Making a HashMap of < String ID, Object >
	HashMap < Integer , Object > tellerHashMap = new HashMap<>();
	// Putting the Teller in the HashMap
	((Teller) newEmployee).setID(1000); // ADDING ID TO THE NEW TELLER
	tellerHashMap.put( 1000, newEmployee); // no Employees, so this is the firts, ID = 1000
	//
	// saving the Last ID in a file
	ObjectOutputStream writeLastID= new ObjectOutputStream( new FileOutputStream( "TellerLastIDs" ));
	int LastID = 1000; writeLastID.writeInt(LastID); writeLastID.close();
	//// DATA is prepared to be stored in a FILE ////
	
	// TO WRITE IN A BINARY FILE
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream( "EmployeeFile" ) );
	// WRITTING 
	write.writeObject( tellerHashMap); write.close(); // SAVED
	
System.out.println("The file was Empty, new Data is Saved");

// CHECKING
ObjectInputStream read2 = new ObjectInputStream( new FileInputStream("EmployeeFile") );
HashMap < Integer , Teller > checkHashMap = new HashMap<>();
checkHashMap = ( HashMap<Integer, Teller >) read2.readObject();
System.out.println("ID = "+ checkHashMap.get(1000).getID());
	} // END CASE OF EMPTY FILE

	// IF THE FILE CONTAINS DATA
	else 
	{
	// MAKING AN EMPTY HASHMAP && READING THE OLD DATA IN THE FILE BEFORE ADDING THE NEW DATA
	HashMap< Integer , Object> tellerHashMap = new HashMap<>(); // EMPTY HASHMAP
	ObjectInputStream read = new ObjectInputStream( new FileInputStream("EmployeeFile") );	
	tellerHashMap =  (HashMap<Integer, Object>) read.readObject(); read.close();
	// DATA IS READ FORM THE FILE
	
	// GETTING THE LAST ID, TO ADD two AND GENERATE A NEW ID FOR THE NEW TELLER
	ObjectInputStream readLastID = new ObjectInputStream( new FileInputStream( "TellerLastIDs" ) );
	int newID = readLastID.readInt(); readLastID.close();
	newID += 2;
	
	// UPDATING THE TellerLastIDsFIle
	ObjectOutputStream writeLastID = new ObjectOutputStream( new FileOutputStream("TellerLastIDs" ));
	writeLastID.writeInt(newID);writeLastID.close();	
	
	// ADDING NEW EMPLOYEE IN THE HASHMAP  [[ I Swapped ]]
	((Teller) newEmployee).setID( newID);
	tellerHashMap.put( newID, newEmployee );
	
	
	
	// TO WRITE IN A BINARY FILE
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream( "EmployeeFile" ) );
	// WRITTING 
	write.writeObject( tellerHashMap); write.close(); // SAVED
	

// CHECKING
ObjectInputStream read2 = new ObjectInputStream( new FileInputStream("EmployeeFile") );
HashMap< Integer, Teller > checkHashMap = new HashMap<>();
checkHashMap = (HashMap< Integer, Teller>) read2.readObject(); read2.close();

		
	} // END CASE OF FILE CONTAINS DATA
 
} // END CASE OF Teller EMPLOYEE
	
	/////
	/////
	/////

	// CHECKING IF THE newEmployee is Manager
if ( newEmployee instanceof Manager ) {
System.out.println( "The passed object is of Manager Class\nI'm working ^_^" );	
//
// WE'VE NEEDED TO CREATE ManagerLastID FILE TO KEEP TRACK OF THE LAST MANAGER ID,
// THIS MAKE GENERATING ID EASIER
//
	


	// CASE OF EMPTY FILE
	if( EmployeeFile.length() == 0 ) {
System.out.println("File is Empty");
	// Making a HashMap of < String ID, Object >
	HashMap < Integer , Object > managerHashMap = new HashMap<>();
	//// DATA is prepared to be stored in a FILE ////

	// WRITTING THE ID IN ManagerLastID
	ObjectOutputStream writeLastID= new ObjectOutputStream( new FileOutputStream( "ManagerLastID" ));
	int LastID = 2; writeLastID.writeInt(LastID); writeLastID.close();
	
	((Manager) newEmployee).setID(2); // ADDING >>>>id<<<< TO THE NEW MANAGER before saving
					  
	// TO WRITE IN A BINARY FILE
	// Putting the Manager in the HashMap
	managerHashMap.put(LastID, newEmployee);
	// WRITTING  newManagerData in the EmployeeFile
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream( "EmployeeFile" ) );
	write.writeObject(managerHashMap ); write.close(); // SAVED
	
System.out.println("The file was Empty, new Data is Saved");

// CHECKING
//ObjectInputStream read2 = new ObjectInputStream( new FileInputStream("EmployeeFile") );
//HashMap < Integer , Manager > checkHashMap = new HashMap<>();
//checkHashMap = ( HashMap<Integer, Manager >) read2.readObject();
//System.out.println("Name1 = "+ checkHashMap.get(2).getID());

	} // END CASE OF EMPTY FILE




	// CASE OF FILE NOT EMPTY	
	if( EmployeeFile.length() != 0 ) {
System.out.println( "File is not Empty ^_^" );

	// MAKING AN EMPTY HASHMAP && READING THE OLD DATA IN THE FILE BEFORE ADDING THE NEW DATA
	HashMap< Integer , Object> managerHashMap = new HashMap<>(); // EMPTY HASHMAP
	ObjectInputStream read = new ObjectInputStream( new FileInputStream("EmployeeFile") );	
	managerHashMap =  (HashMap<Integer, Object>) read.readObject(); read.close();
	// DATA IS READ FORM THE FILE
	
	// GETTING THE LAST ID, TO ADD one AND GENERATE A NEW ID FOR THE NEW TELLER
	ObjectInputStream readLastID = new ObjectInputStream( new FileInputStream( "ManagerLastID" ) );
	int newID = readLastID.readInt(); readLastID.close(); // GETTING THE LAST ID

	newID += 1; // GENERATING THE NEXT ONE
	((Manager) newEmployee).setID(newID); // ADDING id TO THE NEW MANAGER
System.out.println( "newID Manager is " + newID );
	
	// UPDATING THE ManagerLastID 
	ObjectOutputStream writeLastID = new ObjectOutputStream( new FileOutputStream("ManagerLastID" ));
	writeLastID.writeInt(newID);writeLastID.close();
 

	// ADDING NEW EMPLOYEE IN THE HASHMAP
	managerHashMap.put(newID, newEmployee ); // adding id in line 158
	// TO WRITE IN A BINARY FILE
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream( "EmployeeFile" ) );
	// WRITTING 
	write.writeObject( managerHashMap); write.close(); // SAVED
	

// CHECKING
//ObjectInputStream read2 = new ObjectInputStream( new FileInputStream("EmployeeFile") );
//HashMap< Integer, Manager  > checkHashMap = new HashMap<>();
//checkHashMap = (HashMap< Integer, Manager>) read2.readObject(); read2.close();

//System.out.println( "\nName1 = "+checkHashMap.get(2).getID()+"\nName2 = "+checkHashMap.get(3).getID()  );
		
		
	} // END CASE OF FILE CONTAINS DATA
	
	
} /* END if ( if the newEmployee was Manager ) */


	
	// RETURNING THE ADDED EMPLOYEE ID, TO MAKE IT EASY TO addNewID( )
Employee employeeID = (Employee) newEmployee;	
return employeeID.getID();
} // END addEmployee ()



public void addNewID ( int newID, String userName ) throws IOException, ClassNotFoundException {
	
	File check = new  File( "FindindIDFile" );	

	if ( check.length() == 0 ) {
	HashMap< String, Integer > findingIDHashMap = new HashMap<>();
	findingIDHashMap.put(userName, newID); // PUTTING ID AND USERNAME IN A HASHMAP

	// STORING
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream("FindindIDFile"));
	write.writeObject(findingIDHashMap); write.close();

System.out.println( "Stored...");
	} // END CASE OF EMPTY FIE

	else {
	// READING THE OLD DATA
	HashMap< String, Integer > findingIDHashMap = new HashMap<>();
	ObjectInputStream read = new ObjectInputStream( new FileInputStream("FindindIDFile"));
	findingIDHashMap = ( HashMap< String, Integer > ) read.readObject(); read.close();


// CHECK, IDs are read successfully
System.out.println("FileID is not empty, ID = " + findingIDHashMap.get( userName ));

	// UPDATING HASHMAP
	findingIDHashMap.put(userName, newID);

	// STORING
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream("FindindIDFile"));
	write.writeObject(findingIDHashMap); write.close();
		
	} // END CASE OF NOT EMPTY FILE
	
	
} // END addNewID ()



public void updateEmployee( Object updatedEmployee ) throws IOException, ClassNotFoundException {

// THE WORK IS IN A SPECIFIC FILE, if will be used to make a proper casting
	if( updatedEmployee instanceof Teller ) {
// CHECKING
System.out.println( "update is working...\nthe Object sent is of Teller" );

	// GETTING Teller ID, TO GET RONDOM-ACCESS TO THE ORIGINAL Teller TO BE Updated
	// uEmployee IS STANDING FOR Updated-Employee. IT AFTER CASTING THE SENT OBJECT
	Teller uEmployee = ( Teller ) updatedEmployee; // CASTING

	// reading All Tellers
	HashMap< Integer, Teller > tellerHashMap = new HashMap<>();
	ObjectInputStream read = new ObjectInputStream( new FileInputStream( "EmployeeFile" ));
	tellerHashMap = (HashMap< Integer, Teller >) read.readObject(); read.close();

	// UPDATING HASHMAP
	tellerHashMap.put( uEmployee.getID(), uEmployee);

	// WRITTING CHANGES
	ObjectOutputStream write = new  ObjectOutputStream( new FileOutputStream( "EmployeeFile" ) );
	write.writeObject( tellerHashMap ); write.close();

// CHECKING
System.out.println( "Updated : " + uEmployee.getAddress() );
	} // END IF updateEmployee is Teller
	
	//
	//
	//
	//
// IF THE SENT OBJECT IS MANAGER	
	if( updatedEmployee instanceof Manager ) {
// CHECKING
System.out.println( "update is working...\nthe Object sent is of Manager" );

	// GETTING Manager ID, TO GET RONDOM-ACCESS TO THE ORIGINAL Manager TO BE Updated
	// uEmployee IS STANDING FOR Updated-Employee. IT AFTER CASTING THE SENT OBJECT
	Manager uEmployee = ( Manager ) updatedEmployee; // CASTING

	// reading All Tellers
	HashMap< Integer, Manager > ManagerHashMap = new HashMap<>();
	ObjectInputStream read = new ObjectInputStream( new FileInputStream( "EmployeeFile" ));
	ManagerHashMap = (HashMap< Integer, Manager >) read.readObject(); read.close();

	// UPDATING HASHMAP
	ManagerHashMap.put( uEmployee.getID(), uEmployee);

	// WRITTING CHANGES
	ObjectOutputStream write = new  ObjectOutputStream( new FileOutputStream( "EmployeeFile" ) );
	write.writeObject( ManagerHashMap ); write.close();
	} // END IF updatedEmployee is Manager


	
	
} // END updateEmployee ()



public void deleteEmployee( int IDToDelete ) throws IOException, ClassNotFoundException 
{
	// EMPTY HashMap
	HashMap< Integer, Object > employeeHashMap = new HashMap<>();

	// READING THE EmployeeFile
	ObjectInputStream read = new ObjectInputStream( new FileInputStream( "EmployeeFile" ) );	
	employeeHashMap = (HashMap< Integer, Object >) read.readObject(); read.close();
	// DATA IS READ
	
	// DELETING FROM HashMap
	employeeHashMap.remove( IDToDelete );

	// WRITTING IN A FILE
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream("EmployeeFile"));
	write.writeObject(employeeHashMap); write.close();

} // END deleteEmployee( )


public void deleteID ( int IDToDelete ) throws IOException, ClassNotFoundException {
	
// NEED TO BE HANDLED;
// THE ID IN FindingIDFile IS NOT DELETED;
// ID WILL NOT BE REPEATED EVEN IF HAPPEND, UERNAME IS UNIQUE	
}


// you should cast the returned object as you like
public  Object showEmployee( int ID ) throws FileNotFoundException, IOException, ClassNotFoundException
{
	// EMPTY HashMap
	HashMap< Integer, Object > employeeHashMap = new HashMap<>();

	// READING THE EmployeeFile
	ObjectInputStream read = new ObjectInputStream( new FileInputStream( "EmployeeFile" ) );	
	employeeHashMap = (HashMap< Integer, Object >) read.readObject(); read.close();
	// DATA IS READ

	Object shownEmployee = employeeHashMap.get( ID );
	
	if ( shownEmployee != null ){
		return shownEmployee;
	}
	
return null;
} // END showEmployee ( )




public HashMap< Integer, Object> showAllEmployees( ) throws FileNotFoundException, IOException, ClassNotFoundException
{
	// EMPTY HashMap
	HashMap< Integer, Object > employeeHashMap = new HashMap<>();

	// READING THE EmployeeFile
	ObjectInputStream read = new ObjectInputStream( new FileInputStream( "EmployeeFile" ) );	
	employeeHashMap = (HashMap< Integer, Object >) read.readObject(); read.close();
	// DATA IS READ
	
	if( employeeHashMap != null )
	return employeeHashMap;
	

return null;
	
} // END showAllEmployees( )


	///////// Loan /////////
public HashMap< Integer, Loan > showWaitingLoans( ) throws FileNotFoundException, IOException, ClassNotFoundException {
	
	// EMPTY HASHMAP
	HashMap< Integer, Loan > loanHashMap = new HashMap<>();

	// reading
	ObjectInputStream read = new ObjectInputStream( new FileInputStream( "WaitingLoanFile" ) );
	loanHashMap = (HashMap) read.readObject(); read.close();

	if( loanHashMap != null )
		return loanHashMap;
	
// no loans
System.out.println("there is not Loan");
return null;
} // END showLoans()


public void acceptLoan( Loan acceptedLoan ) throws FileNotFoundException, IOException, ClassNotFoundException{
	
// 1 - write in AcceptedLoansFile to be followed
// Money are in the acceptedLoanFile,
// The Balance of the Account is not touched

// 2 - deleting acceptedLoan form WaitingLoanFile File [ show() > update the return and write ]


	
 } // END acceptLoan ()





} // END BranchManager2 CLASS