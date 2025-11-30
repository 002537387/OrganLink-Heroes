/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ThirdPartyEnterprise extends Enterprise {

    // Constructor to initialize the ThirdPartyEnterprise with a name
    public ThirdPartyEnterprise(String name) {
        super(name, EnterpriseType.ThirdParty);
        this.addOrganizationType(Type.ThirdParty);
    }

    // Method to return supported roles (currently not implemented)
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null; // Returning null as there are no supported roles defined yet
    }
}
