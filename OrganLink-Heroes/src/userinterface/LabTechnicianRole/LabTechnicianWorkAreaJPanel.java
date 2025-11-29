/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabTechnicianRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.LaboratoryOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class LabTechnicianWorkAreaJPanel extends JPanel {
    
    private UserAccount userAccount;
    private LaboratoryOrganization laboratoryOrganization;
    private Enterprise enterprise;
    private EcoSystem system;
    private Network network;

    public LabTechnicianWorkAreaJPanel(UserAccount account, LaboratoryOrganization organization, Enterprise enterprise, EcoSystem business, Network network) {
        initComponents();
        this.userAccount = account;
        this.laboratoryOrganization = organization;
        this.enterprise = enterprise;
        this.system = business;
        this.network = network;
    }

    private void initComponents() {
        //Placeholder for UI components
    }
}
