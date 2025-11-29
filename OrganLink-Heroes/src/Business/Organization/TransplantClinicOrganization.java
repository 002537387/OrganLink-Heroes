/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.Role;
import Business.Role.TransplantCoordinatorRole;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TransplantClinicOrganization extends Organization {

    // Constructor to initialize TransplantClinicOrganization with a name and parent OrganizationDirectory
    public TransplantClinicOrganization(String name, OrganizationDirectory parent) {
        super(name == null ? Organization.Type.TransplantClinic.getValue() : name, parent, Organization.Type.TransplantClinic.getValue());
    }

    // Overridden method to return supported roles for TransplantClinicOrganization
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        roles.add(new TransplantCoordinatorRole());
        return roles;
    }
}
