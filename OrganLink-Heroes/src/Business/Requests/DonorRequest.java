/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Requests;

import Business.BloodTypes.PersonBloodTypes;
import Business.BloodTypes.PersonBloodTypes.BloodType;
import Business.Statuses.DonorApplicationStatuses;
import Business.WorkQueue.WorkRequest;
import Business.OrganTypes.OrganType; // Added import
import Business.Requests.DonationType; // Added import for DonationType
import java.util.Date;

public class DonorRequest extends WorkRequest {

    // Constructor to initialize DonorRequest, calls superclass constructor
    public DonorRequest() {
        super();
    }

    private DonationType donationType; // e.g., "Living" or "Post-mortem"
    private boolean consentAcknowledged;
    private String digitalSignature;
    private OrganType offeredOrganType; // New field for the type of organ being offered
    private Date retrievalDate; // New field for the proposed organ retrieval date

    // Getter and Setter for donationType
    public String getDonationType() {
        return donationType.getValue(); // Return the string value of the enum
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }
    
    // Getter and Setter for retrievalDate
    public Date getRetrievalDate() {
        return retrievalDate;
    }

    public void setRetrievalDate(Date retrievalDate) {
        this.retrievalDate = retrievalDate;
    }

    // Getter and Setter for consentAcknowledged
    public boolean isConsentAcknowledged() {
        return consentAcknowledged;
    }

    public void setConsentAcknowledged(boolean consentAcknowledged) {
        this.consentAcknowledged = consentAcknowledged;
    }

    // Getter and Setter for digitalSignature
    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
    
    // Getter and Setter for offeredOrganType
    public OrganType getOfferedOrganType() {
        return offeredOrganType;
    }

    public void setOfferedOrganType(OrganType offeredOrganType) {
        this.offeredOrganType = offeredOrganType;
    }

    // toString method to return donor ID as string representation
    @Override
    public String toString() {
        return getDonor().toString(); // Assuming WorkRequest's getDonor() returns the Donor object
    }
}
