/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.RecipientRole;

import Business.BloodTypes.PersonBloodTypes;
import Business.BloodTypes.PersonBloodTypes.BloodType;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.OrganTypes.OrganType;
import Business.People.Donor;
import Business.Requests.DonorRequest;
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

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.People.Patient;
import Business.Requests.PatientRequest;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;


/**
 *
 * @author wanyuchiu
 */
public class PatientsRegistrationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientsRegistrationJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network;
    
    private boolean emailValid;
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private byte[] tempdP;
    private ButtonGroup radioGroup1;
    private ButtonGroup radioGroup2;
    private ButtonGroup radioGroup3;
    private ButtonGroup radioGroup4;
    private JPanel customerProcessContainer;
    
    public PatientsRegistrationJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        
        this.radioGroup1 = new ButtonGroup();
        this.radioGroup2 = new ButtonGroup();
        this.radioGroup3 = new ButtonGroup();
        this.radioGroup4 = new ButtonGroup();
        
        // ButtonGroup radioGroup1 = new ButtonGroup();
        radioGroup1.add(btnYesQ1);
        radioGroup1.add(btnNoQ1);

        // ButtonGroup radioGroup2 = new ButtonGroup();
        radioGroup2.add(btnYesQ2);
        radioGroup2.add(btnNoQ2);

        // ButtonGroup radioGroup3 = new ButtonGroup();
        // ButtonGroup radioGroup4 = new ButtonGroup();
        radioGroup4.add(btnYesQ4);
        radioGroup4.add(btnNoQ4);

        populateGenderComboBox();
        populateStateComboBox();
        populateOrganTypeComboBox();

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
                "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
                "North Carolina",
                "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
                "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
                "Wisconsin", "Wyoming"
        };

        for (String state : states) {
            stateJComboBox.addItem(state);
        }

    }

    public static boolean phoneNumberValidator(String contact) {
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{10}$";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(contact);
        return matcher.matches();
    }

    public static boolean zipCodeValidator(String zip) {
        Pattern pattern;
        Matcher matcher;
        String zip_pattern = "^[0-9]{5}$";
        pattern = Pattern.compile(zip_pattern);
        matcher = pattern.matcher(zip);
        return matcher.matches();
    }

    public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private void disableAllButton() {

        uidText.setEnabled(false);
        nameText.setEnabled(false);
        dobDateField.setEnabled(false);
        ageText.setEnabled(false);
        emailText.setEnabled(false);
        contactText.setEnabled(false);
        genderJComboBox.setEnabled(false);

        // bloodTypesTextField.setEnabled(false);
        OrganTypeComboBox.setEnabled(false);
        streetText.setEnabled(false);
        cityText.setEnabled(false);
        stateJComboBox.setEnabled(false);
        zipText.setEnabled(false);
        btnYesQ1.setEnabled(false);
        btnNoQ1.setEnabled(false);
        btnYesQ2.setEnabled(false);
        btnNoQ2.setEnabled(false);
        btnYesQ4.setEnabled(false);
        btnNoQ4.setEnabled(false);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
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
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnYesQ2 = new javax.swing.JRadioButton();
        btnNoQ2 = new javax.swing.JRadioButton();
        btnNoQ1 = new javax.swing.JRadioButton();
        btnYesQ1 = new javax.swing.JRadioButton();
        btnNoQ4 = new javax.swing.JRadioButton();
        btnYesQ4 = new javax.swing.JRadioButton();
        dobDateField = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        stateJComboBox = new javax.swing.JComboBox();
        genderJComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        OrganTypeComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));

        lblName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 255, 204));
        lblName.setText("Name:");

        nameText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        uidText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("DOO:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Age:");

        ageText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        ageText.setEnabled(false);
        ageText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ageTextMouseClicked(evt);
            }
        });
        ageText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ageTextKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Gender:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 204));
        jLabel9.setText("Organ Type:");

        streetText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 204));
        jLabel12.setText("Street address:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 255, 204));
        jLabel13.setText("City:");

        cityText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 255, 204));
        jLabel14.setText("States:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 204));
        jLabel15.setText("ZipCode:");

        zipText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 255, 204));
        jLabel16.setText("Phone Number:");

        contactText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 204));
        jLabel17.setText("Email:");

        emailText.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        emailText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailTextMouseClicked(evt);
            }
        });
        emailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailTextuEmailKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel19.setText("Do you have any chronic conditions?");

        jLabel20.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel20.setText("Are you currently feeling unwell?");

        jLabel22.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel22.setText("Do you have any contagious diseases?");

        btnSubmit.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnYesQ2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnYesQ2.setText("Yes");

        btnNoQ2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNoQ2.setText("No");

        btnNoQ1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNoQ1.setText("No");
        btnNoQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoQ1ActionPerformed(evt);
            }
        });

        btnYesQ1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnYesQ1.setText("Yes");

        btnNoQ4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNoQ4.setText("No");

        btnYesQ4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnYesQ4.setText("Yes");

        dobDateField.setBackground(new java.awt.Color(255, 255, 255));
        dobDateField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dobDateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dobDateFieldFocusLost(evt);
            }
        });
        dobDateField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dobDateFieldMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dobDateFieldMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dobDateFieldagePop(evt);
            }
        });
        dobDateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dobDateFielduDobKeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        stateJComboBox.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        stateJComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        stateJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateJComboBoxActionPerformed(evt);
            }
        });

        genderJComboBox.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        genderJComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        genderJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderJComboBoxActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(926, 70));

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 255, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText(" Recipient Application Form ");
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

        jLabel23.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 255, 204));
        jLabel23.setText("Address Details");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel24.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 255, 204));
        jLabel24.setText("Elibility Requirements:");

        OrganTypeComboBox.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        OrganTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrganTypeComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 204));
        jLabel10.setText("PIN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1690, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(lblName)
                            .addGap(39, 39, 39)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(uidText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(jLabel6)
                            .addGap(47, 47, 47)
                            .addComponent(dobDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(jLabel7)
                            .addGap(146, 146, 146)
                            .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(jLabel17)
                            .addGap(39, 39, 39)
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(jLabel16)
                            .addGap(42, 42, 42)
                            .addComponent(contactText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(jLabel8)
                            .addGap(23, 23, 23)
                            .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(jLabel9)
                            .addGap(75, 75, 75)
                            .addComponent(OrganTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel13)
                                    .addGap(105, 105, 105)
                                    .addComponent(streetText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(100, 100, 100)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel24)
                                    .addGap(171, 171, 171)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel14))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(560, 560, 560)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(230, 230, 230)
                                    .addComponent(zipText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel12))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(890, 890, 890)
                                    .addComponent(btnYesQ1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(960, 960, 960)
                                    .addComponent(btnNoQ1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel15))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(560, 560, 560)
                                    .addComponent(jLabel19))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(890, 890, 890)
                                    .addComponent(btnYesQ4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(230, 230, 230)
                                    .addComponent(cityText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(230, 230, 230)
                                    .addComponent(stateJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(960, 960, 960)
                                    .addComponent(btnNoQ4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(180, 180, 180)
                                    .addComponent(jLabel23))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(890, 890, 890)
                                    .addComponent(btnYesQ2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(960, 960, 960)
                                    .addComponent(btnNoQ2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(560, 560, 560)
                                    .addComponent(jLabel20))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(760, 760, 760)
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 11, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(lblName))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel10))
                        .addComponent(uidText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(dobDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(contactText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(OrganTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(jLabel13))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(streetText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel24))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(240, 240, 240)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jLabel14))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addComponent(zipText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel12))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(btnYesQ1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(btnNoQ1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addComponent(jLabel15))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jLabel19))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(btnYesQ4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(cityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(stateJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(btnNoQ4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel23))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(btnYesQ2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(btnNoQ2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(jLabel20))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(240, 240, 240)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 11, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void ageTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageTextMouseClicked
        // TODO add your handling code here:
          // TODO add your handling code here:
        Date dob = dobDateField.getDate();
        // System.out.println(dob.getYear());
        ageText.setText((String.valueOf(new Date().getYear() - dob.getYear())));
    }//GEN-LAST:event_ageTextMouseClicked

    private void ageTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTextKeyPressed

    private void emailTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTextMouseClicked
        // TODO add your handling code here:
        Date dob = dobDateField.getDate();
        // System.out.println(dob.getYear());
        ageText.setText((String.valueOf(new Date().getYear() - dob.getYear())));
    }//GEN-LAST:event_emailTextMouseClicked

    private void emailTextuEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTextuEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextuEmailKeyTyped

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
         // Create a Patient object
       // Create a Patient object
    Patient patient = new Patient();

    // Create a PatientRequest
    PatientRequest patientRequest = new PatientRequest();
    patientRequest.setPatient(patient); // Link the patient to the request

    Date currentDate = new Date();
    
    // Validation checks with red border highlighting
    if (stateJComboBox.getSelectedItem().equals("")) {
        stateJComboBox.setBorder(BorderFactory.createLineBorder(Color.RED));
        stateJComboBox.setForeground(Color.red);
    }
    if (genderJComboBox.getSelectedItem().equals("")) {
        genderJComboBox.setBorder(BorderFactory.createLineBorder(Color.RED));
        genderJComboBox.setForeground(Color.red);
    }
    if (OrganTypeComboBox.getSelectedItem().equals("")) {
        OrganTypeComboBox.setBorder(BorderFactory.createLineBorder(Color.RED));
        OrganTypeComboBox.setForeground(Color.red);
    }
    if (nameText.getText().isEmpty()) {
        nameText.setBorder(BorderFactory.createLineBorder(Color.RED));
        nameText.setForeground(Color.red);
    }
    if (uidText.getText().isEmpty()) {
        uidText.setBorder(BorderFactory.createLineBorder(Color.RED));
        uidText.setForeground(Color.red);
    }
    if (emailText.getText().isEmpty()) {
        emailText.setBorder(BorderFactory.createLineBorder(Color.RED));
        emailText.setForeground(Color.red);
    }
    if (contactText.getText().isEmpty()) {
        contactText.setBorder(BorderFactory.createLineBorder(Color.RED));
        contactText.setForeground(Color.red);
    }
    if (zipText.getText().isEmpty()) {
        zipText.setBorder(BorderFactory.createLineBorder(Color.RED));
        zipText.setForeground(Color.red);
    }
    if (cityText.getText().isEmpty()) {
        cityText.setBorder(BorderFactory.createLineBorder(Color.RED));
        cityText.setForeground(Color.red);
    }
    if (streetText.getText().isEmpty()) {
        streetText.setBorder(BorderFactory.createLineBorder(Color.RED));
        streetText.setForeground(Color.red);
    }
    if (dobDateField.getDate() == null) {
        dobDateField.setBorder(BorderFactory.createLineBorder(Color.RED));
        dobDateField.setForeground(Color.red);
    }
    if (ageText.getText().isEmpty()) {
        ageText.setBorder(BorderFactory.createLineBorder(Color.RED));
        ageText.setForeground(Color.red);
    }
    
    // Check if any eligibility question is "Yes"
    if (btnYesQ1.isSelected() || btnYesQ2.isSelected() || btnYesQ4.isSelected()) {
        JOptionPane.showMessageDialog(null, 
            new JLabel("You are currently not an eligible recipient."), 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if all mandatory fields are filled
    if (nameText.getText().isEmpty() || emailText.getText().isEmpty() || cityText.getText().isEmpty()
            || contactText.getText().isEmpty() || zipText.getText().isEmpty() || streetText.getText().isEmpty()
            || uidText.getText().isEmpty()
            || dobDateField.getDate() == null
            || ageText.getText().isEmpty()
            || String.valueOf(genderJComboBox.getSelectedItem()).equals("")
            || String.valueOf(OrganTypeComboBox.getSelectedItem()).equals("")
            || String.valueOf(stateJComboBox.getSelectedItem()).equals("")) {
        JOptionPane.showMessageDialog(null, 
            new JLabel("<html><b>All fields are mandatory!</b></html>"), 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!btnNoQ1.isSelected() && !btnYesQ1.isSelected()
            || !btnNoQ2.isSelected() && !btnYesQ2.isSelected()
            || !btnNoQ4.isSelected() && !btnYesQ4.isSelected()) {
        JOptionPane.showMessageDialog(null, 
            new JLabel("<html><b>All fields are mandatory!</b></html>"), 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!isAlpha(nameText.getText())) {
        nameText.setBorder(BorderFactory.createLineBorder(Color.RED));
        nameText.setForeground(Color.red);
        JOptionPane.showMessageDialog(null, 
            new JLabel("<html><b>Name must contain only alphabets!</b></html>"),
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!isAlpha(cityText.getText())) {
        cityText.setBorder(BorderFactory.createLineBorder(Color.RED));
        cityText.setForeground(Color.red);
        JOptionPane.showMessageDialog(null,
            new JLabel("<html><b>City name must contain only alphabets!</b></html>"), 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!phoneNumberValidator(contactText.getText())) {
        JOptionPane.showMessageDialog(null, 
            new JLabel("<html><b>Contact Number should be 10 digits!</b></html>"),
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!zipCodeValidator(zipText.getText())) {
        JOptionPane.showMessageDialog(null, 
            new JLabel("<html><b>Zip should be 5 digits!</b></html>"), 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!emailValidator(emailText.getText())) {
        JOptionPane.showMessageDialog(null, 
            new JLabel("<html><b>Email ID must be in correct format!</b></html>"),
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (dobDateField.getDate().after(currentDate)) {
        JOptionPane.showMessageDialog(null, 
            new JLabel("<html><b>Date of birth cannot be in the future!</b></html>"),
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        // Confirm submission
        int n = JOptionPane.showConfirmDialog(null,
            new JLabel("<html><b>Would you like to submit the form?</b></html>"),
            "CONFIRMATION REQUIRED", JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            try {
                // Set patient data
                patient.setReceiverID(uidText.getText());
                patient.setName(nameText.getText());
                patient.setDob(dobDateField.getDate());
                patient.setAge(Integer.parseInt(ageText.getText()));
                patient.setGender((String) genderJComboBox.getSelectedItem());
                patient.setStreetAddress(streetText.getText());
                patient.setCity(cityText.getText());
                patient.setState((String) stateJComboBox.getSelectedItem());
                patient.setZipCode(Integer.parseInt(zipText.getText()));
                patient.setContact(Long.parseLong(contactText.getText()));
                patient.setEmailID(emailText.getText());
                patient.setdP(tempdP);

                // Set health questions
                if (btnYesQ1.isSelected()) {
                    patient.setBrainInjury(true); 
                } else if (btnNoQ1.isSelected()) {
                    patient.setBrainInjury(false);
                }

                if (btnYesQ2.isSelected()) {
                    patient.setDiabitiesBP(true);
                } else if (btnNoQ2.isSelected()) {
                    patient.setDiabitiesBP(false);
                }

                if (btnYesQ4.isSelected()) {
                    patient.setBreathingProb(true);
                } else if (btnNoQ4.isSelected()) {
                    patient.setBreathingProb(false);
                } 
                
                // Set organ type for patient request
                String selectedOrganTypeName = (String) OrganTypeComboBox.getSelectedItem();
                if (selectedOrganTypeName != null && !selectedOrganTypeName.isEmpty()) {
                    OrganType selectedOrganType = OrganType.valueOf(selectedOrganTypeName.toUpperCase());
                    patientRequest.setRequiredOrganType(selectedOrganType);
                }
               
                // Set request status
                patientRequest.setStatus("New Request");
                
                // Add patient and request to directories
                business.getPatientDirectory().addPatient(patient);
                business.getPatientRequestDirectory().addPatientRequest(patientRequest);
                
                // Save to database
                dB4OUtil.storeSystem(business);
                
                // Show success message
                JOptionPane.showMessageDialog(null,
                    new JLabel("<html><b>Registration successful! Your request has been submitted.</b></html>"));
                
                // Disable submit button
                btnSubmit.setEnabled(false);
                
                // Return to RecipientWorkArea
                userProcessContainer.remove(this);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.previous(userProcessContainer);
                
                //returnToCustomerWorkArea();
                // disableAllButton();
             } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                    new JLabel("<html><b>Error: " + e.getMessage() + "</b></html>"),
                    "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
      }
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnNoQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoQ1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNoQ1ActionPerformed

    private void dobDateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dobDateFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dobDateFieldFocusLost

    private void dobDateFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dobDateFieldMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_dobDateFieldMouseExited

    private void dobDateFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dobDateFieldMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobDateFieldMousePressed

    private void dobDateFieldagePop(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dobDateFieldagePop
        // TODO add your handling code here:
    }//GEN-LAST:event_dobDateFieldagePop

    private void dobDateFielduDobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dobDateFielduDobKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dobDateFielduDobKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        radioGroup1.clearSelection();
        radioGroup2.clearSelection();
        radioGroup3.clearSelection();
        radioGroup4.clearSelection();
        uidText.setEnabled(true);
        nameText.setEnabled(true);
        dobDateField.setEnabled(true);
        ageText.setEnabled(false);
        emailText.setEnabled(true);
        contactText.setEnabled(true);
        genderJComboBox.setEnabled(true);

        // bloodTypesTextField.setEnabled(true);
        OrganTypeComboBox.setEnabled(true);
        streetText.setEnabled(true);
        cityText.setEnabled(true);
        stateJComboBox.setEnabled(true);
        zipText.setEnabled(true);
        btnYesQ1.setEnabled(true);
        btnNoQ1.setEnabled(true);
        btnYesQ2.setEnabled(true);
        btnNoQ2.setEnabled(true);
        btnYesQ4.setEnabled(true);
        btnNoQ4.setEnabled(true);

        uidText.setText("");
        nameText.setText("");
        ageText.setText("");
        emailText.setText("");
        contactText.setText("");
        streetText.setText("");
        cityText.setText("");
        zipText.setText("");
        // bloodTypesTextField.setText("");

        genderJComboBox.setSelectedItem("");

        stateJComboBox.setSelectedItem("");
        OrganTypeComboBox.setSelectedItem("");

        dobDateField.setCalendar(null);

        btnYesQ1.setSelected(false);
        btnNoQ1.setSelected(false);
        btnYesQ2.setSelected(false);
        btnNoQ2.setSelected(false);
        btnYesQ4.setSelected(false);
        btnNoQ4.setSelected(false);

        btnSubmit.setEnabled(true);
        
        // Return to RecipientWorkArea
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void stateJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateJComboBoxActionPerformed

    private void genderJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderJComboBoxActionPerformed

    private void OrganTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrganTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrganTypeComboBoxActionPerformed

    private void uEmailKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_uEmailKeyTyped
        // TODO add your handling code here:
        if (!emailValidator(emailText.getText())) {
            emailValid = false;
        } else {
            // emailText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            emailText.setForeground(Color.BLACK);
            emailValid = true;
        }

    }// GEN-LAST:event_uEmailKeyTyped
    
    private void populateOrganTypeComboBox() {
        
        OrganTypeComboBox.removeAllItems();
         for (OrganType organType : OrganType.values()) {
            OrganTypeComboBox.addItem(organType.toString());
        }
    }// GEN-LAST:event_bloodTypeComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> OrganTypeComboBox;
    private javax.swing.JTextField ageText;
    private javax.swing.JRadioButton btnNoQ1;
    private javax.swing.JRadioButton btnNoQ2;
    private javax.swing.JRadioButton btnNoQ4;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JRadioButton btnYesQ1;
    private javax.swing.JRadioButton btnYesQ2;
    private javax.swing.JRadioButton btnYesQ4;
    private javax.swing.JTextField cityText;
    private javax.swing.JTextField contactText;
    private com.toedter.calendar.JDateChooser dobDateField;
    private javax.swing.JTextField emailText;
    private javax.swing.JComboBox genderJComboBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField nameText;
    private javax.swing.JComboBox stateJComboBox;
    private javax.swing.JTextField streetText;
    private javax.swing.JTextField uidText;
    private javax.swing.JTextField zipText;
    // End of variables declaration//GEN-END:variables
}
