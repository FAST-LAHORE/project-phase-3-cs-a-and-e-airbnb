/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;
import Gui.welcome;

import java.io.Serializable;

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
    public static Tenant currentTenant;
    public static Admin currentAdmin;
    public static LandLord currentLandlord;
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
//         TODO code application logic here
//        loadStorage();
//        init();
       
          Tenant my = new Tenant("Nashit", IdGen.getInstance().genUserId(), "123","img/icon.png", "123", "n@gmail.com", "123");
          Data.TenantList.addTenant(my);
          currentTenant = my;
          dummyProperty();
          new Gui.TenantDashBoard().setVisible(true);
        

    }

    public static void dummyProperty() throws ClassNotFoundException {
        Property a1 = new Property();
        a1.setPropertyId(IdGen.getInstance().genPropertyId());
       
        a1.setPropertyName("nashit");
        a1.setpImage("img/cross.png");

        a1.getpFacilities().add("Gym");
        a1.getpAmenities().add("Family");
        a1.getpAmenities().add("Kitchen");
        a1.getpRestrictions().add("Curfew");
        a1.getpRestrictions().add(Bus.Restrictions.No_Party.toString());
        a1.setPropertyAdd("lhr");
        a1.setpType(PropertyType.Room);
        a1.addDate("2018-12-10");
        a1.addDate("2018-11-10");
        Data.PropertyList.addProperty(a1);
        
         a1.setPropertyName("nashit");
        a1.setpImage("img/cross.png");
        
        a1.setPropertyId(IdGen.getInstance().genPropertyId());
       
        a1.getpFacilities().add("Gym");
        a1.getpAmenities().add("Family");
        a1.getpAmenities().add("Kitchen");
        a1.getpRestrictions().add("Curfew");
        a1.getpRestrictions().add(Bus.Restrictions.No_Party.toString());
        a1.setPropertyAdd("lhr");
        a1.setpType(PropertyType.Room);
        a1.addDate("2018-12-10");
        a1.addDate("2018-11-10");
        Data.PropertyList.addProperty(a1);
        a1 = new Property();
        a1.setPropertyId(IdGen.getInstance().genPropertyId());
        
        a1.setPropertyName("nashit");
        a1.setpImage("img/blankIcon.png");
        a1.getpFacilities().add(Bus.Facilties.Independent.toString());
        a1.getpAmenities().add(Bus.Amenities.HotWater.toString());
        a1.getpRestrictions().add("Curfew");
        a1.setPropertyAdd("fsd");
        a1.setpType(PropertyType.Room);
        a1.addDate("2018-12-11");
        Data.PropertyList.addProperty(a1);
        
    }

    public static Tenant getCurrentTenant() {
        return currentTenant;
    }

    public static void setCurrentTenant(Tenant currentTenant) {
        system.currentTenant = currentTenant;
    }

    public static Admin getCurrentAdmin() {
        return currentAdmin;
    }

    public static void setCurrentAdmin(Admin currentAdmin) {
        system.currentAdmin = currentAdmin;
    }

    public static LandLord getCurrentLandlord() {
        return currentLandlord;
    }

    public static void setCurrentLandlord(LandLord currentLandlord) {
        system.currentLandlord = currentLandlord;
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

    public static void saveStorage() {
        Data.PropertyList.save();
        Data.IdGenStorage.save();
    }

    public static void init() throws InterruptedException {
        welcome myWelcome = new welcome();
        myWelcome.pack();
        myWelcome.setVisible(true);
        Thread.sleep(3500);
        myWelcome.dispose();

    }

}
