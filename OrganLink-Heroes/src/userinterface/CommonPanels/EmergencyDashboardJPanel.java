package userinterface.CommonPanels;

import Business.EcoSystem;
import Business.Emergency.Emergency;
import Business.Emergency.EmergencyLog;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class EmergencyDashboardJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount currentUser;

    // Constructor 1: 三參數版本
    public EmergencyDashboardJPanel(JPanel userProcessContainer, EcoSystem business, UserAccount currentUser) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.currentUser = currentUser;
        
        populateEmergencyTable();
    }
    
    // Constructor 2: 兩參數版本（兼容舊的呼叫方式）
    public EmergencyDashboardJPanel(JPanel userProcessContainer, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        // 使用系統管理員帳號作為預設
        this.currentUser = business.getUserAccountDirectory().getUserAccountList().get(0);
        
        populateEmergencyTable();
    }
    
    public void populateEmergencyTable() {
        DefaultTableModel model = (DefaultTableModel) tblEmergencyRequests.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        for (Emergency emergency : business.getEmergencyDirectory().getAllEmergencies()) {
            Object[] row = new Object[5];
            row[0] = emergency.getEmergencyID();
            row[1] = emergency.getEmergencyType();
            row[2] = emergency.getReportedBy().getUsername();
            row[3] = emergency.getStatus();
            row[4] = dateFormat.format(emergency.getCreatedTimestamp());
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmergencyRequests = new javax.swing.JTable();
        btnDetectIssue = new javax.swing.JButton();
        btnEscalateAlert = new javax.swing.JButton();
        btnOpenCommunication = new javax.swing.JButton();
        btnDecideContingency = new javax.swing.JButton();
        btnLogDecision = new javax.swing.JButton();
        btnCompleteReview = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnEmergencyAlert = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 24));
        lblTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Emergency Dashboard");

        tblEmergencyRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emergency ID", "Type", "Reported By", "Status", "Trigger Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmergencyRequests);

        btnDetectIssue.setBackground(new java.awt.Color(0, 102, 102));
        btnDetectIssue.setFont(new java.awt.Font("Arial", 1, 14));
        btnDetectIssue.setForeground(new java.awt.Color(204, 255, 204));
        btnDetectIssue.setText("Detect New Issue");
        btnDetectIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetectIssueActionPerformed(evt);
            }
        });

        btnEscalateAlert.setBackground(new java.awt.Color(0, 102, 102));
        btnEscalateAlert.setFont(new java.awt.Font("Arial", 1, 14));
        btnEscalateAlert.setForeground(new java.awt.Color(204, 255, 204));
        btnEscalateAlert.setText("Escalate Alert");
        btnEscalateAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscalateAlertActionPerformed(evt);
            }
        });

        btnOpenCommunication.setBackground(new java.awt.Color(0, 102, 102));
        btnOpenCommunication.setFont(new java.awt.Font("Arial", 1, 14));
        btnOpenCommunication.setForeground(new java.awt.Color(204, 255, 204));
        btnOpenCommunication.setText("Open Communication Channel");
        btnOpenCommunication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenCommunicationActionPerformed(evt);
            }
        });

        btnDecideContingency.setBackground(new java.awt.Color(0, 102, 102));
        btnDecideContingency.setFont(new java.awt.Font("Arial", 1, 14));
        btnDecideContingency.setForeground(new java.awt.Color(204, 255, 204));
        btnDecideContingency.setText("Decide Contingency Action");
        btnDecideContingency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecideContingencyActionPerformed(evt);
            }
        });

        btnLogDecision.setBackground(new java.awt.Color(0, 102, 102));
        btnLogDecision.setFont(new java.awt.Font("Arial", 1, 14));
        btnLogDecision.setForeground(new java.awt.Color(204, 255, 204));
        btnLogDecision.setText("Log Decision");
        btnLogDecision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogDecisionActionPerformed(evt);
            }
        });

        btnCompleteReview.setBackground(new java.awt.Color(0, 102, 102));
        btnCompleteReview.setFont(new java.awt.Font("Arial", 1, 14));
        btnCompleteReview.setForeground(new java.awt.Color(204, 255, 204));
        btnCompleteReview.setText("Complete Post-Incident Review");
        btnCompleteReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteReviewActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 102, 102));
        btnBack.setFont(new java.awt.Font("Arial", 1, 14));
        btnBack.setForeground(new java.awt.Color(204, 255, 204));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnEmergencyAlert.setBackground(new java.awt.Color(204, 0, 0));
        btnEmergencyAlert.setFont(new java.awt.Font("Arial", 1, 14));
        btnEmergencyAlert.setForeground(new java.awt.Color(255, 255, 255));
        btnEmergencyAlert.setText("Emergency Alert");
        btnEmergencyAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyAlertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnDetectIssue)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEscalateAlert)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnOpenCommunication)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDecideContingency)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLogDecision)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCompleteReview))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmergencyAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmergencyAlert)
                .addGap(18, 18, 18)
                .addComponent(lblTitle)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetectIssue)
                    .addComponent(btnEscalateAlert)
                    .addComponent(btnOpenCommunication)
                    .addComponent(btnDecideContingency)
                    .addComponent(btnLogDecision)
                    .addComponent(btnCompleteReview))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEmergencyAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyAlertActionPerformed
        // Step 2: 點擊緊急警報按鈕
        String[] types = {"Transport Delay", "Organ Quality Issue", "Patient Complication", "Other"};
        String type = (String) JOptionPane.showInputDialog(
            this,
            "Select Emergency Type:",
            "Emergency Alert",
            JOptionPane.QUESTION_MESSAGE,
            null,
            types,
            types[0]
        );
        
        if (type != null) {
            String description = JOptionPane.showInputDialog(this, "Enter detailed description of the emergency:");
            if (description != null && !description.trim().isEmpty()) {
                // Step 3: 系統自動化處理
                Emergency emergency = business.getEmergencyDirectory().createEmergency(type, description, currentUser);
                emergency.addAuditLog("Notifications Sent", currentUser);
                
                JOptionPane.showMessageDialog(this, 
                    "Emergency Alert Created!\n" +
                    "Emergency ID: " + emergency.getEmergencyID() + "\n" +
                    "All stakeholders have been notified.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                
                populateEmergencyTable();
            }
        }
    }//GEN-LAST:event_btnEmergencyAlertActionPerformed

    private void btnDetectIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetectIssueActionPerformed
        // Step 1: 偵測到問題（功能同 Emergency Alert）
        btnEmergencyAlertActionPerformed(evt);
    }//GEN-LAST:event_btnDetectIssueActionPerformed

    private void btnEscalateAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscalateAlertActionPerformed
        // Step 4: 緊急協調員啟動處理
        int selectedRow = tblEmergencyRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an emergency to escalate.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String emergencyID = (String) tblEmergencyRequests.getValueAt(selectedRow, 0);
        Emergency emergency = business.getEmergencyDirectory().findEmergencyByID(emergencyID);
        
        if (emergency != null) {
            emergency.setStatus("In Progress");
            emergency.addAuditLog("Alert Escalated to Emergency Coordinator", currentUser);
            
            JOptionPane.showMessageDialog(this, 
                "Alert escalated for Emergency: " + emergencyID + "\n" +
                "Video conference link has been sent to all stakeholders.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
            
            populateEmergencyTable();
        }
    }//GEN-LAST:event_btnEscalateAlertActionPerformed

    private void btnOpenCommunicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenCommunicationActionPerformed
        int selectedRow = tblEmergencyRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an emergency to open communication for.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String emergencyID = (String) tblEmergencyRequests.getValueAt(selectedRow, 0);
        Emergency emergency = business.getEmergencyDirectory().findEmergencyByID(emergencyID);
        
        if (emergency != null) {
            emergency.addAuditLog("Communication Channel Opened", currentUser);
            
            JOptionPane.showMessageDialog(this, 
                "Crisis Communication Channel Opened\n" +
                "Emergency: " + emergencyID + "\n" +
                "All stakeholders can now communicate in real-time.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
            
            populateEmergencyTable();
        }
    }//GEN-LAST:event_btnOpenCommunicationActionPerformed

    private void btnDecideContingencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecideContingencyActionPerformed
        // Step 5: 團隊決定應變措施
        int selectedRow = tblEmergencyRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an emergency to decide contingency action for.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String emergencyID = (String) tblEmergencyRequests.getValueAt(selectedRow, 0);
        Emergency emergency = business.getEmergencyDirectory().findEmergencyByID(emergencyID);
        
        if (emergency != null) {
            String[] options = {
                "Redirect organ to alternate recipient",
                "Arrange emergency transport",
                "Abort procedure with documentation"
            };
            
            String action = (String) JOptionPane.showInputDialog(
                this,
                "Select contingency action:",
                "Contingency Decision",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );
            
            if (action != null) {
                String details = JOptionPane.showInputDialog(this, "Enter additional details:");
                if (details != null) {
                    emergency.setResolution(action);
                    emergency.setResolutionDetails(details);
                    emergency.addAuditLog("Contingency Decision Made: " + action, currentUser);
                    
                    JOptionPane.showMessageDialog(this, 
                        "Contingency action decided for Emergency: " + emergencyID + "\n" +
                        "Action: " + action,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                    
                    populateEmergencyTable();
                }
            }
        }
    }//GEN-LAST:event_btnDecideContingencyActionPerformed

    private void btnLogDecisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogDecisionActionPerformed
        // Step 6: 記錄所有決策
        int selectedRow = tblEmergencyRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an emergency to log a decision for.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String emergencyID = (String) tblEmergencyRequests.getValueAt(selectedRow, 0);
        Emergency emergency = business.getEmergencyDirectory().findEmergencyByID(emergencyID);
        
        if (emergency != null) {
            String decisionLog = JOptionPane.showInputDialog(this, "Enter decision details to log:");
            if (decisionLog != null && !decisionLog.trim().isEmpty()) {
                emergency.addAuditLog("Decision Logged", currentUser, decisionLog);
                
                // 顯示 Audit Trail
                StringBuilder auditTrail = new StringBuilder("Audit Trail for " + emergencyID + ":\n\n");
                for (EmergencyLog log : emergency.getAuditTrail()) {
                    auditTrail.append(log.toString()).append("\n");
                }
                
                JOptionPane.showMessageDialog(this, auditTrail.toString(), "Audit Trail", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLogDecisionActionPerformed

    private void btnCompleteReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteReviewActionPerformed
        // Step 7: 48小時內完成事後檢討報告
        int selectedRow = tblEmergencyRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an emergency to complete review for.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String emergencyID = (String) tblEmergencyRequests.getValueAt(selectedRow, 0);
        Emergency emergency = business.getEmergencyDirectory().findEmergencyByID(emergencyID);
        
        if (emergency != null) {
            String review = JOptionPane.showInputDialog(this, 
                "Enter Post-Incident Review:\n" +
                "- Incident summary\n" +
                "- Root cause analysis\n" +
                "- Recommendations");
            
            if (review != null && !review.trim().isEmpty()) {
                emergency.setPostIncidentReview(review);
                emergency.setPostIncidentReviewCompleted(true);
                emergency.setStatus("Closed");
                emergency.setResolvedTimestamp(new java.util.Date());
                emergency.addAuditLog("Post-Incident Review Completed", currentUser);
                
                JOptionPane.showMessageDialog(this, 
                    "Post-incident review completed for Emergency: " + emergencyID + "\n" +
                    "Status changed to: Closed",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                
                populateEmergencyTable();
            }
        }
    }//GEN-LAST:event_btnCompleteReviewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCompleteReview;
    private javax.swing.JButton btnDecideContingency;
    private javax.swing.JButton btnDetectIssue;
    private javax.swing.JButton btnEmergencyAlert;
    private javax.swing.JButton btnEscalateAlert;
    private javax.swing.JButton btnLogDecision;
    private javax.swing.JButton btnOpenCommunication;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEmergencyRequests;
    // End of variables declaration//GEN-END:variables
}