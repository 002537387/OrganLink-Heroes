package Business;

import Business.BloodTypes.PersonBloodTypes;
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
    
    public static OrganMatch FindBestMatch(PatientRequest patientRequest, java.util.List<DonorRequest> donorRequests) {
        OrganMatch bestMatch = null;
        double maxScore = -1;

        for (DonorRequest donorRequest : donorRequests) {
            double currentScore = calculateScore(patientRequest, donorRequest);
            if (currentScore > maxScore) {
                maxScore = currentScore;
                bestMatch = new OrganMatch(patientRequest, donorRequest, maxScore);
            }
        }
        return bestMatch;
    }

    private static double calculateScore(PatientRequest patientRequest, DonorRequest donorRequest) {
        // Factor 1: Organ Type Match (Essential)
        if (patientRequest.getRequiredOrganType() != donorRequest.getOfferedOrganType()) {
            return 0; // No match if organ types are different
        }

        // Factor 2: Blood Type Compatibility (Essential)
        PersonBloodTypes bloodMatcher = new PersonBloodTypes();
        Business.BloodTypes.PersonBloodTypes.BloodType patientBloodType = bloodMatcher.findBloodType(patientRequest.getPatient().getBloodType().getValue());
        Business.BloodTypes.PersonBloodTypes.BloodType donorBloodType = bloodMatcher.findBloodType(donorRequest.getDonor().getBloodType().getValue());
        
        if (!patientBloodType.getEligibleDonors().contains(donorBloodType)) {
            return 0; // No match if blood types are incompatible
        }

        // Base score for compatible match
        double score = 50;

        // Factor 3: Medical Urgency
        switch (patientRequest.getMedicalUrgencyLevel()) {
            case CRITICAL:
                score += 40;
                break;
            case HIGH:
                score += 30;
                break;
            case MEDIUM:
                score += 20;
                break;
            case STANDARD:
                score += 10;
                break;
        }

        return score;
    }}

