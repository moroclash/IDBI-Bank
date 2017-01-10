/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylaptop;

import java.io.IOException;

/**
 *
 * @author sediek
 */
public class MyLaptop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MyClient emp=new MyClient();
        /*
    runIt
    send and recieve
    processConnection
    closeConnection
    
    
    
    
    */
        emp.runIt();
        Person lolo=new Person();
        lolo.setFname("ahmme");
        lolo.setID("44");
        emp.send(lolo);
        Person don=(Person) emp.recieve();
    }
    
}
