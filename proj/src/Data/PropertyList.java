/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bus.Property;
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
public class PropertyList {
    public static ArrayList<Property> pList = new ArrayList<Property>();
    public static String pfile = "db/propertyTable.bin";
    
    public static Boolean addProperty(Property p) throws ClassNotFoundException   {
       load();
       Boolean exists = false;
       for(Property t : pList)  {
           if(t.getPropertyId().equals(p.getPropertyId()))  {
               exists = true;
           }
       }
       if(!exists)  {
           pList.add(p);
           save();
           return true;
       }
       return false;
    }
     public static Property getProperty (String pId) throws ClassNotFoundException   {
        load();
        Property e = null;
        for(Property t : pList)  {
            if(t.getPropertyId().equals(pId))  {
                e = t;
            }
        }
        return e;
    }
     public static Boolean deleteProperty(String pId) throws ClassNotFoundException   {
         
         Property e = getProperty(pId);
         if(e == null){
             return false;
         }
         else {
             pList.remove(e);
             save();
             return true;
         }
         
    } 
    public static List<Property> getAllProperty() throws ClassNotFoundException  {
        load();
        return pList;

    }
    public static Boolean updateProperty(Property p) throws ClassNotFoundException   {
        Property e = getProperty(p.getPropertyId());
        if(e != null)   {
            e = p;
            save();
            return true;
            
        }
        return false;
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
