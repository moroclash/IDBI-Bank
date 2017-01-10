/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainArchitecture;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Abdulrahman
 */
public interface ITransaction {
    
    public int withdraw(double  money);
    public int transfer (long AccountNumber,double  money )throws IOException,FileNotFoundException,ClassNotFoundException;
    
}
