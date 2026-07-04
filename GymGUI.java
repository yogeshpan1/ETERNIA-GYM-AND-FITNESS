import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class GymGUI implements ActionListener {
    //Declaring GUI Components
    private JFrame frame, QrFrame, HomeFrame, LoginFrame, AttendanceFrame;
    private JTextField IDField, NameField, SearchField, LocationField, PriceField, PhoneField, EmailField, TrainerField, ReferralField;
    private JLabel labelID, labelName,labelPrice, labelLocation, labelSelect, labelPhone, labelEmail, labelReferral, labelQr, labelPayment, labelGender, labelTrainer, labelDOB, labelMS;
    private JPanel mainPanel, QrPanel, HomePanel;
    private JComboBox<String> dobDayCombo, dobMonthCombo, dobYearCombo, msDayCombo, msMonthCombo, msYearCombo, planCombo;
    private JRadioButton MaleRadioButton, FemaleRadioButton;
    private JButton ActivateButton, ClearButton, OnlineButton, CashButton,deactivateMember,activateMember, PayDueButton, BackButton, CheckDiscountButton, LoginButton,revertPremium, revertRegular, RegularMember, PremiumMember, DisplayButton, MarkAttendanceButton, saveToFileButton, readFromFileButton, upgradePlanButton;
    private boolean isPremiumForm;

    // ArrayList 
    ArrayList<GymMember> memberList = new ArrayList<GymMember>();
    
    public GymGUI() {
        Home(); // Launch home screen on startup
    }
    
    //Constructor
    public void RegularMember(){
        isPremiumForm = false;
        frame = new JFrame("Eternial Gym & Fitness"); // Create a new Frame
        frame.setSize(1100, 600); // sets size of the frame
        frame.setResizable(false); //prevents from resizing 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(); // Creates a new panel
        mainPanel.setBounds(0, 0, 1100, 650); // sets size and position of panel
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);
        frame.add(mainPanel);
        
        // Create and position ID label and input field
        labelID = new JLabel("ID:");
        labelID.setBounds(10, 10, 80, 30);
        mainPanel.add(labelID);

        IDField = new JTextField();
        IDField.setBounds(100, 10, 150, 30);
        mainPanel.add(IDField);
        
        // Create and position Name label and input field
        labelName = new JLabel("Name:");
        labelName.setBounds(10, 50, 80, 30);
        mainPanel.add(labelName);

        NameField = new JTextField();
        NameField.setBounds(100, 50, 150, 30);
        mainPanel.add(NameField);
        
        // Create and position location label and input field
        labelLocation = new JLabel("Location:");
        labelLocation.setBounds(10, 90, 80, 30);
        mainPanel.add(labelLocation);

        LocationField = new JTextField();
        LocationField.setBounds(100, 90, 150, 30);
        mainPanel.add(LocationField);
        
        // Create and position phone label and input field
        labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(10, 130, 80, 30);
        mainPanel.add(labelPhone);

        PhoneField = new JTextField();
        PhoneField.setBounds(100, 130, 150, 30);
        mainPanel.add(PhoneField);
        
        // Create and position Email label and input field
        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 170, 80, 30);
        mainPanel.add(labelEmail);

        EmailField = new JTextField();
        EmailField.setBounds(100, 170, 150, 30);
        mainPanel.add(EmailField);
        
        // Create a label for selecting the membership plan
        labelSelect = new JLabel("Plan:");
        labelSelect.setBounds(10, 250, 80, 30);
        mainPanel.add(labelSelect);
        
        // Create a label to display the price of the selected plan
        labelPrice = new JLabel("Price:");
        labelPrice.setBounds(10, 290, 130, 25);
        mainPanel.add(labelPrice);
        
        String[] plans = {"Basic", "Standard", "Deluxe"}; // Plan options
        planCombo = new JComboBox<>(plans); // Plan dropdown
        planCombo.setBounds(100, 250, 150, 25);
        planCombo.setEditable(false); // Make the dropdown non-editable
        planCombo.addActionListener(this);
        mainPanel.add(planCombo);
        
        planCombo.setSelectedItem("Basic");
        planCombo.setEnabled(false);

        labelDOB = new JLabel("D.O.B");
        labelDOB.setBounds(730, 15, 100, 25);
        mainPanel.add(labelDOB);

        labelGender = new JLabel("Gender");
        labelGender.setBounds(700, 120, 200, 25);
        mainPanel.add(labelGender);

        MaleRadioButton = new JRadioButton("Male");
        MaleRadioButton.setBounds(750, 120, 75, 25);
        MaleRadioButton.setBackground(Color.WHITE);
        mainPanel.add(MaleRadioButton);

        FemaleRadioButton = new JRadioButton("Female");
        FemaleRadioButton.setBounds(825, 120, 100, 25);
        FemaleRadioButton.setBackground(Color.WHITE);
        mainPanel.add(FemaleRadioButton);
        
        // Group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(MaleRadioButton);
        genderGroup.add(FemaleRadioButton);
        
        // Create a dropdown for selecting the day of birth
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
        dobDayCombo = new JComboBox<>(days);  // Create dropdown for day
        dobDayCombo.setBounds(810, 15, 50, 25); 
        mainPanel.add(dobDayCombo);
        
        // Create a dropdown for selecting the month of birth
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        dobMonthCombo = new JComboBox<>(months);
        dobMonthCombo.setBounds(870, 15, 50, 25);  // Create dropdown for month
        mainPanel.add(dobMonthCombo);
        
        // Create a dropdown for selecting the year of birth
        String[] years = new String[101]; // Array for years
        for (int i = 0; i < 50; i++) years[i] = String.valueOf(2006 + i);
        dobYearCombo = new JComboBox<>(years);  // Create dropdown for years
        dobYearCombo.setBounds(930, 15, 70, 25);
        mainPanel.add(dobYearCombo);
        
        // Create a label for Membership Start Date
        labelMS = new JLabel("Membership Start");
        labelMS.setBounds(700, 65, 140, 25);
        mainPanel.add(labelMS);
        
        // Create dropdowns for selecting the day membership start date
        msDayCombo = new JComboBox<>(days);
        msDayCombo.setBounds(810, 65, 50, 25);
        mainPanel.add(msDayCombo);
        
        // Create dropdowns for selecting the month membership start date
        msMonthCombo = new JComboBox<>(months);
        msMonthCombo.setBounds(870, 65, 50, 25);
        mainPanel.add(msMonthCombo);

        msYearCombo = new JComboBox<>(years);
        msYearCombo.setBounds(930, 65, 70, 25);
        mainPanel.add(msYearCombo);
        
        // button for Activate Membership
        ActivateButton = new JButton("Add Membership");
        ActivateButton.setBounds(20, 500, 150, 30);
        ActivateButton.addActionListener(this);
        mainPanel.add(ActivateButton);
        
        // button for clear
        ClearButton = new JButton("Clear");
        ClearButton.setBounds(210, 500, 80, 30);
        ClearButton.addActionListener(this);
        mainPanel.add(ClearButton);
        
        // label for referral
        labelReferral = new JLabel("Referral");
        labelReferral.setBounds(10, 210, 100, 25);
        mainPanel.add(labelReferral);
        
        // textfield for referral
        ReferralField = new JTextField();
        ReferralField.setBounds(100, 210, 150, 25);
        mainPanel.add(ReferralField);
        
        // label for payment
        labelPayment = new JLabel("Payment");
        labelPayment.setBounds(720, 500, 100, 30);
        mainPanel.add(labelPayment);
        
        //  online pay button
        OnlineButton = new JButton("Online");
        OnlineButton.setBounds(780, 500, 80, 30);
        OnlineButton.addActionListener(this);
        mainPanel.add(OnlineButton);
        
        // cash button
        CashButton = new JButton("Cash");
        CashButton.setBounds(870, 500, 80, 30);
        CashButton.addActionListener(this);
        mainPanel.add(CashButton);
        
        BackButton = new JButton("Back");
        BackButton.setBounds(960, 500, 80, 30);
        BackButton.addActionListener(this);
        mainPanel.add(BackButton);
        
        frame.setVisible(true); //shows the frame
    }
    
    // Method for premium Member
    public void PremiumMember(){
        isPremiumForm = true;
        
        frame = new JFrame("Eternial Gym & Fitness");
        frame.setSize(1100, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1100, 650);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);
        frame.add(mainPanel);

        labelID = new JLabel("ID:");
        labelID.setBounds(10, 10, 80, 30);
        mainPanel.add(labelID);

        IDField = new JTextField();
        IDField.setBounds(100, 10, 150, 30);
        mainPanel.add(IDField);

        labelName = new JLabel("Name:");
        labelName.setBounds(10, 50, 80, 30);
        mainPanel.add(labelName);

        NameField = new JTextField();
        NameField.setBounds(100, 50, 150, 30);
        mainPanel.add(NameField);

        labelLocation = new JLabel("Location:");
        labelLocation.setBounds(10, 90, 80, 30);
        mainPanel.add(labelLocation);

        LocationField = new JTextField();
        LocationField.setBounds(100, 90, 150, 30);
        mainPanel.add(LocationField);

        labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(10, 130, 80, 30);
        mainPanel.add(labelPhone);

        PhoneField = new JTextField();
        PhoneField.setBounds(100, 130, 150, 30);
        mainPanel.add(PhoneField);

        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 170, 80, 30);
        mainPanel.add(labelEmail);

        EmailField = new JTextField();
        EmailField.setBounds(100, 170, 150, 30);
        mainPanel.add(EmailField);

        labelTrainer = new JLabel("Trainer");
        labelTrainer.setBounds(10, 210, 80, 30);
        mainPanel.add(labelTrainer);

        TrainerField = new JTextField();
        TrainerField.setBounds(100, 210, 150, 30);
        mainPanel.add(TrainerField);

        labelDOB = new JLabel("D.O.B");
        labelDOB.setBounds(730, 15, 100, 25);
        mainPanel.add(labelDOB);

        labelGender = new JLabel("Gender");
        labelGender.setBounds(700, 120, 200, 25);
        mainPanel.add(labelGender);

        MaleRadioButton = new JRadioButton("Male");
        MaleRadioButton.setBounds(750, 120, 75, 25);
        MaleRadioButton.setBackground(Color.WHITE);
        mainPanel.add(MaleRadioButton);
        
        labelPrice = new JLabel("Price: Rs 50000");
        labelPrice.setBounds(10, 250, 130, 25);
        mainPanel. add(labelPrice);
        
        FemaleRadioButton = new JRadioButton("Female");
        FemaleRadioButton.setBounds(825, 120, 100, 25);
        FemaleRadioButton.setBackground(Color.WHITE);
        mainPanel.add(FemaleRadioButton);
        
        // Group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(MaleRadioButton);
        genderGroup.add(FemaleRadioButton);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
        dobDayCombo = new JComboBox<>(days);
        dobDayCombo.setBounds(810, 15, 50, 25);
        mainPanel.add(dobDayCombo);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        dobMonthCombo = new JComboBox<>(months);
        dobMonthCombo.setBounds(870, 15, 50, 25);
        mainPanel.add(dobMonthCombo);

        String[] years = new String[101];
        for (int i = 0; i < 50; i++) years[i] = String.valueOf(2006 + i);
        dobYearCombo = new JComboBox<>(years);
        dobYearCombo.setBounds(930, 15, 70, 25);
        mainPanel.add(dobYearCombo);

        labelMS = new JLabel("Membership Start");
        labelMS.setBounds(700, 65, 140, 25);
        mainPanel.add(labelMS);

        msDayCombo = new JComboBox<>(days);
        msDayCombo.setBounds(810, 65, 50, 25);
        mainPanel.add(msDayCombo);

        msMonthCombo = new JComboBox<>(months);
        msMonthCombo.setBounds(870, 65, 50, 25);
        mainPanel.add(msMonthCombo);

        msYearCombo = new JComboBox<>(years);
        msYearCombo.setBounds(930, 65, 70, 25);
        mainPanel.add(msYearCombo);

        ActivateButton = new JButton("Add Membership");
        ActivateButton.setBounds(20, 500, 150, 30);
        ActivateButton.addActionListener(this);
        mainPanel.add(ActivateButton);

        ClearButton = new JButton("Clear");
        ClearButton.setBounds(210, 500, 80, 30);
        ClearButton.addActionListener(this);
        mainPanel.add(ClearButton);

        labelPayment = new JLabel("Payment");
        labelPayment.setBounds(720, 500, 100, 30);
        mainPanel.add(labelPayment);

        OnlineButton = new JButton("Online");
        OnlineButton.setBounds(780, 500, 80, 30);
        OnlineButton.addActionListener(this); // Event listener for online payment
        mainPanel.add(OnlineButton);

        CashButton = new JButton("Cash");
        CashButton.setBounds(870, 500, 80, 30);
        CashButton.addActionListener(this);
        mainPanel.add(CashButton);
        
        BackButton = new JButton("Back");
        BackButton.setBounds(960, 500, 80, 30);
        BackButton.addActionListener(this); // Event listener for cash payment
        mainPanel.add(BackButton);

        frame.setVisible(true);
    }
    
    // Method to display QR code
    private void showQRCode(String title, String imagePath) {
        QrFrame = new JFrame(title);
        QrFrame.setSize(560, 560);
        QrFrame.setLayout(null);
        QrFrame.setLocationRelativeTo(null);

        ImageIcon QrImage = new ImageIcon(imagePath);
        labelQr = new JLabel(QrImage);
        labelQr.setBounds(50, 30, 450, 450); // Set image bounds

        QrPanel = new JPanel();
        QrPanel.setBounds(0, 0, 560, 560);
        QrPanel.setLayout(null);
        QrPanel.add(labelQr);
        QrFrame.add(QrPanel);
        QrFrame.setVisible(true); // Show QR window
    }
    
    //Method for Homepage
    public void Home() {
        HomeFrame = new JFrame("Home");
        HomeFrame.setSize(1160, 650);
        HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomeFrame.setLayout(null);
        HomeFrame.setResizable(false);
        HomeFrame.setLocationRelativeTo(null);
        
        HomePanel = new JPanel();
        HomePanel.setBounds(0, 0, 1160, 650);
        HomePanel.setLayout(null);
        HomeFrame.add(HomePanel);
    
        JLabel welcomeLabel = new JLabel("Welcome To Eternia Gym & Fitness");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setBackground(Color.BLACK); 
        welcomeLabel.setBounds(380, 60, 760, 30);
        HomePanel.add(welcomeLabel);
        
        LoginButton = new JButton("Members Details");
        LoginButton.setFont(new Font("Arial", Font.BOLD, 16));
        LoginButton.setBounds(960, 400, 200, 30);
        LoginButton.addActionListener(this);
        HomePanel.add(LoginButton);
        
        RegularMember = new JButton("Add Regular Member");
        RegularMember.setFont(new Font("Arial", Font.BOLD, 16));
        RegularMember.setBounds(960, 440, 200, 30);
        RegularMember.addActionListener(this);
        HomePanel.add(RegularMember);
        
        PremiumMember = new JButton("Add Premium Member");
        PremiumMember.setFont(new Font("Arial", Font.BOLD, 16));
        PremiumMember.setBounds(960, 480, 200, 30);
        PremiumMember.addActionListener(this);
        HomePanel.add(PremiumMember);
        
        HomeFrame.setVisible(true);
    }
    
    // Login screen where member ID can be used to display or modify information
    private void Login(){
        LoginFrame = new JFrame("Customer Details"); //Create a new JFrame for the login interface
        LoginFrame.setSize(900, 650);
        LoginFrame.setLayout(null);  // Set the layout to null for absolute positioning
        LoginFrame.setResizable(false);
        LoginFrame.setLocationRelativeTo(null); // Center on screen
        
        // Create a JLabel for the ID input field
        JLabel labelID = new JLabel("Enter a Member ID:");
        labelID.setBounds(260, 160, 180, 30); // Set the position and size of the label
        labelID.setFont(new Font("Arial", Font.BOLD, 14));
        LoginFrame.add(labelID); // Add the label to the JFrame
        
        IDField = new JTextField();
        IDField.setBounds(400, 160, 150, 30);
        LoginFrame.add(IDField);
            
        JLabel welcomeLabel = new JLabel("Eternia Gym & Fitness Dashboard");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setBackground(Color.BLACK); 
        welcomeLabel.setBounds(290, 60, 760, 30);
        LoginFrame.add(welcomeLabel);
        
        DisplayButton = new JButton("Display");
        DisplayButton.setBounds(410, 220, 120, 30); 
        DisplayButton.addActionListener(this);
        LoginFrame.add(DisplayButton);
        
        saveToFileButton = new JButton("Save To File");
        saveToFileButton.setBounds(30, 220, 150, 30);
        saveToFileButton.addActionListener(this);
        LoginFrame.add(saveToFileButton);
        
        activateMember = new JButton("Activate Membership");
        activateMember.setBounds(30, 350, 170, 30);
        activateMember.addActionListener(this);
        LoginFrame.add(activateMember);
        
        deactivateMember = new JButton("Deactivate Membership");
        deactivateMember.setBounds(700, 350, 170, 30);
        deactivateMember.addActionListener(this);
        LoginFrame.add(deactivateMember);
        
        revertRegular = new JButton("Revert Regular");
        revertRegular.setBounds(30, 410, 170, 30);
        revertRegular.addActionListener(this);
        LoginFrame.add(revertRegular);
        
        revertPremium = new JButton("Revert Premium");
        revertPremium.setBounds(700, 410, 170, 30);
        revertPremium.addActionListener(this);
        LoginFrame.add(revertPremium);
        
        MarkAttendanceButton = new JButton("Mark Attendance");
        MarkAttendanceButton.setBounds(410, 350, 140, 30);
        MarkAttendanceButton.addActionListener(this);
        LoginFrame.add(MarkAttendanceButton);
        
        BackButton = new JButton("Back");
        BackButton.setBounds(750, 220, 100, 30);
        BackButton.addActionListener(this);
        LoginFrame.add(BackButton);
        
        PayDueButton = new JButton("Pay Due Amount");
        PayDueButton.setBounds(410, 470, 140, 30);
        PayDueButton.addActionListener(this);
        LoginFrame.add(PayDueButton);
        
        CheckDiscountButton = new JButton("Check Discount");
        CheckDiscountButton.setBounds(700, 470, 170, 30);
        CheckDiscountButton.addActionListener(this);
        LoginFrame.add(CheckDiscountButton);

        readFromFileButton = new JButton("Read From File");
        readFromFileButton.setBounds(30, 470, 170, 30);
        readFromFileButton.addActionListener(this);
        LoginFrame.add(readFromFileButton);
        
        upgradePlanButton = new JButton("Upgrade Plan");
        upgradePlanButton.setBounds(410, 410, 140, 30);
        upgradePlanButton.addActionListener(this);
        LoginFrame.add(upgradePlanButton);
        
        LoginFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            // If "Activate" button is clicked activates a new gym member
            if (e.getSource() == ActivateButton) {
                ActivateMember();
                //When "Clear" button is clicked clears all input fields
            } else if (e.getSource() == ClearButton) {
                IDField.setText(""); // Clear ID field
                NameField.setText("");// Clear Name field
                if (TrainerField != null) TrainerField.setText(""); // Clear Trainer field
                LocationField.setText(""); // Clear Location field
                PhoneField.setText(""); // Clear Phone field
                EmailField.setText(""); // Clear Email field
                if (ReferralField != null) ReferralField.setText("");
                MaleRadioButton.setSelected(false); // Deselect Male radio button
                FemaleRadioButton.setSelected(false); // Deselect Female radio button
                if (planCombo != null) ; // Reset plan selection to default
                dobDayCombo.setSelectedIndex(0);
                dobMonthCombo.setSelectedIndex(0);
                dobYearCombo.setSelectedIndex(0);
                msDayCombo.setSelectedIndex(0);
                msMonthCombo.setSelectedIndex(0);
                msYearCombo.setSelectedIndex(0);
                
                // When "Login" button is clicked hides home page and opens login form
            } else if (e.getSource() == LoginButton) {
                HomeFrame.setVisible(false);
                Login();
                
                // When "Regular Member" button is clicked navigates to regular member registration form
            } else if (e.getSource() == RegularMember) {
                if (HomeFrame != null) HomeFrame.setVisible(false);
                if (LoginFrame != null) LoginFrame.setVisible(false);
                RegularMember();
                
                // When "Premium Member" button is clicked navigates to premium member registration form
            } else if (e.getSource() == PremiumMember) {
                    if (HomeFrame != null) HomeFrame.setVisible(false);
                    if (LoginFrame != null) LoginFrame.setVisible(false);
                    PremiumMember();
                    
                    // When "Back" button is clicked goes back to previous screen
            } else if (e.getSource() == upgradePlanButton) {
                int id = Integer.parseInt(IDField.getText().trim());
                for (GymMember m : memberList) {
                    if (m.getId() == id && m instanceof RegularMember) {
                        RegularMember rm = (RegularMember) m;
                        if (!rm.getIsEligibleForUpgrade()) {
                            JOptionPane.showMessageDialog(frame,
                                "You are not yet eligible for upgrade.","Info", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String[] opts = {"Standard", "Deluxe"};
                            int choice = JOptionPane.showOptionDialog(
                                frame, "Choose new plan:", "Upgrade Plan",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null, opts, opts[0]
                            );
                            if (choice == 0)
                                JOptionPane.showMessageDialog(frame, rm.upgradePlan("standard"));
                            else if (choice == 1)
                                JOptionPane.showMessageDialog(frame, rm.upgradePlan("deluxe"));
                        }
                        break;
                    }
                }
                return;
                } // ─── PAY DUE AMOUNT ─────────────────────────────────────────────────────────
                else if (e.getSource() == PayDueButton) {
            if (IDField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                    "Please enter a Member ID first.",
                    "Input Required",
                    JOptionPane.WARNING_MESSAGE);
                return;
                }
            int id = Integer.parseInt(IDField.getText().trim());
            // Find member
                for (GymMember m : memberList) {
                if (m.getId() == id) {
                    if (!(m instanceof PremiumMember)) {
                        // Not premium → no due
                        JOptionPane.showMessageDialog(frame,
                            "You don't have any due amount.",
                            "No Due",
                            JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        PremiumMember pm = (PremiumMember) m;
                        // Calculate due
                        double due = pm.getPremiumCharge() - pm.getPaidAmount();
                        if (due < 0) due = 0;
                        JOptionPane.showMessageDialog(frame,"Outstanding balance: Rs " + due,"Due Amount", JOptionPane.INFORMATION_MESSAGE);
                    }
                    return;
                }
            }
            // 4) No member found
            JOptionPane.showMessageDialog(frame,
                "No member found with ID: " + id,
                "Not Found",
                JOptionPane.ERROR_MESSAGE);
            return;
            }
             // inside actionPerformed(...):

            else if (e.getSource() == CheckDiscountButton) {
        if (IDField.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(LoginFrame,"Please enter a Member ID first.","Input Required", JOptionPane.WARNING_MESSAGE);
        return;
        }
        int id = Integer.parseInt(IDField.getText().trim());
        for (GymMember m : memberList) {
        if (m.getId() == id) {
            if (!(m instanceof PremiumMember)) {
                JOptionPane.showMessageDialog(frame,"You don't have any discount available.","No Discount",JOptionPane.INFORMATION_MESSAGE);
            } else {
                PremiumMember pm = (PremiumMember) m;
                pm.calculateDiscount();
                double d = pm.getDiscountAmount();
                if (d > 0) {
                    JOptionPane.showMessageDialog(frame,
                        "Discount Amount: Rs" + d);
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "No any discount available. Pay full amount for discount.");
                }
            }
            return;
        }
        } JOptionPane.showMessageDialog(frame,"No member found with ID: " + id,"Not Found", JOptionPane.ERROR_MESSAGE);
        } else if (e.getSource() == BackButton) {
                if (frame != null && frame.isVisible()) {
                frame.setVisible(false);
                Home(); // Go to home page
                } else if (LoginFrame != null && LoginFrame.isVisible()) {
                    LoginFrame.setVisible(false);
                    Home(); // Go to home page
                } else if (AttendanceFrame != null && AttendanceFrame.isVisible()) {
                    AttendanceFrame.setVisible(false);
                    Login(); // Go to login page
                }
                
                // When "Mark Attendance" button is clicked marks member attendance
            } else if (e.getSource() == MarkAttendanceButton) {
                MarkAttendance();
                
                // When "Online" payment is selected shows QR code image for payment
            } else if (e.getSource() == OnlineButton) {
                showQRCode("Pay Here", "C:\\Users\\user\\Documents\\sem-2-java\\Semester-2\\online.jpg");
                
                // When "Cash" payment is selected - shows cash payment confirmation
            } else if (e.getSource() == CashButton) {
                JOptionPane.showMessageDialog(frame, "Paid Via Cash");
                
                // When "Display" button is clicked - displays all member details
            } else if (e.getSource() == DisplayButton) {
                DisplayMember();
                
                // When "Revert to Regular" is clicked - downgrades premium member to regular
            } else if (e.getSource() == revertRegular) {
                RevertRegular();
            } else if (e.getSource() == revertPremium) {
                RevertPremium();
                
                // When "Activate" or "Deactivate" is clicked activates or deactivates selected member
            } else if (e.getSource() == activateMember || e.getSource() == deactivateMember) {
                activateDeactivate(e);
            } else if (e.getSource() == saveToFileButton) {
                saveMembersToFile();
            } else if (e.getSource() == readFromFileButton) {
                readMemberFromFile();
            }

        // Shows error message if something goes wrong
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        // When a plan is selected from the dropdown updates the price label accordingly      
        if (e.getSource() == planCombo) {
            String selectedPlan = (String) planCombo.getSelectedItem();
            switch (selectedPlan) {
                case "Basic":
                labelPrice.setText("Price: Rs 6000"); // Show Basic plan price
                break;
                case "Standard":
                labelPrice.setText("Price: Rs 12500"); // Shows Standard plan price
                break;
                case "Deluxe":
                labelPrice.setText("Price: Rs 18500"); // Shows Deluxe plan price
                break;
            }
        }
    }
    
    private void ActivateMember() {
    try {
        // Parse common fields
        int ID = Integer.parseInt(IDField.getText().trim());
        String Name = NameField.getText();
        String Location = LocationField.getText();
        String Phone = PhoneField.getText();
        String Email = EmailField.getText();
        
        String dob = dobDayCombo.getSelectedItem() + "/"+ dobMonthCombo.getSelectedItem() + "/"+ dobYearCombo.getSelectedItem();
        String startDate = msDayCombo.getSelectedItem() + "/" + msMonthCombo.getSelectedItem() + "/" + msYearCombo.getSelectedItem();
        
        for (GymMember member : memberList) {
            if (member.getId() == ID) {
                JOptionPane.showMessageDialog(frame,
                       "The ID is already used by another Member.",
                        "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            }
            
        String gender = "";
        if (MaleRadioButton.isSelected()) gender = "Male";
        else if (FemaleRadioButton.isSelected()) gender = "Female";

        // Branch based on form type
        if (isPremiumForm) {
            // --- PREMIUM MEMBER ---
            if (Name.isEmpty() || Location.isEmpty() || Phone.isEmpty()
                || Email.isEmpty() || gender.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                    "Please fill in all the fields.",
                    "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            PremiumMember premium = new PremiumMember(
                ID, Name, Location, Phone, Email,
                gender, dob, startDate,
                TrainerField.getText()
            );
            memberList.add(premium);
            JOptionPane.showMessageDialog(frame,
                "Premium Member successfully added.");

            // <<< ONLY for premium: ask for payment
            String paymentInput = JOptionPane.showInputDialog(
                frame,
                "Enter amount to pay for premium membership (Rs):"
            );
            try {
                double paid = Double.parseDouble(paymentInput);
                JOptionPane.showMessageDialog(frame,
                    premium.payDueAmount(paid));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Invalid amount entered. You can pay later using Pay Due Amount button.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
                );
            }

        } else {
            // --- REGULAR MEMBER ---
            if (Name.isEmpty() || Location.isEmpty() || Phone.isEmpty()
                || Email.isEmpty() || gender.isEmpty()
                || ReferralField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                    "Please fill in all the fields.",
                    "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            RegularMember regular = new RegularMember(
                ID, Name, Location, Phone, Email,
                gender, dob, startDate,
                ReferralField.getText()
            );
            memberList.add(regular);
            JOptionPane.showMessageDialog(frame,
                "Regular Member Added Successfully!");
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame,
            "Please enter valid numeric values for ID.",
            "Error", JOptionPane.WARNING_MESSAGE);
    }
    }

    
    private void MarkAttendance() {
        // Check if the ID field is empty
        if (IDField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Membership ID is required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int membershipId = Integer.parseInt(IDField.getText()); //checks if the id is integer or not
            
            // Checks over the list of members to find a match
            for (GymMember member : memberList) {
                if (membershipId == member.getId()) {
        
                    if (member instanceof RegularMember) {
                    RegularMember regular = (RegularMember) member;
                        
                        // Check if the member is active before marking attendance
                    if (!regular.isActiveStatus()) {
                        JOptionPane.showMessageDialog(frame,
                        "This member is currently inactive. Activate them before marking attendance.",
                        "Inactive Member", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                        
                        // Mark attendance and display updated info
                    regular.markAttendance();
                    // <<< ADD THIS right after regular.markAttendance(); in the RegularMember block
                    if (regular.getIsEligibleForUpgrade()) {
                        JOptionPane.showMessageDialog(frame,
                            "Congrats! Now you have access to Plan Upgrade:\n" +
                            "Click on Upgrade Plan to Upgrade",
                            "Upgrade Available",
                            JOptionPane.INFORMATION_MESSAGE);
                    }

                    JOptionPane.showMessageDialog(frame,"Attendance marked!\n\n" +"Current Attendance: " + regular.getAttendance() + "\n" +"Loyalty Points: " + regular.getLoyaltyPoints(),
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                    return; 
                    }
        
                    if (member instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) member;
                        
                        if (!premium.isActiveStatus()) {
                            JOptionPane.showMessageDialog(frame,
                                "Please activate Premium Member before marking attendance.",
                                "Inactive Premium", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        premium.markAttendance();
                        JOptionPane.showMessageDialog(frame,
                                "Attendance marked!\n\n" +
                                "Current Attendance: " + premium.getAttendance() + "\n" +
                                "Loyalty Points: " + premium.getLoyaltyPoints(),
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }
                }
            }
        
            // No member found
            JOptionPane.showMessageDialog(frame, "No member found with that ID.", "Error", JOptionPane.ERROR_MESSAGE);
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric membership ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void RevertRegular() {
        try {
            int membershipId = Integer.parseInt(IDField.getText());
            
            for (GymMember member : memberList) {
                if (membershipId == member.getId()) {
                    // Check if the member is a RegularMember
                    if (member instanceof RegularMember) { 
                        RegularMember regular = (RegularMember) member;
                         // Ask for a reason before reverting
                        String removalReason = JOptionPane.showInputDialog(frame, "Enter reason for reverting member:");
                        if (removalReason != null && !removalReason.trim().isEmpty()) {
                            regular.revertRegularMember(removalReason);
                            JOptionPane.showMessageDialog(frame, "Regular Member reverted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Revert cancelled: Reason is required.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Member is not a Regular Member.");
                    }
                    return; 
                }
            }
    
            // Member not found
            JOptionPane.showMessageDialog(frame, "No member with that ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid membership ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void RevertPremium() {
        try {
            int membershipId = Integer.parseInt(IDField.getText());
            
            for (GymMember member : memberList) {
                if (membershipId == member.getId()) {
                    // Check if the member is a PremiumMember
                    if (member instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) member;
                        premium.revertPremiumMember();
                        JOptionPane.showMessageDialog(frame, "Premium Member reverted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Member is not a Premium Member.");
                    }
                    return; // Exit once member is processed
                }
            }
    
            // Member not found
            JOptionPane.showMessageDialog(frame, "No member with that ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid membership ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    private void Activate() {
        try {
            int membershipId = Integer.parseInt(IDField.getText().trim());
    
            for (GymMember member : memberList) {
                if (member.getId() == membershipId) {
                    if (member instanceof RegularMember) {
                        RegularMember regular = (RegularMember) member;
                        if (regular.isActiveStatus()) {
                            JOptionPane.showMessageDialog(LoginFrame, "Member is already active.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            regular.activateMembership();
                            JOptionPane.showMessageDialog(LoginFrame, "Member has been activated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(LoginFrame, "Only Regular Members can be activated/deactivated.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    return;
                }
            }
    
            JOptionPane.showMessageDialog(LoginFrame, "No member found with that ID.", "Error", JOptionPane.ERROR_MESSAGE);
    
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(LoginFrame, "Please enter a valid numeric ID.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void Deactivate() {
        try {
            int membershipId = Integer.parseInt(IDField.getText().trim());
    
            for (GymMember member : memberList) {
                if (member.getId() == membershipId) {
                    if (member instanceof RegularMember) {
                        RegularMember regular = (RegularMember) member;
                        if (!regular.isActiveStatus()) {
                            JOptionPane.showMessageDialog(LoginFrame, "Member is already inactive.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            regular.activateMembership();
                            JOptionPane.showMessageDialog(LoginFrame, "Member has been deactivated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(LoginFrame, "Only Regular Members can be activated/deactivated.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    return;
                }
            }
    
            JOptionPane.showMessageDialog(LoginFrame, "No member found with that ID.", "Error", JOptionPane.ERROR_MESSAGE);
    
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(LoginFrame, "Please enter a valid numeric ID.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void DisplayMember() {
        try {
            String idText = IDField.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(LoginFrame,
                        "Please enter an ID",
                        "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
    
            int memberId = Integer.parseInt(idText);
            //Search for the member with the entered ID in the arraylist
            for (GymMember member : memberList) {
                if (member.getId() == memberId) {
                    String memberType = (member instanceof PremiumMember) ? "Premium" : "Regular";
                    String details =
                            "Member Details:\n" +
                            "Type: " + memberType + "\n" +
                            "ID: " + member.getId() + "\n" +
                            "Name: " + member.getName() + "\n" +
                            "Location: " + member.getLocation() + "\n" +
                            "Phone: " + member.getPhone() + "\n" +
                            "Email: " + member.getEmail() + "\n" +
                            "Gender: " + member.getGender() + "\n" +
                            "DOB: " + member.getDOB() + "\n" +
                            "Start Date: " + member.getMembershipStartDate() + "\n" +
                            "Attendance: " + member.getAttendance() + "\n" +
                            "Loyalty Points: " + member.getLoyaltyPoints() + "\n";
    
                    if (member instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) member;
                        details += "Trainer: " + premium.getPersonalTrainer() + "\n";
                    } else if (member instanceof RegularMember) {
                        RegularMember regular = (RegularMember) member;
                        details += "Plan Type: " + regular.getPlan() + "\n";
                        details += "Referral: " + regular.getReferralSource() + "\n";
                        details += "Active Status: " + (regular.isActiveStatus() ? "Active" : "Inactive") + "\n";
                    }
    
                    JOptionPane.showMessageDialog(LoginFrame, details, "Member Found", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
    
            // If member was not found
            JOptionPane.showMessageDialog(LoginFrame,"No member found with ID: " + memberId,"Not Found", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(LoginFrame,
                    "Please enter a valid numeric ID",
                    "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void activateDeactivate(ActionEvent e) {
        try {
            int membershipId = Integer.parseInt(IDField.getText().trim());
            //Search for the member with the entered ID in the arraylist
            for (GymMember member : memberList) {
                if (membershipId == member.getId()) {
                    // When "Activate" button was clicked
                    if (e.getSource() == activateMember) {
                        member.activateMembership();
                        JOptionPane.showMessageDialog(LoginFrame, "Member activated successfully!");
                        // When "deactivate" button was clicked
                    } else if (e.getSource() == deactivateMember) {
                        member.deactivateMembership();
                        JOptionPane.showMessageDialog(LoginFrame, "Member deactivated successfully!");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(LoginFrame, "No member found with that ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(LoginFrame, "Invalid ID! Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

        //Save to file
    private void saveMembersToFile() {
        try {
            File file = new File("MemberDetails.txt");
            FileWriter writer = new FileWriter(file, true);
    
            // If file is empty, write header
            if (file.length() == 0) {
                writer.write(String.format(
                    "| %-5s | %-15s | %-15s | %-12s | %-25s | %-12s | %-10s | %-10s | %-10s | %-8s | %-6s | %-10s | %-10s | %-10s |\n",
                    "ID", "Name", "Location", "Phone", "Email", "StartDate",
                    "Plan", "Price", "Attendance", "Loyalty", "Active",
                    "FullPay", "Discount", "NetPaid"
                ));
            }
    
            for (GymMember m : memberList) {
                String plan;
                double price, fullPayment = 0, discount = 0, netPaid = 0;
    
                if (m instanceof RegularMember) {
                    RegularMember r = (RegularMember) m;
                    plan = r.getPlan();
                    price = r.getPlanPrice(r.getPlan());
                } else 
                { // PremiumMember
                    PremiumMember p = (PremiumMember) m;
                    plan = "Premium";
                    price = p.getPremiumCharge();
                    fullPayment = p.getPaidAmount();
                    // ensure discount is up to date
                    p.calculateDiscount();
                    discount = p.getDiscountAmount();
                    netPaid = fullPayment - discount;
                }
    
                writer.write(String.format(
                "| %-5d | %-15s | %-15s | %-12s | %-25s | %-12s | %-10s | %-10.2f | %-10d | %-8.2f | %-6s | %-10.2f | %-10.2f | %-10.2f |\n",
                m.getId(),
                m.getName(),
                m.getLocation(),
                m.getPhone(),
                m.getEmail(),
                m.getMembershipStartDate(),
                plan,
                price,
                m.getAttendance(),
                m.getLoyaltyPoints(),
                m.isActiveStatus() ? "Yes" : "No",
                fullPayment,
                discount,
                netPaid
                ));
            }
    
            writer.close();
            JOptionPane.showMessageDialog(frame,
                "Member details saved successfully!",
                "Save Complete",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame,
                "Error writing to file: " + ex.getMessage(),
                "File Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // READ FROM FILE 
    private void readMemberFromFile() {
        JFrame fileFrame = new JFrame("Member File Viewer");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
    
        File file = new File("MemberDetails.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(frame,
                "No saved member file found.",
                "File Not Found",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        try (FileReader fr = new FileReader(file)) {
            // Reads the entire file into the text area—no StringBuilder needed
            textArea.read(fr, null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame,
                "An error occurred while reading the file:\n" + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        fileFrame.add(new JScrollPane(textArea));
        fileFrame.setSize(970, 400);
        fileFrame.setLocationRelativeTo(null);
        fileFrame.setVisible(true);
    }
    
    // Main method entry point of the application
    public static void main(String[] args) {
        new GymGUI();  // Launch the GymGUI
    }
}