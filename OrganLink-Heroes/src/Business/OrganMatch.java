package Business;

import Business.Requests.DonorRequest;
import Business.Requests.PatientRequest;
import java.util.Date;

public class OrganMatch {
    private PatientRequest patientRequest;
    private DonorRequest donorRequest;
    private double matchScore;
    private Date matchDate;
    private String status; // e.g., "Pending Acceptance", "Accepted", "Rejected"
    private String matchId; // New field for unique match ID

    public OrganMatch(PatientRequest patientRequest, DonorRequest donorRequest, double matchScore) {
        this.patientRequest = patientRequest;
        this.donorRequest = donorRequest;
        this.matchScore = matchScore;
        this.matchDate = new Date();
        this.status = "Pending Acceptance"; // Initial status
        this.matchId = "MATCH-" + System.currentTimeMillis(); // Generate a unique ID
    }

    // --- Getters and Setters ---
    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
    public PatientRequest getPatientRequest() {
        return patientRequest;
    }

    public void setPatientRequest(PatientRequest patientRequest) {
        this.patientRequest = patientRequest;
    }

    public DonorRequest getDonorRequest() {
        return donorRequest;
    }

    public void setDonorRequest(DonorRequest donorRequest) {
        this.donorRequest = donorRequest;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Match for Patient: " + patientRequest.getPatient().getName() + " and Donor: " + donorRequest.getDonor().getName();
    }
}
