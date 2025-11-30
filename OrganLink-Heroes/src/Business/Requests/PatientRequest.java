/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Requests;

import Business.BloodTypes.PersonBloodTypes;
import Business.BloodTypes.PersonBloodTypes.BloodType;
import Business.Statuses.DonorApplicationStatuses;
import Business.WorkQueue.WorkRequest;
import java.util.Date;

public class PatientRequest extends WorkRequest {

    // Constructor to initialize PatientRequest, calls superclass constructor
    public PatientRequest() {
        super();
    }



    private String requiredOrganType;
    private String medicalUrgencyLevel;
    private String contraindications;
    private String specialRequirements;

    // Getter and Setter for requiredOrganType
    public String getRequiredOrganType() {
        return requiredOrganType;
    }

    public void setRequiredOrganType(String requiredOrganType) {
        this.requiredOrganType = requiredOrganType;
    }

    // Getter and Setter for medicalUrgencyLevel
    public String getMedicalUrgencyLevel() {
        return medicalUrgencyLevel;
    }

    public void setMedicalUrgencyLevel(String medicalUrgencyLevel) {
        this.medicalUrgencyLevel = medicalUrgencyLevel;
    }

    // Getter and Setter for contraindications
    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    // Getter and Setter for specialRequirements
    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    // Overridden toString method to return receiver ID
    @Override
    public String toString() {
        return getPatient().toString(); // Assuming WorkRequest's getPatient() returns the Patient object
    }
}

