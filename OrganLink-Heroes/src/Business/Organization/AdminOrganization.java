/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ing-Ruei
 */
public class AdminOrganization extends Organization {

    // Constructor to initialize the organization with type Admin
    public AdminOrganization(OrganizationDirectory parent) {
        super(Type.Admin.getValue(), Organization.Type.Admin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();

        // Adding the AdminRole to the list of supported roles
        roles.add(new AdminRole());

        return roles; // Returning the list of roles
    }
}
