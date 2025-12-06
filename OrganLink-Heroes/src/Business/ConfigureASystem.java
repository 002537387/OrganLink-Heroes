package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.OrganTypes.OrganType;
import Business.Organization.Organization;
import Business.People.Patient;
import Business.Requests.PatientRequest;
import Business.Requests.MedicalUrgencyLevel; // Added import for MedicalUrgencyLevel
import Business.Requests.PatientRequestDirectory;
import Business.Role.CaseManagerRole;
import Business.Role.GovernmentAgentRole;
import Business.Role.LabTechnicianRole;
import Business.Role.HospitalOfficerRole;
import Business.Role.LogisticsOfficerRole;
import Business.Role.SystemAdminRole;
import Business.Statuses.RequestStatus;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Ing-Ruei
 */
public class ConfigureASystem {

    // Let's create a sample patient request to test our setup
    public static void addSampleRequestData(EcoSystem system) {
        // Create a Patient object
        Patient samplePatient = new Patient();
        samplePatient.setName("Jack");
        samplePatient.setAge(35);
        samplePatient.setCity("Boston");
        samplePatient.setEmailID("jack@northeastern.edu");
        samplePatient.setReceiverID("PAT-Sample-001"); // Example ID
        // Assuming other Patient attributes are set elsewhere or default

        // Add the patient to the system's patient directory
        system.getPatientDirectory().addPatient(samplePatient);

        // Create a PatientRequest and link it to the Patient
        PatientRequest sampleRequest = new PatientRequest();
        sampleRequest.setPatient(samplePatient); // Link the patient
        sampleRequest.setStatus(RequestStatus.PatientRequestStatus.PENDING_VERIFICATION.getValue()); // Set initial status
        sampleRequest.setRequiredOrganType(OrganType.KIDNEY); // Example required organ
        sampleRequest.setMedicalUrgencyLevel(MedicalUrgencyLevel.MEDIUM); // Example urgency level
        
    

        // Add the PatientRequest to the system's PatientRequestDirectory
        system.getPatientRequestDirectory().addPatientRequest(sampleRequest);
    }

    // This method configures the entire ecosystem with some default enterprises, organizations and users
    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        // Setting up a new network for the US region
        Network worldCordNetwork = system.createAndAddNetwork();
        worldCordNetwork.setName("OrganLink Heroes");
        worldCordNetwork.setCountry("US");

        Enterprise thirdParty = worldCordNetwork.getEnterpriseDirectory().createAndAddEnterprise("US Third Party", Enterprise.EnterpriseType.ThirdParty);
        Enterprise government = worldCordNetwork.getEnterpriseDirectory().createAndAddEnterprise("Government Agency", Enterprise.EnterpriseType.Government);
        Enterprise logistics = worldCordNetwork.getEnterpriseDirectory().createAndAddEnterprise("Logistics", Enterprise.EnterpriseType.Logistics);
        Enterprise hospital = worldCordNetwork.getEnterpriseDirectory().createAndAddEnterprise("Hospitals", Enterprise.EnterpriseType.Hospital);
        Enterprise laboratory = worldCordNetwork.getEnterpriseDirectory().createAndAddEnterprise("Laboratories", Enterprise.EnterpriseType.Laboratory);
        Enterprise transplantCenter = worldCordNetwork.getEnterpriseDirectory().createAndAddEnterprise("Transplant Center", Enterprise.EnterpriseType.TransplantCenter);

        Employee officeAdminEmployee = thirdParty.getEmployeeDirectory().createEmployee("Office Administrator");
        UserAccount officeadmin = thirdParty.getUserAccountDirectory().createUserAccount("officeadmin", "password", officeAdminEmployee, new SystemAdminRole());

        Employee governmentAdminEmployee = government.getEmployeeDirectory().createEmployee("Government Admin");
        UserAccount governmentAdmin = government.getUserAccountDirectory().createUserAccount("governmentadmin", "password", governmentAdminEmployee, new SystemAdminRole());

