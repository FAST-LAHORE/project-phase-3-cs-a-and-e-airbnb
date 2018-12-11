/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import Bus.Tenant;
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
public class TenantList {

    public static ArrayList<Tenant> tList = new ArrayList<Tenant>();
    public static String tfile = "db/tenantTable.bin";

    //Store and delete from the Database and Get from the data base
    public static Boolean addTenant(Tenant T) throws ClassNotFoundException {
        load();
        Boolean exists = false;
        for (Tenant t : tList) {
            if (t.getUserId().equals(T.getUserId()) || t.getEmail().equals(T.getEmail())) {
                exists = true;
            }
        }
        if (!exists) {
            tList.add(T);
            save();
            return true;
        }
        return false;
    }

    public static Tenant getTenant(String userId) throws ClassNotFoundException {
        load();
        Tenant e = null;
        for (Tenant t : tList) {
            if (t.getUserId().equals(userId)) {
                e = t;
            }
        }
        return e;
    }
     public static Tenant getEmailTenant(String userId) throws ClassNotFoundException {
        load();
        Tenant e = null;
        for (Tenant t : tList) {
            if (t.getEmail().equals(userId)) {
                e = t;
            }
        }
        return e;
    }

    public static Boolean deleteTenant(String userId) throws ClassNotFoundException {
        Tenant e = getTenant(userId);
        if (e == null) {
            return false;
        } else {
            tList.remove(e);
            save();
            return true;
        }
    }

    public static List<Tenant> getAllTenant() throws ClassNotFoundException {
        load();
        return tList;

    }

    public static Boolean updateTenant(Tenant t) throws ClassNotFoundException {
        Tenant e = getTenant(t.getUserId());
        if (e != null) {
            e = t;
            save();
            return true;

        }
        return false;
    }

    public static void save() {
        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(tfile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object 
            out.writeObject(tList);

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void load() throws ClassNotFoundException {
        File tempFile = new File(tfile);
        if (tempFile.length() != 0) {
            try {
                FileInputStream fileIn = new FileInputStream(tfile);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                tList = (ArrayList<Tenant>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            }
        }
    }
}
