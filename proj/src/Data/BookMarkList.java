/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bus.BookMark;

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
public class BookMarkList {

    public static ArrayList<BookMark> bList = new ArrayList<BookMark>();
    public static String bfile = "db/bookmarkTable.bin";

    public static Boolean addBookMark(BookMark b) throws ClassNotFoundException {
        load();
        Boolean exists = false;
        for (BookMark t : bList) {
            if (t.getBookMarkId().equals(b.getBookMarkId())) {
                exists = true;
            }
        }
        if (!exists) {
            bList.add(b);
            save();
            return true;
        }
        return false;
    }

    public static BookMark getBookMark(String bookMarkId) throws ClassNotFoundException {
        load();
        BookMark e = null;
        for (BookMark t : bList) {
            if (t.getBookMarkId().equals(bookMarkId)) {
                e = t;
            }
        }
        return e;
    }

    public static Boolean deleteAllUserBookMark(String userId) throws ClassNotFoundException {
        load();
        ArrayList<BookMark> todelete = new ArrayList<>();
        for (BookMark B : bList) {
            if (((Bus.User) B.getBookTenant()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        if (!todelete.isEmpty()) {
            bList.remove(todelete);
            save();
            return true;
        } else {
            return false;
        }
    }

    public static Boolean deleteBookMark(String bookMarkId) throws ClassNotFoundException {
        BookMark e = getBookMark(bookMarkId);
        if (e == null) {
            return false;
        } else {
            bList.remove(e);
            save();
            return true;
        }
    }

    public static List<BookMark> getAllBookMark() throws ClassNotFoundException {
        load();
        return bList;

    }

    public static List<BookMark> getAllUserBookMark(String userId) throws ClassNotFoundException {
        load();
        ArrayList<BookMark> todelete = new ArrayList<>();
        for (BookMark B : bList) {
            if (((Bus.User) B.getBookTenant()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        return todelete;

    }

    public static void save() {
        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(bfile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object 
            out.writeObject(bList);

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void load() throws ClassNotFoundException {
        File tempFile = new File(bfile);
        if (tempFile.length() != 0) {
            try {
                FileInputStream fileIn = new FileInputStream(bfile);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                bList = (ArrayList<BookMark>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            }
        }
    }
}
