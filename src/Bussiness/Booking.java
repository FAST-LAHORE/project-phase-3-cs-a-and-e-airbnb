/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Booking {
    String bookingId;
    Date bDate;
    String status;
    Tenant bTenant;
    Property bProperty;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
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
