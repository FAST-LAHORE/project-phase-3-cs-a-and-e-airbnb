/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.TenantList.tList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author hp
 */
public class IdGenStorage {

    private static String idfile = "db/idGenTable.bin";

    public static void save() {
        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(idfile);
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
        File tempFile = new File(idfile);
        if (tempFile.length() != 0) {
            try {
                FileInputStream fileIn = new FileInputStream(idfile);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                Bus.IdGen.setMyIdGen((Bus.IdGen) in.readObject());
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            }
        }
    }
}
