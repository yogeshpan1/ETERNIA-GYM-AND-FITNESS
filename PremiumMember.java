// Class representing a Premium GymMember inheriting from GymMember
public class PremiumMember extends GymMember {
    
    private final double premiumCharge; // Fixed charge for premium membership
    private String personalTrainer; // Name of the assigned personal trainer
    private boolean isFullPayment; // Tracks whether full payment has been made
    private double paidAmount; // Amount paid by the member
    private double discountAmount; // Discount amount if full payment is made

    // Constructor to initialize PremiumMember attributes
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer; // Assign personal trainer
        this.premiumCharge = 50000; // Fixed premium membership charge
        this.isFullPayment = false; // Default payment status is false
        this.paidAmount = 0.0; // Initial payment amount is 0
        this.discountAmount = 0.0; // No discount initially
    }

    // Getter methods for PremiumMember attributes
    public double getPremiumCharge() 
    {
        return this.premiumCharge;
    }
    
    public String getPersonalTrainer() 
    { 
        return this.personalTrainer; 
    }
    
    public boolean getIsFullPayment() 
    { 
        return this.isFullPayment;
    }
    
    public double getPaidAmount() 
    {
        return this.paidAmount;
    }
    
    public double getDiscountAmount() 
    { 
        return this.discountAmount;
    }

    // Method to mark attendance and increase loyalty points
    public void markAttendance() {
        attendance++; // Increase attendance count
        loyaltyPoints += 10; // Increase loyalty points by 10 per attendance
    }

    // Method to handle due payments
    public String payDueAmount(double paidAmount) {
        if (this.isFullPayment) { // Check if payment is already completed
            return "Payment has already been completed successfully, Thank you!!";
        }
        
        if (paidAmount <= 0) { // Validate payment amount
            return "Invalid Payment Amount";
        }
        
        if (paidAmount > premiumCharge) { // Check if payment exceeds the charge
            double returningAmount = paidAmount - premiumCharge;
            return "Payment is exceeded by: Rs" + returningAmount;
        }

        this.paidAmount += paidAmount; // Update paid amount
        double remainingAmount = premiumCharge - this.paidAmount; // Calculate remaining balance

        if (this.paidAmount >= premiumCharge) { // Check if full payment is completed
            this.isFullPayment = true;
            this.paidAmount = premiumCharge; // Prevent exceeding the premium charge
            return "Payment is completed!! Successfully!!!";
        }

        return "You have paid Rs" + paidAmount + ". Now your Remaining Amount is Rs" + remainingAmount;
    }

    // Method to calculate discount if full payment is made
    public void calculateDiscount() {
        if (this.isFullPayment) {
            discountAmount = premiumCharge * 0.10;
        } else {
            discountAmount = 0.0;
        }
    }


    // Method to reset premium member details
    public void revertPremiumMember() {
        super.resetMember(); // Reset inherited member attributes
        personalTrainer = ""; // Remove assigned personal trainer
        isFullPayment = false; // Reset payment status
        paidAmount = 0.0; // Reset paid amount
        discountAmount = 0.0; // Reset discount amount
    }

    // Method to display PremiumMember details
    public void display() {
        super.display(); // Display inherited member attributes
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: Rs" + paidAmount);
        System.out.println("Full Payment Status: " + isFullPayment);
        
        if (this.isFullPayment == false) { // Display remaining payment if not fully paid
            double remaining = premiumCharge - paidAmount;
            System.out.println("Remaining Amount To Pay: Rs" + remaining);
        } else { // Display discount amount if fully paid
            System.out.println("Discount Amount: Rs" + discountAmount);
        }
    }
}