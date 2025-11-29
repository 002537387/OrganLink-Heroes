/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ThirdPartyOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.CaseManagerRole.CaseManagerWorkAreaJPanel;

/**
 *
 * @author Ing-Ruei
 */
public class CaseManagerRole extends Role {

    // Creates the work area for the case manager, returning the appropriate JPanel
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        // Return the CaseManagerWorkAreaJPanel with necessary parameters
        return new CaseManagerWorkAreaJPanel(account, (ThirdPartyOrganization) organization, enterprise, business, network);
    }
}
