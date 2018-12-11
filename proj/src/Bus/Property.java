/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author hp
 */
public class Property implements Serializable  {
    
    PropertyType        pType;
    List<Facilties>     pFacilities;
    List<Restrictions>  pRestrictions;
    List<Amenities>     pAmenities;
    List<String>        Reviews;
    List<Float>         Ratings;       
    HashSet<Date>       datesBooked;
    
    String propertyAdd;
    String propertyCity;
    String propertyName;
    String propertyId;
    LandLord pLandLord;

   
    
    Boolean isAvailable(Date d){
    // CHECK CURRENT dATE AND bOOKED DATE
        throw new UnsupportedOperationException();
    }

    public String getPropertyAdd() {
        return propertyAdd;
    }

    public void setPropertyAdd(String propertyAdd) {
        this.propertyAdd = propertyAdd;
    }

    public String getPropertyCity() {
        return propertyCity;
    }

    public void setPropertyCity(String propertyCity) {
        this.propertyCity = propertyCity;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    
     public LandLord getpLandLord() {
        return pLandLord;
    }

    public void setpLandLord(LandLord pLandLord) {
        this.pLandLord = pLandLord;
    }
    
    public PropertyType getpType() {
        return pType;
    }

    public void setpType(PropertyType pType) {
        this.pType = pType;
    }

    public List<Facilties> getpFacilities() {
        return pFacilities;
    }

    public void setpFacilities(List<Facilties> pFacilities) {
        this.pFacilities = pFacilities;
    }

    public List<Restrictions> getpRestrictions() {
        return pRestrictions;
    }

    public void setpRestrictions(List<Restrictions> pRestrictions) {
        this.pRestrictions = pRestrictions;
    }

    public List<Amenities> getpAmenities() {
        return pAmenities;
    }

    public void setpAmenities(List<Amenities> pAmenities) {
        this.pAmenities = pAmenities;
    }

    public List<String> getReviews() {
        return Reviews;
    }

    public void setReviews(List<String> Reviews) {
        this.Reviews = Reviews;
    }

    public List<Float> getRatings() {
        return Ratings;
    }

    public void setRatings(List<Float> Ratings) {
        this.Ratings = Ratings;
    }

    public HashSet<Date> getDatesBooked() {
        return datesBooked;
    }

    public void setDatesBooked(HashSet<Date> datesBooked) {
        this.datesBooked = datesBooked;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }
    
    
}
