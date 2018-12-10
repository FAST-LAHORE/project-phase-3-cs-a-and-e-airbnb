/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author hp
 */
public class Property implements Serializable {

    PropertyType pType;
    HashSet<String> pFacilities;
    HashSet<String> pRestrictions;
    HashSet<String> pAmenities;
    List<String> Reviews;
    List<Float> Ratings;
    HashSet<String> datesBooked;

    String propertyDesc;
    String propertyAdd;
    String propertyCity;
    String propertyName;
    String propertyId;
    LandLord pLandLord;
    Double pCharge;
    String pImage;

    public Boolean isAvailable(LocalDate d) {
        // CHECK CURRENT dATE AND bOOKED DATE
        return !datesBooked.contains(d.toString());
    }

    public void addDate(String d) {
        this.datesBooked.add(d.toString());
    }

    public Property() {
        pFacilities = new HashSet<String>();
        pRestrictions = new HashSet<String>();
        pAmenities = new HashSet<String>();
        Reviews = new ArrayList<String>();
        Ratings = new ArrayList<Float>();
        datesBooked = new HashSet<String>();
    }

    public String getAverageRating() {
        if (Ratings.isEmpty()) {
            return ("Not Present");
        } else {
            Double sum = 0.0;
            for (Float i : Ratings) {
                sum += (Float) i;
            }
            return String.valueOf((double) sum / Ratings.size());
        }
    }

    public Double getpCharge() {
        return pCharge;
    }

    public void setpCharge(Double pCharge) {
        this.pCharge = pCharge;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
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

    public HashSet<String> getpFacilities() {
        return pFacilities;
    }

    public void setpFacilities(HashSet<String> pFacilities) {
        this.pFacilities = pFacilities;
    }

    public HashSet<String> getpRestrictions() {
        return pRestrictions;
    }

    public void setpRestrictions(HashSet<String> pRestrictions) {
        this.pRestrictions = pRestrictions;
    }

    public HashSet<String> getpAmenities() {
        return pAmenities;
    }

    public void setpAmenities(HashSet<String> pAmenities) {
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

    public HashSet<String> getDatesBooked() {
        return datesBooked;
    }

    public void setDatesBooked(HashSet<String> datesBooked) {
        this.datesBooked = datesBooked;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

}
