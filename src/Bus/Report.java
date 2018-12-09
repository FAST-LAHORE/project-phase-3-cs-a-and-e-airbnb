/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

/**
 *
 * @author hp
 */
public class Report {
    User filer;
    String Status;
    String Description;
    Stay stayR;
    String reportId;

    public User getFiler() {
        return filer;
    }

    public void setFiler(User filer) {
        this.filer = filer;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Stay getStayR() {
        return stayR;
    }

    public void setStayR(Stay stayR) {
        this.stayR = stayR;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
    
}
