/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.Serializable;
import java.time.LocalDate;
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

    public Boolean requestBooking(Property p, LocalDate s, LocalDate e) throws ClassNotFoundException {
        if (Data.PropertyList.validDate(p, s, e)) {
            Data.BookingList.addBooking(new Booking(Bus.IdGen.getInstance().genBookMarkId(), s, e, "pending", this, p));
            for (LocalDate date = s; date.isBefore(e); date = date.plusDays(1)) {
                p.getDatesBooked().add(date.toString());
            }
            return true;
        } 
        else {
            return false;
        }
    }

    public Boolean cancelBooking(Booking b) {
        throw new UnsupportedOperationException();
    }

    public Boolean makeBookMark(Property p) throws ClassNotFoundException {
        return Data.BookMarkList.addBookMark(new BookMark(IdGen.getInstance().genBookMarkId(), this, p));
    }

    public Boolean fileComplaint(Stay s) {
        throw new UnsupportedOperationException();
    }

    public Boolean makeReview(Stay s) {
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
