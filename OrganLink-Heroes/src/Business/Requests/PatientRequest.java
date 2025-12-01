/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Requests;

import Business.BloodTypes.PersonBloodTypes;
import Business.BloodTypes.PersonBloodTypes.BloodType;
import Business.Statuses.DonorApplicationStatuses;
import Business.WorkQueue.WorkRequest;
import Business.OrganTypes.OrganType; // Added import for OrganType
import Business.Requests.MedicalUrgencyLevel; // Added import for MedicalUrgencyLevel
import java.util.Date;

public class PatientRequest extends WorkRequest {

    // Constructor to initialize PatientRequest, calls superclass constructor
        public PatientRequest() {
            super();
        }
    
        private OrganType requiredOrganType;
    private MedicalUrgencyLevel medicalUrgencyLevel;
    private String contraindications;
    private String specialRequirements;

    public OrganType getRequiredOrganType() {
        return requiredOrganType;
    }

    public void setRequiredOrganType(OrganType requiredOrganType) {
        this.requiredOrganType = requiredOrganType;
    }

    public MedicalUrgencyLevel getMedicalUrgencyLevel() {
        return medicalUrgencyLevel;
    }

    public void setMedicalUrgencyLevel(MedicalUrgencyLevel medicalUrgencyLevel) {
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

