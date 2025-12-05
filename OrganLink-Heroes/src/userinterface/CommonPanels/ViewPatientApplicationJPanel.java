package userinterface.CommonPanels;

import Business.BloodTypes.PersonBloodTypes;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.OrganTypes.OrganType;
import Business.Requests.PatientRequest;
import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Image;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPatientApplicationJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private JPanel userProcessContainer;
    PatientRequest patientRequest;

    public ViewPatientApplicationJPanel(EcoSystem system, PatientRequest patientRequest, JPanel userProcessContainer) {
        initComponents();
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.patientRequest = patientRequest;

        populateGenderComboBox();
        populateStateComboBox();
        populatebloodTypeComboBox();

        populatePatientRequestData();
        disableAllButton();

    }

    private void populateGenderComboBox() {
        genderJComboBox.addItem("Male");
        genderJComboBox.addItem("Female");
        genderJComboBox.addItem("Other");
    }

    private void populateStateComboBox() {
        // Add all states to the JComboBox using a loop
        String[] states = {
            "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
            "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
            "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
            "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
            "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
            "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
            "Wisconsin", "Wyoming"
        };

        for (String state : states) {
            stateJComboBox.addItem(state);
        }

    }

    private void disableAllButton() {

        uidText.setEnabled(false);
        nameText.setEnabled(false);
        dobDateField.setEnabled(false);
        ageText.setEnabled(false);
        emailText.setEnabled(false);
        contactText.setEnabled(false);
        genderJComboBox.setEnabled(false);

        OrganTypeComboBox.setEnabled(false);
        streetText.setEnabled(false);
        cityText.setEnabled(false);
        stateJComboBox.setEnabled(false);
        zipText.setEnabled(false);
        organTypeTextField.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        uidText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ageText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        streetText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cityText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        zipText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        contactText = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        dobDateField = new com.toedter.calendar.JDateChooser();
        btnBack = new javax.swing.JButton();
        stateJComboBox = new javax.swing.JComboBox();
        genderJComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        OrganTypeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        organTypeTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 685));
        setPreferredSize(new java.awt.Dimension(1280, 685));
        setRequestFocusEnabled(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel3.setText("Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        nameText.setBackground(new java.awt.Color(0, 153, 153));
        nameText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 180, -1));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 218, -1, -1));

        uidText.setBackground(new java.awt.Color(0, 153, 153));
        uidText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(uidText, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 180, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setText("DOB:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setText("Age:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, -1, -1));

        ageText.setBackground(new java.awt.Color(0, 153, 153));
        ageText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        ageText.setEnabled(false);
        add(ageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 180, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setText("Gender:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel9.setText("Blood Type:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, 20));

        streetText.setBackground(new java.awt.Color(0, 153, 153));
        streetText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(streetText, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 180, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel12.setText("Street address:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel13.setText("City:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        cityText.setBackground(new java.awt.Color(0, 153, 153));
        cityText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(cityText, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 180, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel14.setText("States:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel15.setText("ZipCode:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, -1, -1));

        zipText.setBackground(new java.awt.Color(0, 153, 153));
        zipText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(zipText, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 180, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel16.setText("Phone Number:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, -1, -1));

        contactText.setBackground(new java.awt.Color(0, 153, 153));
        contactText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(contactText, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 180, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel17.setText("Email:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        emailText.setBackground(new java.awt.Color(0, 153, 153));
        emailText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 180, -1));

        dobDateField.setBackground(new java.awt.Color(255, 255, 255));
        dobDateField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(dobDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 180, -1));

        btnBack.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 560, 120, 40));

        stateJComboBox.setBackground(new java.awt.Color(0, 153, 153));
        stateJComboBox.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        stateJComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(stateJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 180, -1));

        genderJComboBox.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        genderJComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(genderJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 180, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(926, 70));

        jLabel25.setBackground(new java.awt.Color(0, 102, 102));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 255, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText(" Patient Application Form ");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 410, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1690, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 1140, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel23.setText("Address Details");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        OrganTypeComboBox.setBackground(new java.awt.Color(0, 153, 153));
        OrganTypeComboBox.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(OrganTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 180, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel10.setText("PIN:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 50, -1));
        
        jLabel11.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel11.setText("Organ Type:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, -1, -1));
        
        organTypeTextField.setBackground(new java.awt.Color(0, 153, 153));
        organTypeTextField.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add(organTypeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 180, -1));
        
    }// </editor-fold>                        

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        goBack();
    }                                       

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        Date dob = dobDateField.getDate();
        ageText.setText((String.valueOf(new Date().getYear() - dob.getYear())));
    }                                 
    
    private void populatebloodTypeComboBox() {
         OrganTypeComboBox.removeAllItems();
         for (OrganType organType : OrganType.values()) {
            OrganTypeComboBox.addItem(organType.toString());
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField ageText;
    private javax.swing.JComboBox<String> OrganTypeComboBox;
    private javax.swing.JTextField cityText;
    private javax.swing.JTextField contactText;
    private com.toedter.calendar.JDateChooser dobDateField;
    private javax.swing.JTextField emailText;
    private javax.swing.JComboBox genderJComboBox;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameText;
    private javax.swing.JComboBox stateJComboBox;
    private javax.swing.JTextField streetText;
    private javax.swing.JTextField uidText;
    private javax.swing.JTextField zipText;
    private javax.swing.JTextField organTypeTextField;
    // End of variables declaration                   

    private void goBack() {
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }

    private void populatePatientRequestData() {
        
        uidText.setText(patientRequest.getPatient().getReceiverID());
        nameText.setText(patientRequest.getPatient().getName());
        dobDateField.setDate(patientRequest.getPatient().getDob());
        ageText.setText(String.valueOf(patientRequest.getPatient().getAge()));
        genderJComboBox.setSelectedItem(patientRequest.getPatient().getGender());
        streetText.setText(patientRequest.getPatient().getStreetAddress());
        cityText.setText(patientRequest.getPatient().getCity());
        stateJComboBox.setSelectedItem(patientRequest.getPatient().getState());
        zipText.setText(String.valueOf(patientRequest.getPatient().getZipCode()));
        contactText.setText(String.valueOf(patientRequest.getPatient().getContact()));
        emailText.setText(patientRequest.getPatient().getEmailID());
        OrganTypeComboBox.setSelectedItem(patientRequest.getRequiredOrganType());
        organTypeTextField.setText(patientRequest.getRequiredOrganType().toString());
        
    }

}
