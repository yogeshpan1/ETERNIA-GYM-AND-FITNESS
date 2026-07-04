public abstract class GymMember {
    
    // Member attributes
    protected int id; 
    protected String name; 
    protected String location; 
    protected String phone; 
    protected String email; 
    protected String gender; 
    protected String DOB; 
    protected String membershipStartDate; 
    protected int attendance; 
    protected double loyaltyPoints; 
    protected boolean activeStatus; 

    // Constructor to initialize member details
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0; // Initialize attendance to zero
        this.loyaltyPoints = 0.0; // Initialize loyalty points to zero
        this.activeStatus = false; // Membership starts as inactive
    }

    // Abstract method to mark attendance
    public abstract void markAttendance();

    // Method to activate the membership
    public void activateMembership() {
        this.activeStatus = true;
    }

    // Method to deactivate the membership
    public void deactivateMembership() {
        if (this.activeStatus) {
            this.activeStatus = false;
        } 
    }

    // Method to reset member details
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }

    // Getter methods for retrieving member details
    public int getId() 
    { 
        return id;
    }
    
    public String getName() 
    {
        return name; 
    }
    
    public String getLocation() 
    { 
        return location; 
    }
    
    public String getPhone() 
    { 
        return phone;
    }
    
    public String getEmail() 
    { 
        return email; 
    }
    
    public String getGender() 
    { 
        return gender; 
    }
    
    public String getDOB() 
    {
        return DOB; 
    }
    
    public String getMembershipStartDate() 
    { 
        return membershipStartDate; 
    }
    
    public int getAttendance()
    { 
        return attendance;
    }
    
    public double getLoyaltyPoints() 
    { 
        return loyaltyPoints; 
    }
    
    public boolean isActiveStatus() 
    { 
        return activeStatus; 
    }

    // Method to display member details
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
}
