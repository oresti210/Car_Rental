package model;

import java.util.ArrayList;
import java.util.List;
import rental.Rental;

public class Customer extends User {
    private String licenseNumber;
    private List<Rental> rentalHistory = new ArrayList<>();

    public Customer(int userId, String name, String email, String phoneNumber, String password, String licenseNumber) {
        super(userId, name, email, phoneNumber, password);
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public List<Rental> getRentalHistory() { return rentalHistory; }
    public void addRentalToHistory(Rental r) { rentalHistory.add(r); }

    @Override
    public String getRole() { return "Customer"; }

    public void displayCustomerInfo() {
        System.out.println("Customer: " + name + " | License: " + licenseNumber + " | Email: " + email);
    }
}

