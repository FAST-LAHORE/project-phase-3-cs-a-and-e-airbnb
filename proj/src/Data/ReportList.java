/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bus.Report;
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
public class ReportList {

    public static ArrayList<Report> rList = new ArrayList<Report>();
    public static String rpfile = "db/reportTable.bin";

    public static Boolean addReport(Report b) throws ClassNotFoundException {
        load();
        Boolean exists = false;
        for (Report t : rList) {
            if (t.getReportId().equals(b.getReportId())) {
                exists = true;
            }
        }
        if (!exists) {
            rList.add(b);
            save();
            return true;
        }
        return false;
    }

    public static Report getReport(String reportId) throws ClassNotFoundException {
        load();
        Report e = null;
        for (Report t : rList) {
            if (t.getReportId().equals(reportId)) {
                e = t;
            }
        }
        return e;
    }

    public static Boolean deleteAllUserReport(String userId) throws ClassNotFoundException {
        load();
        ArrayList<Report> todelete = new ArrayList<>();
        for (Report B : rList) {
            if (((Bus.User) B.getFiler()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        if (!todelete.isEmpty()) {
            rList.remove(todelete);
            save();
            return true;
        } else {
            return false;
        }
    }

    public static Boolean deleteReport(String reportId) throws ClassNotFoundException {
        Report e = getReport(reportId);
        if (e == null) {
            return false;
        } else {
            rList.remove(e);
            save();
            return true;
        }
    }

    public static List<Report> getAllReport() throws ClassNotFoundException {
        load();
        return rList;

    }

    public static List<Report> getAllUserReport(String userId) throws ClassNotFoundException {
        load();
        ArrayList<Report> todelete = new ArrayList<>();
        for (Report B : rList) {
            if ((B.getFiler()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        return todelete;

    }

    public static List<Report> getAllStayReport(String stayId) throws ClassNotFoundException {
        load();
        ArrayList<Report> todelete = new ArrayList<>();
        for (Report B : rList) {
            if ((B.getStayR()).getStatusId().equals(stayId)) {
                todelete.add(B);
            }
        }
        return todelete;

    }

    public static void save() {
        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(rpfile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object 
            out.writeObject(rList);

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void load() throws ClassNotFoundException {
        File tempFile = new File(rpfile);
        if (tempFile.length() != 0) {
            try {
                FileInputStream fileIn = new FileInputStream(rpfile);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                rList = (ArrayList<Report>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            }
        }
    }
}
