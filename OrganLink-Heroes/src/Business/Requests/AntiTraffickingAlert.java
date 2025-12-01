package Business.Requests;

import Business.OrganMatch;
import Business.WorkQueue.WorkRequest;
import Business.Requests.AlertLevel; // Added import for AlertLevel
import Business.Statuses.RequestStatus; // Import for RequestStatus.EmergencyStatus
import java.util.Date;

public class AntiTraffickingAlert extends WorkRequest {
    private String suspectedActivity;
    private String relatedEntity; // e.g., Donor ID, Patient ID, Request ID
    private String geographicalArea;
    private AlertLevel alertLevel; // e.g., "Low", "Medium", "High"

    public AntiTraffickingAlert() {
        super();
        this.setStatus(RequestStatus.EmergencyStatus.ISSUE_DETECTED.getValue()); // Initial status using enum
        this.alertLevel = AlertLevel.MEDIUM; // Default alert level using enum
    }

    public AntiTraffickingAlert(String suspectedActivity, String relatedEntity, String geographicalArea, AlertLevel alertLevel) {
        super();
        this.suspectedActivity = suspectedActivity;
        this.relatedEntity = relatedEntity;
        this.geographicalArea = geographicalArea;
        this.alertLevel = alertLevel;
        this.setStatus(RequestStatus.EmergencyStatus.ISSUE_DETECTED.getValue());
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

    public AlertLevel getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(AlertLevel alertLevel) {
        this.alertLevel = alertLevel;
    }
    
    @Override
    public String toString() {
        return "Alert-" + getRequestNumber() + " (" + suspectedActivity + ")";
    }
}
