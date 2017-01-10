
package GUI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client1   {
    private Socket s;
    private int port = 2002;
    protected ObjectOutputStream send;
    protected ObjectInputStream r;
    private Object man;
    public Client1(Object x) 
    {
        try {
            System.out.println("0");
             s = new Socket("192.168.111.1",port);
            System.out.println("1"); 
            send = new ObjectOutputStream(s.getOutputStream());
            System.out.println("2");
            r = new ObjectInputStream(s.getInputStream());
            System.out.println("3");
            send.writeObject(x);
            System.out.println("4");
            this.man = r.readObject();
            System.out.println("5");
            send.close();
            r.close();
        } catch (IOException|ClassNotFoundException ex) {
            System.out.println("Error In Connection");
        }
    
    }

    public Object getMan() {
        return man;
    }
    
    

    
}
