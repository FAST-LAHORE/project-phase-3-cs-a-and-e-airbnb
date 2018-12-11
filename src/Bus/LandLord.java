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
public class LandLord extends User implements Serializable {
    String sClearance;
    String cnicPhoto;

    public LandLord(String name, String userId, String nationalId, String picture, String phone, String email, String password,String sClearance) {
        super(name, userId, nationalId, picture, phone, email, password);
        this.sClearance=sClearance;
    }

    public LandLord(String name, String userId, String nationalId, String picture) {
        super(name, userId, nationalId, picture);
    }
    
    public Boolean cnicUploaded()   {
        return cnicPhoto != null;
    }
    public Boolean confirmBooking(Booking b)    {
        throw new UnsupportedOperationException();
    }
    public Boolean cancelBooking(Booking b) {
        throw new UnsupportedOperationException();
    }
    public Boolean endStay(Stay s)  {
        throw new UnsupportedOperationException();
    }
    public Boolean makeReview(Tenant t){    
        throw new UnsupportedOperationException();
    }
    public Boolean fileReport(Tenant t){
        throw new UnsupportedOperationException();
    }
    public String getSecurity()
    {
        return this.sClearance;
    }
}