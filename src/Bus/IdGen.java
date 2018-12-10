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
public class IdGen implements Serializable {
    // Generates Ids
    private static IdGen myIdGen = new IdGen();
    public static IdGen getInstance()  {
        return myIdGen;
    }

    public static void setMyIdGen(IdGen myIdGen) {
        IdGen.myIdGen = myIdGen;
    }
    
    // Id generator
    protected  Integer propertyIdGen = 0;
    protected  Integer bookMarkIdGen = 0;
    protected  Integer userIdGen = 0;
    protected  Integer reportIdGen = 0;
    protected Integer reviewIdGen = 0;
    protected  Integer stayIdGen = 0;
    protected  Integer bookingIdGen = 0;
    public  String genBookingId()    {
        return String.valueOf(bookingIdGen++);
    }
    public  String genPropertyId()    {
        return String.valueOf(propertyIdGen++);
    }
    public  String genBookMarkId()    {
        return String.valueOf(bookMarkIdGen++);
    }
    public  String genUserId()    {
        return String.valueOf(userIdGen++);
    }
    public  String genReportId()  {
        return String.valueOf(reportIdGen++);
    }
     public  String genReviewId()  {
        return String.valueOf(reviewIdGen++);
    }
     public  String genStayId()  {
        return String.valueOf(stayIdGen++);
    }
    
     
     
    
    
}
