/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Stay implements Serializable{
    Booking sBook;
    String numPeople;
    String Status;
    Payment sPay;
    String statusId;

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }
    
    

    public Booking getsBook() {
        return sBook;
    }

    public void setsBook(Booking sBook) {
        this.sBook = sBook;
    }

    public String getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(String numPeople) {
        this.numPeople = numPeople;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Payment getsPay() {
        return sPay;
    }

    public void setsPay(Payment sPay) {
        this.sPay = sPay;
    }
    
}
