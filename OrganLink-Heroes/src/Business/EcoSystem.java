/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business; // Moved to the correct position

import Business.BloodTypes.PersonBloodTypes;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.People.Donor;
import Business.People.DonorDirectory;
import Business.People.Patient;
import Business.People.PatientDirectory;
import Business.Requests.AntiTraffickingAlert;
import Business.Requests.AlertLevel; // Added import for AlertLevel
import Business.Requests.DonorRequest;
import Business.Requests.DonorRequestDirectory;
import Business.Requests.PatientRequest;
import Business.Requests.PatientRequestDirectory;
import Business.Emergency.EmergencyDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Statuses.DonorApplicationStatuses;
import Business.Statuses.RequestStatus;
import Business.UserAccount.UserAccount;
import Business.Notifications.Notification; // Added import for Notification
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Ing-Ruei
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;

    private DonorDirectory donorDirectory;
    private PatientDirectory patientDirectory;
    private DonorRequestDirectory donorRequestDirectory;
    private PatientRequestDirectory patientRequestDirectory;
    private EmergencyDirectory emergencyDirectory;
    private UserAccountDirectory userAccountDirectory;
    private PersonBloodTypes personBloodTypes;
    private DonorApplicationStatuses donorApplicationStatus;
    private ArrayList<OrganMatch> matchedRequests; // New field to store matched requests

    private ArrayList<Network> networkList;

    // Private constructor for Singleton pattern
    private EcoSystem() {
        super("OrganLink Heroes", Organization.Type.System.getValue());
        networkList = new ArrayList<Network>();
        this.donorDirectory = new DonorDirectory();
        this.patientDirectory = new PatientDirectory();
        this.donorRequestDirectory = new DonorRequestDirectory(this);
        this.patientRequestDirectory = new PatientRequestDirectory(this);
        this.userAccountDirectory = new UserAccountDirectory();
        this.donorApplicationStatus = new DonorApplicationStatuses();
        this.personBloodTypes = new PersonBloodTypes();
        this.matchedRequests = new ArrayList<>(); // Initialize matchedRequests
        this.emergencyDirectory = new EmergencyDirectory();
    }
    
    // Method to send notifications to a user
    public static void sendNotification(UserAccount recipient, String message) {
        if (recipient != null) {
            Notification notification = new Notification(message, recipient.getUsername());
            recipient.getNotificationList().add(notification);
            System.out.println("Notification sent to " + recipient.getUsername() + ": " + message);
        }
    }

    // Singleton instance accessor
    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public DonorDirectory getDonorDirectory() {
        if (this.donorDirectory == null) {
            this.donorDirectory = new DonorDirectory();
        }
        return donorDirectory;
    }

    public void setDonorDirectory(DonorDirectory donorDirectory) {
        this.donorDirectory = donorDirectory;
    }

    public PatientDirectory getPatientDirectory() {
        if (this.patientDirectory == null) {
            this.patientDirectory = new PatientDirectory();
        }
        return patientDirectory;
    }
    public EmergencyDirectory getEmergencyDirectory() {
    return emergencyDirectory;
}


    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public DonorRequestDirectory getDonorRequestDirectory() {
        if (this.donorRequestDirectory == null) {
            this.donorRequestDirectory = new DonorRequestDirectory(this);
        }
        return donorRequestDirectory;
    }

    public void setDonorRequestDirectory(DonorRequestDirectory donorRequestDirectory) {
        this.donorRequestDirectory = donorRequestDirectory;
    }

    public PatientRequestDirectory getPatientRequestDirectory() {
        if (this.patientRequestDirectory == null) {
            this.patientRequestDirectory = new PatientRequestDirectory(this);
        }
        return patientRequestDirectory;
    }

    public void setPatientRequestDirectory(PatientRequestDirectory patientRequestDirectory) {
        this.patientRequestDirectory = patientRequestDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        if (this.userAccountDirectory == null) {
            userAccountDirectory = new UserAccountDirectory();
            Employee employee = this.getEmployeeDirectory().createEmployee("sysadmin");
            UserAccount ua = this.userAccountDirectory.createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        }
        return this.userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public DonorApplicationStatuses getDonorApplicationStatus() {
        return donorApplicationStatus;
    }

    public PersonBloodTypes getPersonBloodTypes() {
        return personBloodTypes;
    }



    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public ArrayList<OrganMatch> getMatchedRequests() {
        return matchedRequests;
    }

    // Adds a new network to the list
    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    // Checks if a username is unique across the system
    public boolean checkIfUserIsUnique(String userName) {
        if (this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            return false;
        }
        for (Network network : networkList) {
            if (network.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                return false;
            }
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                    return false;
                }
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // Organ Matching Algorithm
    public ArrayList<OrganMatch> runOrganMatchingAlgorithm() {
        this.matchedRequests.clear(); // Clear previous matches
        
        ArrayList<PatientRequest> activePatientRequests = new ArrayList<>();
        for (PatientRequest pr : patientRequestDirectory.getPatientRequestList()) {
            if (pr.getStatus().equals(RequestStatus.PatientRequestStatus.IN_PRIORITY_QUEUE.getValue())) {
                activePatientRequests.add(pr);
            }
        }

        ArrayList<DonorRequest> activeDonorRequests = new ArrayList<>();
        for (DonorRequest dr : donorRequestDirectory.getDonorRequestList()) {
            if (dr.getStatus().equals(RequestStatus.DonorApplicationStatus.APPROVED.getValue())) {
                activeDonorRequests.add(dr);
            }
        }
        
        for (PatientRequest patientRequest : activePatientRequests) {
            OrganMatch bestMatch = OrganMatch.FindBestMatch(patientRequest, activeDonorRequests);
            if (bestMatch != null) {
                this.matchedRequests.add(bestMatch);
                // Optionally, update status of patient/donor requests here if a match is found
                patientRequest.setStatus(RequestStatus.PatientRequestStatus.MATCHED_AWAITING_ACCEPTANCE.getValue());
                // For the donor, you might set a status like "Matched - Pending Acceptance" or similar
                // bestMatch.getDonorRequest().setStatus(RequestStatus.DonorApplicationStatus.MATCHED.getValue());
            }
        }
        
        // Sort matches by score (highest first) - already handled by FindBestMatch if it selects best
        // This sorting here would be to sort the entire list of best matches if multiple patients got matches
        this.matchedRequests.sort((m1, m2) -> Double.compare(m2.getMatchScore(), m1.getMatchScore()));
        
        return this.matchedRequests;
    }
    
    // Anti-Trafficking Protection: Detect Suspicious Activity
    public void detectSuspiciousActivity() {
        System.out.println("Running Anti-Trafficking monitoring...");
        
        for (DonorRequest donorRequest : donorRequestDirectory.getDonorRequestList()) {
            Donor donor = donorRequest.getDonor();
            if (donor == null) continue;

            // Rule 1: Flag young living donors
            if (donorRequest.getDonationType().equals("Living Donation") && donor.getAge() < 20) {
                AntiTraffickingAlert alert = new AntiTraffickingAlert(
                    "Potential underage living donor",
                    donor.getDonorID(),
                    donor.getState() + ", " + donor.getCity(),
                    AlertLevel.HIGH
                );
                routeAntiTraffickingAlert(alert);
            }
            // Add more rules here (e.g., unusual donation frequency, suspicious medical history)
        }

        // Rule 2: Flag patients with multiple urgent requests for different organs in short span (placeholder)
        // for (PatientRequest patientRequest : patientRequestDirectory.getPatientRequestList()) { ... }
        
        // Rule 3: Flag if a donor has no valid address or contact information (placeholder)
        // for (Donor donor : donorDirectory.getDonorList()) { ... }
    }

    private void routeAntiTraffickingAlert(AntiTraffickingAlert alert) {
        // Find a GovernmentOrganization to route the alert to
        Organization governmentOrganization = null;
        for (Network network : networkList) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getEnterpriseType() == Enterprise.EnterpriseType.Government) {
                    for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                        if (org.getType() == Organization.Type.Government) {
                            governmentOrganization = org;
                            break;
                        }
                    }
                }
                if (governmentOrganization != null) {
                    break;
                }
            }
            if (governmentOrganization != null) {
                break;
            }
        }

        if (governmentOrganization != null) {
            governmentOrganization.getWorkQueue().addWorkRequest(alert);
            System.out.println("Anti-Trafficking Alert routed to Government Organization: " + alert.getSuspectedActivity());
        } else {
            System.err.println("No Government Organization found to route Anti-Trafficking Alert.");
        }
    }
}
