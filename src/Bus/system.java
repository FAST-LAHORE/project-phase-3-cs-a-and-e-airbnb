/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import static Data.PropertyList.pList;
import static Data.PropertyList.pfile;
import Gui.welcome;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class system implements Serializable {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        // TODO code application logic here
        loadStorage();
        init();
        

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        saveStorage();
    }
 
    public static void loadStorage() {
        try {
            
            Data.IdGenStorage.load();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(system.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void saveStorage()  {
        Data.PropertyList.save();
        Data.IdGenStorage.save();
    }
    public static void init() throws InterruptedException   {
        welcome myWelcome = new welcome();
        myWelcome.pack();
        myWelcome.setVisible(true);
        Thread.sleep(3500);
        myWelcome.dispose();
        
    }
 
}
