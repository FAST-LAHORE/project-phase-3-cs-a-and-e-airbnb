/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bus.Amenities;
import Bus.Facilties;
import Bus.Property;
import Bus.PropertyType;
import Bus.Restrictions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author hp
 */
public class PropertyList {

    public static ArrayList<Property> pList = new ArrayList<Property>();
    public static String pfile = "db/propertyTable.bin";

    public static Boolean addProperty(Property p) throws ClassNotFoundException {
        load();
        Boolean exists = false;
        for (Property t : pList) {
            if (t.getPropertyId().equals(p.getPropertyId())) {
                exists = true;
            }
        }
        if (!exists) {
            pList.add(p);
            save();
            return true;
        }
        return false;
    }

    public static Property getProperty(String pId) throws ClassNotFoundException {
        load();
        Property e = null;
        for (Property t : pList) {
            if (t.getPropertyId().equals(pId)) {
                e = t;
            }
        }
        return e;
    }

    public static Boolean deleteProperty(String pId) throws ClassNotFoundException {

        Property e = getProperty(pId);
        if (e == null) {
            return false;
        } else {
            pList.remove(e);
            save();
            return true;
        }

    }

    public static List<Property> getAllProperty() throws ClassNotFoundException {
        load();
        return pList;

    }

    public static Boolean updateProperty(Property p) throws ClassNotFoundException {
        Property e = getProperty(p.getPropertyId());
        if (e != null) {
            e = p;
            save();
            return true;

        }
        return false;
    }

    public static ArrayList<Property> searchResult(String address, String pt, List<String> reList, List<String> fcList, List<String> amenList, LocalDate start, LocalDate end) throws ClassNotFoundException {
        load();
        ArrayList<Property> all = (ArrayList<Property>) getAllProperty();
        ArrayList<Property> filtered = new ArrayList<>();

        for (Property p : all) {
            if (address != null&&p.getPropertyAdd()!=null && !((p.getPropertyAdd().contains(address)))) {
                filtered.add(p);
            } else if (pt!=null&&p.getpType()!=null&&!(p.getpType().toString().equals(pt))) {
                 filtered.add(p);
            } else if (fcList!= null &&p.getpFacilities()!=null&&!fcList.containsAll(p.getpFacilities())) {
                 filtered.add(p);
            } else if (reList!= null&&p.getpRestrictions()!=null&&!reList.containsAll(p.getpRestrictions())) {
                 filtered.add(p);
            } else if (amenList!=null&&p.getpAmenities()!=null&&!amenList.containsAll(p.getpAmenities())) {
                 filtered.add(p);
            } else if (!validDate(p, start, end)) {
                filtered.add(p);
            }
        }
        all.removeAll(filtered);
        return all;

    }

    public static boolean validDate(Property p, LocalDate start, LocalDate end) {
        if(start !=null && end != null) {
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            if (!p.isAvailable(date)) {
                return false;
            }
        }

        return true;
        }
        else {
            return true;
        }
    }

    public static void save() {
        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(pfile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object 
            out.writeObject(pList);

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void load() throws ClassNotFoundException {
        File tempFile = new File(pfile);
        if (tempFile.length() != 0) {
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
