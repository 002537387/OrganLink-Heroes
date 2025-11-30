package Business.Requests;

import Business.OrganMatch;
import Business.WorkQueue.WorkRequest;
import java.util.Date;

public class AntiTraffickingAlert extends WorkRequest {
    private String suspectedActivity;
    private String relatedEntity; // e.g., Donor ID, Patient ID, Request ID
    private String geographicalArea;
    private String alertLevel; // e.g., "Low", "Medium", "High"

    public AntiTraffickingAlert() {
        super();
        this.setStatus("New Alert"); // Initial status
        this.setAlertLevel("Medium"); // Default alert level
    }

    public AntiTraffickingAlert(String suspectedActivity, String relatedEntity, String geographicalArea, String alertLevel) {
        super();
        this.suspectedActivity = suspectedActivity;
        this.relatedEntity = relatedEntity;
        this.geographicalArea = geographicalArea;
        this.alertLevel = alertLevel;
        this.setStatus("New Alert");
    }

    // --- Getters and Setters ---
    public String getSuspectedActivity() {
        return suspectedActivity;
    }

    public void setSuspectedActivity(String suspectedActivity) {
        this.suspectedActivity = suspectedActivity;
    }

    public String getRelatedEntity() {
        return relatedEntity;
    }

    public void setRelatedEntity(String relatedEntity) {
        this.relatedEntity = relatedEntity;
    }

    public String getGeographicalArea() {
        return geographicalArea;
    }

    public void setGeographicalArea(String geographicalArea) {
        this.geographicalArea = geographicalArea;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }
    
    @Override
    public String toString() {
        return "Alert-" + getRequestNumber() + " (" + suspectedActivity + ")";
    }
}
