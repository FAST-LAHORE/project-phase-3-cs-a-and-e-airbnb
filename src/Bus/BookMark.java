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
public class BookMark implements Serializable {
    String bookMarkId;
    Tenant bookTenant;
    Property bookProperty;

    public BookMark(String bookMarkId, Tenant bookTenant, Property bookProperty) {
        this.bookMarkId = bookMarkId;
        this.bookTenant = bookTenant;
        this.bookProperty = bookProperty;
    }

    public String getBookMarkId() {
        return bookMarkId;
    }

    public void setBookMarkId(String bookMarkId) {
        this.bookMarkId = bookMarkId;
    }

    public Tenant getBookTenant() {
        return bookTenant;
    }

    public void setBookTenant(Tenant bookTenant) {
        this.bookTenant = bookTenant;
    }

    public Property getBookProperty() {
        return bookProperty;
    }

    public void setBookProperty(Property bookProperty) {
        this.bookProperty = bookProperty;
    }
    
    
}
