package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import view.SalesFrame;

public class FileRead {


public ArrayList<InvoiceHeader> readFile(){
 String filename = null;
        BufferedReader file = null;
        try {
            // TODO add your handling code here:
             file = new BufferedReader(new FileReader(filename));
                    } catch (FileNotFoundException ex) {
                    	java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            file.readLine();
        } catch (IOException ex) {
        	java.util.logging.Logger.getLogger(SalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    return null;
}


public static void main(String [] args){

}
}
