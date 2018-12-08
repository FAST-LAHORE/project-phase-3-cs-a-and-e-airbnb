/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author hp
 */
public class LandLord {
    String sClearance;
    String cnicPhoto;
    String name;
    String email;
    String contact;
    String address;
    
    LandLord(String sClearance,String name,String email,String contact,String address)
    {
        this.address=address;
        this.contact=contact;
        this.email=email;
        this.name=name;
        this.sClearance=sClearance;
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
}
