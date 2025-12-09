package rental;

import model.Car;

public class Payment {
    private double totalAmount;
    private boolean isPaid;

    // Constructor
    public Payment(Car car, int days) {
        this.totalAmount = car.getDailyRate() * days;
        this.isPaid = false; // Default is unpaid //
    }

    // Get Method
    public void makePayment() {
        this.isPaid = true;
        System.out.println("--Payment successful! ~Total paid: $" + totalAmount);
    }

    // Getters
    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return "Total: $" + totalAmount + " | Status: " + (isPaid ? "Paid" : "Pending");
    }
}
