/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel; // Added import
import userinterface.CustomerRole.PickCustomerActionJPanel;

/**
 *
 * @author User
 */
public class DonorRole extends Role {

     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, 
                                 UserAccount account, 
                                 Organization organization, 
                                 Enterprise enterprise, 
                                 EcoSystem business,
                                 Network network) {
        // 登入後返回 PickCustomerActionJPanel（Donor 的選單頁面）
        return new PickCustomerActionJPanel(business, userProcessContainer);
        /*
    System.out.println("=== DonorRole.createWorkArea() 被調用 ===");
    PickCustomerActionJPanel panel = new PickCustomerActionJPanel(business, userProcessContainer);
    System.out.println("返回的 panel: " + panel);
    System.out.println("Panel size: " + panel.getSize());
    System.out.println("Panel preferred size: " + panel.getPreferredSize());
    return panel;
    */
    }
    @Override
    public String toString() {
        return "Donor";
    }
}
