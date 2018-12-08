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

public class LandLord extends User{

    String sClearance;

    String cnicPhoto;

    LandLord(String name, String userId, String nationalId, String picture) {

        super(name, userId, nationalId, picture);

    }

    public Boolean cnicUploaded()   {

        return cnicPhoto != null;

    }

//    public Boolean confirmBooking(Booking b)    {
//
//        throw new UnsupportedOperationException();
//
//    }

//    public Boolean cancelBooking(Booking b) {
//
//        throw new UnsupportedOperationException();
//
//    }
//
//    public Boolean endStay(Stay s)  {
//
//        throw new UnsupportedOperationException();
//
//    }

    public Boolean makeReview(Tenant t){    

        throw new UnsupportedOperationException();

    }

    public Boolean fileReport(Tenant t){

        throw new UnsupportedOperationException();

    }

}