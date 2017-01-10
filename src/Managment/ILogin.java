package Managment;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ILogin {

	public int login( String userName, char [] passwd ) throws FileNotFoundException, IOException; 
// userName is in the most-grand-parent class Person, All must have userName
	
		
}
