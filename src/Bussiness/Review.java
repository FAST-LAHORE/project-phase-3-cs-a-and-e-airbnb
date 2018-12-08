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
public class Review {
    User Reviewer;
    User Reviewee;
    String Description;
    Stay stayReview;

    public User getReviewer() {
        return Reviewer;
    }

    public void setReviewer(User Reviewer) {
        this.Reviewer = Reviewer;
    }

    public User getReviewee() {
        return Reviewee;
    }

    public void setReviewee(User Reviewee) {
        this.Reviewee = Reviewee;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
