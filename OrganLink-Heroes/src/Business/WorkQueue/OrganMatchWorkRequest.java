package Business.WorkQueue;

import Business.OrganMatch;
import Business.UserAccount.UserAccount;
import java.util.Date;

public class OrganMatchWorkRequest extends WorkRequest {
    private OrganMatch organMatch;

    public OrganMatchWorkRequest(OrganMatch organMatch, UserAccount sender) {
        super();
        this.organMatch = organMatch;
        this.setSender(sender);
        this.setRequestDate(new Date());
        this.setStatus("New Organ Match Request");
        this.setSummary("New organ match for patient " + organMatch.getPatientRequest().getPatient().getName() + " and donor " + organMatch.getDonorRequest().getDonor().getName());
        this.setType(WorkRequestType.OrganMatch);
    }

    public OrganMatch getOrganMatch() {
        return organMatch;
    }

    public void setOrganMatch(OrganMatch organMatch) {
        this.organMatch = organMatch;
    }
}
