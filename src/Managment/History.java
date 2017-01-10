package Managment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/*******************************************/
//
// DESCRIPTION : THIS CLASS CONTAINS THE FUNCTIONS RESPONSIBLE FOR DEALING WITH HistoryObject
//
public class History {
	
	// Date contains the current time and date

//
// newObject of HistoryOject, it's ArrayList will contain the new hist
// It's the addHistory responsible for adding and Storing
//
public void addHistory( int ID , String  newHistoryLine )  throws IOException, ClassNotFoundException {

	// TO CHECK IF THE FILE IS EMPTY OR NOT
	File checkData = new File( "HistoryFile" );

	// dateNow has the current time
	java.util.Date dateNow = new java.util.Date();


////////////////////////////////////////////////////////////////////////////////
	if ( checkData.length() != 0) {
// CHECK		
System.out.println( "FileHistory is not empty." );

	// READING HISTORY DATA IN A TEMPHASHMAP
	HashMap< Integer, HistoryObject > historyHashMap = new HashMap<>();
	ObjectInputStream read = new ObjectInputStream( new  FileInputStream( "HistoryFile" ) );
	historyHashMap = (HashMap< Integer, HistoryObject >) read.readObject(); read.close();
	// DATA ARE READ
// CHECK
System.out.println("Data are read.");

	// GETTING THE HistoryObject OF THE ID
	HistoryObject historyObjectOfID = historyHashMap.get( ID );

	// Adding new History to the Histories
	historyObjectOfID.xHistory.add(  newHistoryLine + " " + "-> On " +dateNow  );

	// updating the HashMap
	historyHashMap.put(ID, historyObjectOfID);

	// WRITTING
	ObjectOutputStream write = new ObjectOutputStream( new FileOutputStream( "HistoryFile" ) );
	write.writeObject( historyHashMap ); write.close();

// CHECK
System.out.println( "New history is added" );
		
		

	} // END CASE OF FILE IS NOT EMPTY

////////////////////////////////////////////////////////////////////////////////
if ( checkData.length() == 0 ) {
// CHECK		
System.out.println( "FileHistory is empty" );
	
	// 
	HashMap< Integer, HistoryObject > historyHashMap = new HashMap<>();
	
	// Making new HistoryObject
	HistoryObject newHistoryObject = new HistoryObject();

	// adding the new history
	newHistoryObject.xHistory.add( newHistoryLine + " " + "-> On " +dateNow );
	
	historyHashMap.put(ID, newHistoryObject ); // ADDING NEW HISTORY-OBEJCT

	// WRITTING
	ObjectOutputStream write = new ObjectOutputStream( new  FileOutputStream( "HistoryFile" ) );
	write.writeObject( historyHashMap ); write.close();
// CHECK
System.out.println( "History data is saved" );
	} // END CASE OF FILE IS EMPTY

////////////////////////////////////////////////////////////////////////////////



	
} // END addHistory ()


public HistoryObject showHisoryOf( int ID ) throws IOException, ClassNotFoundException {
// CHECK
System.out.println( "showHisoryOf() is working..." ); 

	// READING  and FILLING the historyHashMap
	HashMap< Integer, HistoryObject > hitoryHashMap = new HashMap<>();
	ObjectInputStream read = new ObjectInputStream( new FileInputStream( "HistoryFile" ));
	hitoryHashMap = ( HashMap< Integer, HistoryObject > ) read.readObject(); // Filling HashMap
	// Hitory are read
// CHECK
System.out.println( "Histories are Loaded" );	

	// Getting the specific history
	HistoryObject HistoryOfID = hitoryHashMap.get( 1 );
	

return HistoryOfID;
} // END showHisoryOf ()







	
/*	 
	public void foo() {
	java.util.Date date = new java.util.Date();
	System.out.println( date ); 
	}
*/	
} // END CLASS
