package Managment;

import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
/********************************/

//
// DESCRIPTION : IT'S A CONTAINER IN WHICH WE STORE ALL HISTORY FOR ONE ID MOVES
//
public class HistoryObject implements Serializable {

	// EACH ELEMENT IN THIS STRING ARRAYLIST REFER TO AN OPERATION HISTORY
	// 
	ArrayList< String > xHistory = new ArrayList<>();

           public ArrayList< String > getHistory() {
               return this.xHistory;
           }
		

} // END CLASS