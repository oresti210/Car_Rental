package rental;

import model.Car;
import model.Customer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private int rentalId;
    private Car car;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    private boolean isActive;

    public Rental(int rentalId, Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.rentalId = rentalId;
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = true;
        this.totalCost = calculateTotalCost();
    }

    public long calculateDuration() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public double calculateTotalCost() {
        int days = (int) Math.max(1, calculateDuration());
        return car.calculateRentalCost(days);
    }

    public void closeRental() {
        this.isActive = false;
        car.setAvailable(true);
    }

    public void displayRentalDetails() {
        System.out.println("Rental ID: " + rentalId +
                " | Car: " + car.getBrand() + " " + car.getModel() +
                " | Customer: " + customer.getName() +
                " | From: " + startDate +
                " | To: " + endDate +
                " | Total Cost: $" + totalCost +
                " | Active: " + isActive);
    }

    // ===== Getters =====
    public int getRentalId() { return rentalId; }
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }
    public boolean isActive() { return isActive; }

    // helper: check if a date falls within this rental's period (inclusive)
    public boolean containsDate(LocalDate date) {
        if (date == null) return false;
        return (!date.isBefore(startDate)) && (!date.isAfter(endDate));
    }
}