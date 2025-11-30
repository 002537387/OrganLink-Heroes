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
        
        lblWelcome.setText("Welcome Lab Technician " + account.getEmployee().getName());
    }

    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        btnManageTestRequests = new javax.swing.JButton();
        btnSubmitTestResults = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        lblWelcome.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(204, 255, 204));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome Lab Technician!");

        btnManageTestRequests.setBackground(new java.awt.Color(0, 102, 102));
        btnManageTestRequests.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnManageTestRequests.setForeground(new java.awt.Color(204, 255, 204));
        btnManageTestRequests.setText("Manage Test Requests");
        btnManageTestRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTestRequestsActionPerformed(evt);
            }
        });

        btnSubmitTestResults.setBackground(new java.awt.Color(0, 102, 102));
        btnSubmitTestResults.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSubmitTestResults.setForeground(new java.awt.Color(204, 255, 204));
        btnSubmitTestResults.setText("Submit Test Results");
        btnSubmitTestResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitTestResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmitTestResults, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageTestRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblWelcome)
                .addGap(80, 80, 80)
                .addComponent(btnManageTestRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmitTestResults, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageTestRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTestRequestsActionPerformed
        // TODO: Implement logic for managing test requests
    }//GEN-LAST:event_btnManageTestRequestsActionPerformed

    private void btnSubmitTestResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitTestResultsActionPerformed
        // TODO: Implement logic for submitting test results
    }//GEN-LAST:event_btnSubmitTestResultsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageTestRequests;
    private javax.swing.JButton btnSubmitTestResults;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
