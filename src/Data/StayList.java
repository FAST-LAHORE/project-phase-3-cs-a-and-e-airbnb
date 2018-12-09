/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bus.Property;
import Bus.Stay;
import static Data.PropertyList.pList;
import static Data.PropertyList.pfile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class StayList {
    public static Boolean addStay(Stay t)   {
        throw new UnsupportedOperationException();
    }
     public static Stay getStay(String sId)   {
         throw new UnsupportedOperationException();
    }
     public static Boolean deleteStay(String sId)   {
         throw new UnsupportedOperationException();
    } 
     public static List<Stay> getAllStay()  {
         throw new UnsupportedOperationException();
     
     }
     public static Boolean updateStay(Stay t)   {
        throw new UnsupportedOperationException();
    }
         public static void save()  {
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(pfile); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(pList); 
              
            out.close(); 
            file.close(); 
              
            
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
    }
    public static void load() throws ClassNotFoundException  {
        File tempFile = new File(pfile);
        if(tempFile.length() != 0){
                try {
                 FileInputStream fileIn = new FileInputStream(pfile);
                 ObjectInputStream in = new ObjectInputStream(fileIn);

                 pList = (ArrayList<Property>) in.readObject();
                 in.close();
                 fileIn.close();
                } catch (IOException i) {
                   i.printStackTrace();
                   return;
                }
            }
        }
}
