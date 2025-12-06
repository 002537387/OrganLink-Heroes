/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.BloodTypes.PersonBloodTypes;
import Business.DB4OUtil.DB4OUtil;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Ing-Ruei
 */
public abstract class Organization {

    // Declare instance variables for organization details
    private int organizationID;
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private static int counter = 0;
    private Type type; // New member variable for Organization Type

    // Enum to define different types of organizations
    public enum Type {
        Admin("Admin Organization"),
        System("System Organization"), // Added System Organization type
        Government("Government Agency Organization"),
        ThirdParty("ThirdParty Organization"),
        Laboratory("Laboratory Organization"),
        Logistics("Logistics Organization"),
        Hospital("Hospital Organization"),
        TransplantClinic("Transplant Clinic Organization"),
        CaseManager("Case Manager Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        // Helper method to get Type from its string value
        public static Type fromValue(String value) {
            for (Type type : Type.values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown Organization Type value: " + value);
        }
    }

    // Constructor to initialize the organization with name and directory
    public Organization(String name, String typeString) {
        this.name = name; // 'name' now stores the instance-specific name
        this.type = Type.fromValue(typeString); // Convert typeString to Type enum using helper
        workQueue = new WorkQueue();  // Initialize work queue
        System.out.println("initialise work queue");
        employeeDirectory = new EmployeeDirectory();  // Initialize employee directory
        userAccountDirectory = new UserAccountDirectory();  // Initialize user account directory
        organizationID = counter;  // Set organization ID
        ++counter;  // Increment counter for next organization ID
    }

    // Abstract method to get supported roles (to be implemented in subclasses)
    public abstract ArrayList<Role> getSupportedRole();

    // Getter methods
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return name;
    }
    
    // New getter for Type enum
    public Type getType() {
        return type;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    // Override toString to return the organization's name
    @Override
    public String toString() {
        return name;
    }
}
