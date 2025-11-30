/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HospitalOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ing-Ruei
 */
public class HospitalOrganization extends Organization {

    // Constructor to initialize HospitalOrganization with a name and parent OrganizationDirectory
    public HospitalOrganization(String name, OrganizationDirectory parent) {
        super(name == null ? Organization.Type.Hospital.getValue() : name, parent, Organization.Type.Hospital.getValue());
    }

    // Overridden method to return supported roles for HospitalOrganization
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HospitalOfficerRole());
        return roles;
    }
}
