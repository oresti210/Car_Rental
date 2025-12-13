package model;

public class CorporateCustomer extends Customer {
    private String companyName;
    private double discountRate;

    public CorporateCustomer(int userId, String name, String email, String phoneNumber, String password, String licenseNumber, String companyName, double discountRate) {
        super(userId, name, email, phoneNumber, password, licenseNumber);
        this.companyName = companyName;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() { return discountRate; }
    public double applyDiscount(double amount) { return amount * (1.0 - discountRate); }

    @Override
    public String getRole() { return "Corporate Customer"; }

    public String getCompanyName() { return companyName; }
}
