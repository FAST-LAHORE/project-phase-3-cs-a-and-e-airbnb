/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bus.Review;
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
public class ReviewList {

    public static ArrayList<Review> reList = new ArrayList<Review>();
    public static String refile = "db/reviewTable.bin";

    public static Boolean addReview(Review b) throws ClassNotFoundException {
        load();
        Boolean exists = false;
        for (Review t : reList) {
            if (t.getReviewId().equals(b.getReviewId())) {
                exists = true;
            }
        }
        if (!exists) {
            reList.add(b);
            save();
            return true;
        }
        return false;
    }

    public static Review getReview(String reviewId) throws ClassNotFoundException {
        load();
        Review e = null;
        for (Review t : reList) {
            if (t.getReviewId().equals(reviewId)) {
                e = t;
            }
        }
        return e;
    }

    public static Boolean deleteAllReviewerReview(String userId) throws ClassNotFoundException {
        load();
        ArrayList<Review> todelete = new ArrayList<>();
        for (Review B : reList) {
            if (((Bus.User) B.getReviewer()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        if (!todelete.isEmpty()) {
            reList.remove(todelete);
            save();
            return true;
        } else {
            return false;
        }
    }

    public static Boolean deleteAllRevieweeReview(String userId) throws ClassNotFoundException {
        load();
        ArrayList<Review> todelete = new ArrayList<>();
        for (Review B : reList) {
            if (((Bus.User) B.getReviewee()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        if (!todelete.isEmpty()) {
            reList.remove(todelete);
            save();
            return true;
        } else {
            return false;
        }
    }

    public static Boolean deleteReview(String reviewId) throws ClassNotFoundException {
        Review e = getReview(reviewId);
        if (e == null) {
            return false;
        } else {
            reList.remove(e);
            save();
            return true;
        }
    }

    public static List<Review> getAllReview() throws ClassNotFoundException {
        load();
        return reList;

    }

    public static List<Review> getAllReviewerReview(String userId) throws ClassNotFoundException {
        load();
        ArrayList<Review> todelete = new ArrayList<>();
        for (Review B : reList) {
            if ((B.getReviewer()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        return todelete;

    }

    public static List<Review> getAllRevieeReview(String userId) throws ClassNotFoundException {
        load();
        ArrayList<Review> todelete = new ArrayList<>();
        for (Review B : reList) {
            if ((B.getReviewee()).getUserId().equals(userId)) {
                todelete.add(B);
            }
        }
        return todelete;

    }

    public static List<Review> getAllStayReview(String stayId) throws ClassNotFoundException {
        load();
        ArrayList<Review> todelete = new ArrayList<>();
        for (Review B : reList) {
            if ((B.getStayReview()).getStatusId().equals(stayId)) {
                todelete.add(B);
            }
        }
        return todelete;

    }

    public static void save() {
        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(refile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object 
            out.writeObject(reList);

            out.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void load() throws ClassNotFoundException {
        File tempFile = new File(refile);
        if (tempFile.length() != 0) {
            try {
                FileInputStream fileIn = new FileInputStream(refile);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                reList = (ArrayList<Review>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            }
        }
    }
}
