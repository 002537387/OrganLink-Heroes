package Business.OrganTypes;

import java.util.Date;

public class Organ {
    private String organId;
    private OrganType type;
    private String condition; // e.g., "Good", "Fair", "Excellent"
    private Date retrievalDate;
    private String currentStatus; // e.g., "Available", "Allocated", "In Transit"
    private String compatibilityMarkers; // Generic string for now, could be a complex object later
    private String donorId; // Reference to the donor
    private String patientId; // Reference to the recipient (if allocated)

    public Organ(OrganType type, String donorId) {
        this.type = type;
        this.donorId = donorId;
        this.organId = generateUniqueOrganId(); // Needs to be implemented
        this.currentStatus = "Available"; // Default status
    }

    // --- Getters and Setters ---
    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public OrganType getType() {
        return type;
    }

    public void setType(OrganType type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void voidsetCondition(String condition) {
        this.condition = condition;
    }

    public Date getRetrievalDate() {
        return retrievalDate;
    }

    public void setRetrievalDate(Date retrievalDate) {
        this.retrievalDate = retrievalDate;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCompatibilityMarkers() {
        return compatibilityMarkers;
    }

    public void setCompatibilityMarkers(String compatibilityMarkers) {
        this.compatibilityMarkers = compatibilityMarkers;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    
    // --- Utility Methods ---
    private String generateUniqueOrganId() {
        // Implement a unique ID generation logic here
        // For simplicity, using a timestamp + random number
        return "ORG-" + System.currentTimeMillis() + "-" + (int)(Math.random() * 10000);
    }

    @Override
    public String toString() {
        return organId;
    }
}
