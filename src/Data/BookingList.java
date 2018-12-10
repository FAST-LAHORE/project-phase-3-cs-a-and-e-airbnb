/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bus.BookMark;
import Bus.Booking;
import Bus.LandLord;
import Bus.Property;
import Bus.Tenant;
import static Data.BookMarkList.bList;
import static Data.BookMarkList.bfile;
import static Data.BookMarkList.getBookMark;
import static Data.BookMarkList.load;
import static Data.BookMarkList.save;
import static Data.PropertyList.getProperty;
import static Data.PropertyList.save;
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
public class BookingList  {
    public static ArrayList<Booking> bookingList = new ArrayList<Booking>();
    public static String bookingfile = "db/bookingTable.bin";
    public static Boolean addBooking(Booking b) throws ClassNotFoundException {
        load();
        Boolean exists = false;
        for (Booking t : bookingList) {
            if (t.getBookingId().equals(b.getBookingId())) {
                exists = true;
            }
        }
        if (!exists) {
            bookingList.add(b);
            save();
            return true;
        }
        return false;
    }
    
    public static String checkBooking(Booking b) throws ClassNotFoundException   {
        load();
        String e =null;
        for (Booking t : bookingList) {
            if (t.getBookingId().equals(b.getBookingId())) {
                e =  b.getStatus();
            }
        }
        return e;
    }
    public static Booking getBooking(String bId) throws ClassNotFoundException    {
        load();
        Booking e = null;
        for (Booking t : bookingList) {
            if (t.getBookingId().equals(bId)) {
                e = t;
            }
        }
        return e;
    }
    public static Boolean deleteBooking(String bId) throws ClassNotFoundException{
        Booking e = getBooking(bId);
        if (e == null) {
            return false;
        } else {
            bookingList.remove(e);
            save();
            return true;
        }
    }
    public static List<Booking>getPendingTenantBookings(String tId) throws ClassNotFoundException{
        load();
        ArrayList<Booking> todelete = new ArrayList<>();
        for (Booking B : bookingList) {
            if (( B.getbTenant().getUserId()).equals(tId) && B.getStatus().equals("pending")) {
                todelete.add(B);
            }
        }
        return todelete;
    }
    public static List<Booking>getStayedTenantBookings(String tId) throws ClassNotFoundException{
        load();
        ArrayList<Booking> todelete = new ArrayList<>();
        for (Booking B : bookingList) {
            if (( B.getbTenant().getUserId()).equals(tId) && B.getStatus().equals("stayed")) {
                todelete.add(B);
            }
        }
        return todelete;
    
    }
     public static List<Booking>getAllTenantBookings(String tId) throws ClassNotFoundException{
        load();
        ArrayList<Booking> todelete = new ArrayList<>();
        for (Booking B : bookingList) {
            if (( B.getbTenant().getUserId()).equals(tId) ) {
                todelete.add(B);
            }
        }
        return todelete;
    }
    public static List<Booking>getAllPropertyBookings(String pId) throws ClassNotFoundException{
        load();
        ArrayList<Booking> todelete = new ArrayList<>();
        for (Booking B : bookingList) {
            if (( B.getbProperty().getPropertyId()).equals(pId) ) {
                todelete.add(B);
            }
        }
        return todelete;
    }
      public static List<Booking>getPendingPropertyBookings(String pId) throws ClassNotFoundException{
        load();
        ArrayList<Booking> todelete = new ArrayList<>();
        for (Booking B : bookingList) {
            if (( B.getbProperty().getPropertyId()).equals(pId)&& B.getStatus().equals("pending") ) {
                todelete.add(B);
            }
        }
        return todelete;
    }
    public static Boolean updateBooking(Booking b) throws ClassNotFoundException{
         Booking e = getBooking(b.getBookingId());
        if(e != null)   {
            e = b;
            save();
            return true;
            
        }
        return false;
    }
       public static void save() {
        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(bookingfile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object 
            out.writeObject(bookingList);

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void load() throws ClassNotFoundException {
        File tempFile = new File(bookingfile);
        if (tempFile.length() != 0) {
            try {
                FileInputStream fileIn = new FileInputStream(bookingfile);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                bookingList = (ArrayList<Booking>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            }
        }
    }
}
