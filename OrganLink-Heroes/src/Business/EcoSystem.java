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
import Business.Requests.DonorRequest;
import Business.Requests.DonorRequestDirectory;
import Business.Requests.PatientRequest;
import Business.Requests.PatientRequestDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Statuses.DonorApplicationStatuses;
import Business.Statuses.RequestStatus;
import Business.UserAccount.UserAccount;
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
    private UserAccountDirectory userAccountDirectory;
    private PersonBloodTypes personBloodTypes;
    private DonorApplicationStatuses donorApplicationStatus;
    private ArrayList<OrganMatch> matchedRequests; // New field to store matched requests

    private ArrayList<Network> networkList;

    // Private constructor for Singleton pattern
    private EcoSystem() {
        super("OrganLink Heroes", null, Organization.Type.System.getValue());
        networkList = new ArrayList<Network>();
        this.donorDirectory = new DonorDirectory();
        this.patientDirectory = new PatientDirectory();
        this.donorRequestDirectory = new DonorRequestDirectory(this);
        this.patientRequestDirectory = new PatientRequestDirectory(this);
        this.userAccountDirectory = new UserAccountDirectory();
        this.donorApplicationStatus = new DonorApplicationStatuses();
        this.personBloodTypes = new PersonBloodTypes();
        this.matchedRequests = new ArrayList<>(); // Initialize matchedRequests
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
        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            return false;
        }
        for (Network network : networkList) {
            // Additional checks for networks can be added here
        }
        return true;
    }
    
    // Organ Matching Algorithm
    public ArrayList<OrganMatch> runOrganMatchingAlgorithm() {
        ArrayList<OrganMatch> currentMatches = new ArrayList<>();
        
        for (PatientRequest patientRequest : patientRequestDirectory.getPatientRequestList()) {
            // Only consider patient requests that are approved and awaiting matching
            if (patientRequest.getStatus().equals(RequestStatus.PatientRequestStatus.MATCHED_AWAITING_ACCEPTANCE.getValue())) {
                
                Patient patient = patientRequest.getPatient();
                if (patient == null) continue; // Skip if patient is null

                for (DonorRequest donorRequest : donorRequestDirectory.getDonorRequestList()) {
                    // Only consider donor requests that are approved and active
                    if (donorRequest.getStatus().equals(RequestStatus.DonorApplicationStatus.APPROVED.getValue())) {
                        
                        Donor donor = donorRequest.getDonor();
                        if (donor == null) continue; // Skip if donor is null

                        double matchScore = 0;
                        boolean compatible = true;

                        // 1. Organ Type Compatibility
                        if (!patientRequest.getRequiredOrganType().equals(donorRequest.getOfferedOrganType().getValue())) {
                            compatible = false;
                        } else {
                            matchScore += 1.0;
                        }

                        // 2. Blood Type Compatibility
                        PersonBloodTypes.BloodType patientBloodType = patient.getBloodType();
                        PersonBloodTypes.BloodType donorBloodType = donor.getBloodType();
                        if (patientBloodType != null && donorBloodType != null) {
                            if (!personBloodTypes.findBloodType(patientBloodType.getValue()).getEligibleDonors().contains(donorBloodType)) {
                                compatible = false;
                            } else {
                                matchScore += 1.0;
                            }
                        } else {
                            compatible = false; // Cannot check compatibility without blood types
                        }

                        // 3. Tissue Markers / Antibody Profile (simple check for now)
                        if (patient.getTissueMarkers() != null && !patient.getTissueMarkers().isEmpty() &&
                            donor.getTissueMarkers() != null && !donor.getTissueMarkers().isEmpty()) {
                            if (patient.getTissueMarkers().equals(donor.getTissueMarkers())) {
                                matchScore += 0.5; // Partial score for matching tissue markers
                            }
                        }
                        if (patient.getAntibodyProfile() != null && !patient.getAntibodyProfile().isEmpty() &&
                            donor.getAntibodyProfile() != null && !donor.getAntibodyProfile().isEmpty()) {
                            if (patient.getAntibodyProfile().equals(donor.getAntibodyProfile())) {
                                matchScore += 0.5; // Partial score for matching antibody profile
                            }
                        }
                        
                        // 4. Geographic Proximity (simple check: same state, same city)
                        // Assuming patient and donor addresses are available and relevant
                        if (patient.getState().equals(donor.getState())) {
                            matchScore += 0.5;
                            if (patient.getCity().equals(donor.getCity())) {
                                matchScore += 0.5;
                            }
                        }

                        // 5. Medical Urgency Weighting
                        double urgencyMultiplier = 1.0;
                        if (patientRequest.getMedicalUrgencyLevel().equals("Critical")) urgencyMultiplier = 2.0;
                        else if (patientRequest.getMedicalUrgencyLevel().equals("High")) urgencyMultiplier = 1.5;
                        
                        matchScore *= urgencyMultiplier;

                        if (compatible && matchScore > 0) { // Ensure there's at least one match criteria met
                            OrganMatch match = new OrganMatch(patientRequest, donorRequest, matchScore);
                            currentMatches.add(match);
                        }
                    }
                }
            }
        }
        
        // Sort matches by score (highest first)
        currentMatches.sort((m1, m2) -> Double.compare(m2.getMatchScore(), m1.getMatchScore()));
        
        // Store these matches
        this.matchedRequests.addAll(currentMatches); 
        return currentMatches;
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
                    "High"
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
