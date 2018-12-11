/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import Bus.LandLord;

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
public class LandLordList {
    public static ArrayList<LandLord> lList = new ArrayList<LandLord>();
    public static String lfile = "db/landlordTable.bin";
    public static Boolean addLandLord(LandLord l) throws ClassNotFoundException   {
       load();
       Boolean exists = false;
       for(LandLord t : lList)  {
           if(t.getUserId().equals(l.getUserId()) || t.getEmail().equals(l.getEmail()))  {
               exists = true;
           }
       }
       if(!exists)  {
           lList.add(l);
           save();
           return true;
       }
       return false;
    }
     public static LandLord getLandLord(String userId) throws ClassNotFoundException   {
        load();
        LandLord e = null;
        for(LandLord t : lList)  {
            if(t.getUserId().equals(userId))  {
                e = t;
            }
        }
        return e;
    }
       public static LandLord getEmailLandLord(String userId) throws ClassNotFoundException   {
        load();
        LandLord e = null;
        for(LandLord t : lList)  {
            if(t.getEmail().equals(userId))  {
                e = t;
            }
        }
        return e;
    }
     public static Boolean deleteLandLord(String userId) throws ClassNotFoundException   {
        LandLord e = getLandLord(userId);
         if(e == null){
             return false;
         }
         else {
             lList.remove(e);
             save();
             return true;
         }
    } 
     public static List<LandLord> getAllLandLord() throws ClassNotFoundException  {
         load();
         return lList;
     
     }
     public static Boolean updateLandLord(LandLord l) throws ClassNotFoundException   {
        LandLord e = getLandLord(l.getUserId());
        if(e != null)   {
            e = l;
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
            FileOutputStream file = new FileOutputStream(lfile); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(lList); 
              
            out.close(); 
            file.close(); 
              
            
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
    }
    public static void load() throws ClassNotFoundException  {
        File tempFile = new File(lfile);
        if(tempFile.length() != 0){
                try {
                 FileInputStream fileIn = new FileInputStream(lfile);
                 ObjectInputStream in = new ObjectInputStream(fileIn);

                 lList = (ArrayList<LandLord>) in.readObject();
                 in.close();
                 fileIn.close();
                } catch (IOException i) {
                   i.printStackTrace();
                   return;
                }
            }
        }
}
