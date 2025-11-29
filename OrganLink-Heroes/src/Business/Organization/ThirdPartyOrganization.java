/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CaseManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ing-Ruei
 */
public class ThirdPartyOrganization extends Organization {

    // Constructor for ThirdPartyOrganization, initializes with the given name or default to "ThirdParty"
    public ThirdPartyOrganization(String name, OrganizationDirectory parent) {
        super(name == null ? Organization.Type.ThirdParty.getValue() : name, parent, Organization.Type.ThirdParty.getValue());
    }

    // Returns the list of roles supported by the HeadquarterOrganization
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CaseManagerRole()); // Adds CaseManagerRole to the list of roles
        return roles;
    }
}

