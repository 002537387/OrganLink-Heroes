/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Emergency;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author jim.hsieh
 */
public class Emergency {
    private String emergencyID;
    private String emergencyType;
    private String description;
    private Date createdTimestamp;
    private UserAccount reportedBy;
    private String status;
    private List<UserAccount> stakeholders;
    private List<EmergencyLog> auditTrail;
    private String resolution;
    private String resolutionDetails;
    private Date resolvedTimestamp;
    private boolean postIncidentReviewCompleted;
    private String postIncidentReview;
    
    public Emergency(String emergencyType, String description, UserAccount reportedBy) {
        this.emergencyID = "EMG-" + System.currentTimeMillis();
        this.emergencyType = emergencyType;
        this.description = description;
        this.reportedBy = reportedBy;
        this.createdTimestamp = new Date();
        this.status = "Active";
        this.stakeholders = new ArrayList<>();
        this.auditTrail = new ArrayList<>();
        this.postIncidentReviewCompleted = false;
        this.addAuditLog("Emergency Alert Triggered", reportedBy);
    }
    
    public void addAuditLog(String actionType, UserAccount performedBy) {
        EmergencyLog log = new EmergencyLog(actionType, performedBy);
        this.auditTrail.add(log);
    }
    public void addAuditLog(String actionType, UserAccount performedBy, String description) {
    EmergencyLog log = new EmergencyLog(actionType, performedBy, description);
    this.auditTrail.add(log);
}
    
    public void addStakeholder(UserAccount user) {
        if (!stakeholders.contains(user)) {
            stakeholders.add(user);
        }
    }
    
    public String getEmergencyID() {
        return emergencyID;
    }
    
    public String getEmergencyType() {
        return emergencyType;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }
    
    public UserAccount getReportedBy() {
        return reportedBy;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<UserAccount> getStakeholders() {
        return stakeholders;
    }
    
    public List<EmergencyLog> getAuditTrail() {
        return auditTrail;
    }
    
    public String getResolution() {
        return resolution;
    }
    
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    
    public String getResolutionDetails() {
        return resolutionDetails;
    }
    
    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionDetails = resolutionDetails;
    }
    
    public Date getResolvedTimestamp() {
        return resolvedTimestamp;
    }
    
    public void setResolvedTimestamp(Date resolvedTimestamp) {
        this.resolvedTimestamp = resolvedTimestamp;
    }
    
    public boolean isPostIncidentReviewCompleted() {
        return postIncidentReviewCompleted;
    }
    
    public void setPostIncidentReviewCompleted(boolean completed) {
        this.postIncidentReviewCompleted = completed;
    }
    
    public String getPostIncidentReview() {
        return postIncidentReview;
    }
    
    public void setPostIncidentReview(String review) {
        this.postIncidentReview = review;
    }
    
    @Override
    public String toString() {
        return emergencyID + " - " + emergencyType + " (" + status + ")";
    }
}
