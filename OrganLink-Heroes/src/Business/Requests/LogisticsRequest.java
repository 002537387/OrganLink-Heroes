package Business.Requests;

import Business.OrganMatch;
import Business.WorkQueue.WorkRequest;

public class LogisticsRequest extends WorkRequest {
    private OrganMatch organMatch;
    private String transportOption;
    private String trackingNumber;
    private String currentOrganLocation;
    private String preservationCondition; // e.g., temperature, time
    private String qrCodeScanStatus; // For chain of custody

    public LogisticsRequest(OrganMatch organMatch) {
        super();
        this.organMatch = organMatch;
        this.setStatus("Pending Transport Coordination"); // Initial status
    }

    // --- Getters and Setters ---
    public OrganMatch getOrganMatch() {
        return organMatch;
    }

    public void setOrganMatch(OrganMatch organMatch) {
        this.organMatch = organMatch;
    }

    public String getTransportOption() {
        return transportOption;
    }

    public void setTransportOption(String transportOption) {
        this.transportOption = transportOption;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCurrentOrganLocation() {
        return currentOrganLocation;
    }

    public void setCurrentOrganLocation(String currentOrganLocation) {
        this.currentOrganLocation = currentOrganLocation;
    }

    public String getPreservationCondition() {
        return preservationCondition;
    }

    public void setPreservationCondition(String preservationCondition) {
        this.preservationCondition = preservationCondition;
    }

    public String getQrCodeScanStatus() {
        return qrCodeScanStatus;
    }

    public void setQrCodeScanStatus(String qrCodeScanStatus) {
        this.qrCodeScanStatus = qrCodeScanStatus;
    }
    
    @Override
    public String toString() {
        return "LogisticsReq-" + getRequestNumber() + " for " + organMatch.getPatientRequest().getPatient().getName();
    }
}
