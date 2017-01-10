/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylaptop;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author sediek
 */
 
public class MyClient  implements Serializable   {
    Socket client;
    ObjectInputStream read;
    ObjectOutputStream  write;
    
    public MyClient () throws IOException {
        
        /*ObjectInputStream read=new ObjectInputStream(client.inputStream());
        ObjectOutputStream write=new ObjectOutputStream(client.outStream);*/
        System.out.println("waitting for connection");
        client=new Socket("127.0.0.1",2002);
         
        
        /* try {
              write = new ObjectOutputStream( client.getOutputStream() );
       write.flush();
       read = new ObjectInputStream( client.getInputStream() );

         } catch (IOException ex) {
                System.out.println("problems in write and read");
         }*/
        
        
    }
     public void runIt() throws IOException
    {
       try
       {
        
        
        
        getStreams();
        
         //processingConnection();
         
        
        
   
    }
    
    catch ( IOException ioException )
     {
       ioException.printStackTrace();
     }
    /*finally
    {
      closeConnection();             
    }*/
    }
    
    
    
    private void getStreams() throws IOException {
          write = new ObjectOutputStream( client.getOutputStream() );
          write.flush(); // flush output buffer to send header information
          read = new ObjectInputStream( client.getInputStream() );
    }
    
   
    public void processingConnection()
    {
      // i will write  what i want to process it in function  
        
    }
   

    
    
   public void send( Object x) {
        try {
            write.writeObject(x);
           // write.flush();
        } catch (IOException ex) {
            System.out.println("function send");
        }
    }

    public Object recieve() {   // recieve
        try {
            Object thing= read.readObject();
            // int thing=read.nextInt();
            return thing;
        } catch (IOException|ClassNotFoundException ex) {
          System.out.println("function recieve");
          return null;
        } 
        
    }
    
    
    
    
    
    
    public void closeConnection()
    {
        
        try {
            write.close();
        } catch (IOException ex) {
             System.out.println("cann't close writer");
        }
        try {
            read.close();
        } catch (IOException ex) {
           System.out.println("cann't close reader");
        }
        try {
            client.close();
           // return true;
            
        } catch (IOException ex) {
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            //return false;
            
        }
       
    }
       

    
}
    
    

