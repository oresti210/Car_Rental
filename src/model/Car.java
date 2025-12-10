package model;

public class Car extends Vehicle {
    protected int year;
    protected double rentalPricePerDay;
    protected boolean available;

    public Car(int id, String brand, String model, int year, double rentalPricePerDay) {
        super(id, brand, model);
        this.year = year;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = true;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public double calculateRentalCost(int days) {
        return rentalPricePerDay * days;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Year: " + year + ", Price/day: " + rentalPricePerDay + ", Available: " + available);
    }
}
