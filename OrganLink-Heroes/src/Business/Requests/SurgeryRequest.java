package Business.Requests;

import Business.OrganMatch;
import Business.WorkQueue.WorkRequest;
import java.util.Date;

public class SurgeryRequest extends WorkRequest {
    private OrganMatch organMatch;
    private String surgeryStatus; // e.g., "Commenced", "Completed", "Complications Noted"
    private String initialOutcome; // Immediate post-surgery assessment
    private String followUpReport; // General field for follow-up data
    private Date surgeryDate;
    private Date followUp24HrDate;
    private Date followUp7DayDate;
    private Date followUp30DayDate;
    private Date followUp90DayDate;

    public SurgeryRequest(OrganMatch organMatch) {
        super();
        this.organMatch = organMatch;
        this.surgeryStatus = "Scheduled"; // Initial status
    }

    // --- Getters and Setters ---
    public OrganMatch getOrganMatch() {
        return organMatch;
    }

    public void setOrganMatch(OrganMatch organMatch) {
        this.organMatch = organMatch;
    }

    public String getSurgeryStatus() {
        return surgeryStatus;
    }

    public void setSurgeryStatus(String surgeryStatus) {
        this.surgeryStatus = surgeryStatus;
    }

    public String getInitialOutcome() {
        return initialOutcome;
    }

    public void setInitialOutcome(String initialOutcome) {
        this.initialOutcome = initialOutcome;
    }

    public String getFollowUpReport() {
        return followUpReport;
    }

    public void setFollowUpReport(String followUpReport) {
        this.followUpReport = followUpReport;
    }

    public Date getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(Date surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public Date getFollowUp24HrDate() {
        return followUp24HrDate;
    }

    public void setFollowUp24HrDate(Date followUp24HrDate) {
        this.followUp24HrDate = followUp24HrDate;
    }

    public Date getFollowUp7DayDate() {
        return followUp7DayDate;
    }

    public void setFollowUp7DayDate(Date followUp7DayDate) {
        this.followUp7DayDate = followUp7DayDate;
    }

    public Date getFollowUp30DayDate() {
        return followUp30DayDate;
    }

    public void setFollowUp30DayDate(Date followUp30DayDate) {
        this.followUp30DayDate = followUp30DayDate;
    }

    public Date getFollowUp90DayDate() {
        return followUp90DayDate;
    }

    public void setFollowUp90DayDate(Date followUp90DayDate) {
        this.followUp90DayDate = followUp90DayDate;
    }

    @Override
    public String toString() {
        return "SurgeryReq-" + getRequestNumber() + " for " + organMatch.getPatientRequest().getPatient().getName();
    }
}
