/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author hp
 */
public class Booking implements Serializable {
    String bookingId;
    LocalDate sDate;
    LocalDate eDate;
    String status;
    Tenant bTenant;
    Property bProperty;

    public Booking()  {
    }

    public Booking(String bookingId, LocalDate sDate, LocalDate eDate, String status, Tenant bTenant, Property bProperty) {
        this.bookingId = bookingId;
        this.sDate = sDate;
        this.eDate = eDate;
        this.status = status;
        this.bTenant = bTenant;
        this.bProperty = bProperty;
    }

 

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getsDate() {
        return sDate;
    }

    public void setsDate(LocalDate sDate) {
        this.sDate = sDate;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

  
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tenant getbTenant() {
        return bTenant;
    }

    public void setbTenant(Tenant bTenant) {
        this.bTenant = bTenant;
    }

    public Property getbProperty() {
        return bProperty;
    }

    public void setbProperty(Property bProperty) {
        this.bProperty = bProperty;
    }
    
}
