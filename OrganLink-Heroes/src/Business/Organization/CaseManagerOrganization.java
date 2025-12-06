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
 * @author raunak
 */
public class CaseManagerOrganization extends Organization {

    public CaseManagerOrganization() {
        super(Organization.Type.CaseManager.getValue(), Organization.Type.CaseManager.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CaseManagerRole());
        return roles;
    }

}
