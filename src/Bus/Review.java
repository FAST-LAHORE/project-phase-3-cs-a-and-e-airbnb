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
public class Review implements Serializable {
    User Reviewer;
    User Reviewee;
    String Description;
    Stay stayReview;
    String ReviewId;

    public Stay getStayReview() {
        return stayReview;
    }

    public void setStayReview(Stay stayReview) {
        this.stayReview = stayReview;
    }

    public String getReviewId() {
        return ReviewId;
    }

    public void setReviewId(String ReviewId) {
        this.ReviewId = ReviewId;
    }
    

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
