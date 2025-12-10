package model;

public class Truck extends Car {
    private double loadCapacity;

    public Truck(int id, String brand, String model, int year, double rentalPricePerDay, double loadCapacity) {
        super(id, brand, model, year, rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = super.calculateRentalCost(days);
        cost += loadCapacity * 0.1 * days;
        return cost;
    }
}
