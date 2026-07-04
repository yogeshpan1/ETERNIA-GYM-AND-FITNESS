// Class representing a RegularMember inheriting from GymMember
public class RegularMember extends GymMember {
    
    private final int attendanceLimit; // Maximum attendance limit before eligibility for an upgrade
    private boolean isEligibleForUpgrade; // Indicates whether the member is eligible for an upgrade
    private String removalReason; // Stores the reason for removal if applicable
    private String referralSource; // Stores the referral source of the member
    private String plan; // Stores the current membership plan (basic, standard, deluxe)
    private double price; // Stores the price of the selected plan

    // Constructor to initialize RegularMember details
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30; 
        this.isEligibleForUpgrade = false; 
        this.plan = "basic"; 
        this.price = 6500; 
        this.removalReason = ""; 
        this.referralSource = referralSource; 
    }
    
    // Getter methods for RegularMember attributes
    public int getAttendanceLimit() {
        return this.attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade() {    
        return this.isEligibleForUpgrade;
    }

    public String getReferralSource() {
        return this.referralSource;
    }

    public String getRemovalReason() {
        return this.removalReason;
    }

    public String getPlan() {
        return this.plan;
    }

    // Method to mark attendance and update eligibility for an upgrade
    public void markAttendance() {
        attendance++; // Increase attendance count
        loyaltyPoints += 5; // Increase loyalty points by 5 per attendance
        if (this.attendance >= this.attendanceLimit) { // Check if attendance limit is reached
            this.isEligibleForUpgrade = true; // Mark as eligible for an upgrade
        }
    }

    // Method to return the price of a given membership plan
    public double getPlanPrice(String plan) {
        switch (plan) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1; // Return -1 for an invalid plan
        }
    }

    // Method to upgrade the membership plan
    public String upgradePlan(String newPlan) {
        double newPrice = getPlanPrice(newPlan); // Get price of the new plan
        if (this.isEligibleForUpgrade == false) { // Check eligibility
            return "OOPS! You are not eligible for upgrade";
        } else {
            if (newPlan.equals(this.plan)) { // Check if the plan is already selected
                return "You are already subscribed to this plan " + newPlan;
            } else if (newPrice == -1) { // Check if the selected plan is valid
                return "Plan selection is not valid. Please check again";
            } else { // Upgrade the plan
                this.plan = newPlan;
                this.price = newPrice;
                return "Congratulations!! You have been upgraded to " + newPlan;
            }
        }
    }

    // Method to reset a regular member and assign a removal reason
    public void revertRegularMember(String removalReason) {
        super.resetMember(); // Reset member attributes
        this.isEligibleForUpgrade = false; // Reset upgrade eligibility
        this.plan = "basic"; // Reset plan to basic
        this.price = 6500; // Reset price to the basic plan cost
        this.removalReason = removalReason; // Assign removal reason
    }

    // Method to display RegularMember details
    public void display() {
        super.display(); // Display GymMember attributes
        System.out.println("Plan: " + plan);
        System.out.println("Price: Rs" + price);
        if (this.removalReason.equals("") == false) { // Display removal reason if applicable
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}