        Employee logisticsGuyEmployee = logistics.getEmployeeDirectory().createEmployee("Logistics Admin");
        UserAccount logisticsGuy = logistics.getUserAccountDirectory().createUserAccount("logisticsguy", "password", logisticsGuyEmployee, new SystemAdminRole());

        Employee hospitalAdminEmployee = hospital.getEmployeeDirectory().createEmployee("Hospital Admin");
        UserAccount hospitalAdmin = hospital.getUserAccountDirectory().createUserAccount("hospitaladmin", "password", hospitalAdminEmployee, new SystemAdminRole());

        Employee labAdminEmployee = laboratory.getEmployeeDirectory().createEmployee("Lab Admin");
        UserAccount labAdmin = laboratory.getUserAccountDirectory().createUserAccount("labadmin", "password", labAdminEmployee, new SystemAdminRole());
        
        Employee transplantCenterAdminEmployee = transplantCenter.getEmployeeDirectory().createEmployee("Transplant Center Admin");
        UserAccount transplantCenterAdmin = transplantCenter.getUserAccountDirectory().createUserAccount("transplantadmin", "password", transplantCenterAdminEmployee, new SystemAdminRole());

        Organization thirdPartyOrg = thirdParty.getOrganizationDirectory().createOrganization(Organization.Type.ThirdParty, "US Third Party Organization");
        Organization governmentOrg = government.getOrganizationDirectory().createOrganization(Organization.Type.Government, "Government Organization");
        Organization logisticsOrg = logistics.getOrganizationDirectory().createOrganization(Organization.Type.Logistics, "Logistics Organization");
        Organization hospitalOrg = hospital.getOrganizationDirectory().createOrganization(Organization.Type.Hospital, "Hospitals Organization");
        Organization laboratoryOrg = laboratory.getOrganizationDirectory().createOrganization(Organization.Type.Laboratory, "Laboratories Organization");
        Organization transplantClinicOrg = transplantCenter.getOrganizationDirectory().createOrganization(Organization.Type.TransplantClinic, "Transplant Clinic Organization");
        Organization caseManagerOrg = thirdParty.getOrganizationDirectory().createOrganization(Organization.Type.CaseManager, "Case Manager Organization");

        Employee thirdPartyEmployee = caseManagerOrg.getEmployeeDirectory().createEmployee("Case Manager");
        UserAccount caseManager = caseManagerOrg.getUserAccountDirectory().createUserAccount("casemanager", "password", thirdPartyEmployee, new CaseManagerRole());

        Employee governmentEmployee = governmentOrg.getEmployeeDirectory().createEmployee("Government Agent");
        UserAccount govAgent = governmentOrg.getUserAccountDirectory().createUserAccount("governmentagent", "password", governmentEmployee, new GovernmentAgentRole());

        Employee logisticsEmployee = logisticsOrg.getEmployeeDirectory().createEmployee("Logistics Officer");
        UserAccount logisticsOfficer = logisticsOrg.getUserAccountDirectory().createUserAccount("logisticsofficer", "password", logisticsEmployee, new LogisticsOfficerRole());

        Employee hospitalEmployee = hospitalOrg.getEmployeeDirectory().createEmployee("Hospital Officer");
        UserAccount hospitalStaff = hospitalOrg.getUserAccountDirectory().createUserAccount("hospitaluser", "password", hospitalEmployee, new HospitalOfficerRole());

        Employee laboratoryEmployee = laboratoryOrg.getEmployeeDirectory().createEmployee("Lab Technician");
        UserAccount labEmployee = laboratoryOrg.getUserAccountDirectory().createUserAccount("labemployee", "password", laboratoryEmployee, new LabTechnicianRole());
        
        Employee transplantCoordinatorEmployee = transplantClinicOrg.getEmployeeDirectory().createEmployee("Transplant Coordinator");
        UserAccount transplantCoordinator = transplantClinicOrg.getUserAccountDirectory().createUserAccount("transplantcoordinator", "password", transplantCoordinatorEmployee, new Business.Role.TransplantCoordinatorRole());

        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());

        addSampleRequestData(system); // Uncommented
        return system;
    }
}
