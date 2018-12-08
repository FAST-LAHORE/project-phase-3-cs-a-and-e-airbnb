/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author hp
 */
public class Tenant extends User implements Serializable {
    String currency;
    String education;
    String work;
    String address;
    
    List<Stay> pastStays;
    List<BookMark> myBookMarks;
    
    // Out of 10
    Float Rating;
    
    
    
    Boolean requestBooking(Property p){
        throw new UnsupportedOperationException();
    }
    Boolean cancelBooking(Booking b){
        throw new UnsupportedOperationException();
    }
    Boolean makeBookMark(Property p){
        throw new UnsupportedOperationException();
    }
    Boolean fileComplaint(Stay s){
        throw new UnsupportedOperationException();
    }
    Boolean makeReview(Stay s){
        throw new UnsupportedOperationException();
    } 

    public Tenant(String name, String userId, String nationalId, String picture) {
        super(name, userId, nationalId, picture);
    }
     public Tenant(String name, String userId, String nationalId, String picture, String phone, String email, String password) {
        super(name, userId, nationalId, picture, phone, email, password);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

   

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float Rating) {
        this.Rating = Rating;
    }
    
    
}
