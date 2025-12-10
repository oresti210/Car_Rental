package model;

public class Sedan extends Car {
    private boolean luxuryPackage;

    public Sedan(int id, String brand, String model, int year, double rentalPricePerDay, boolean luxuryPackage) {
        super(id, brand, model, year, rentalPricePerDay);
        this.luxuryPackage = luxuryPackage;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = super.calculateRentalCost(days);
        if (luxuryPackage) cost += 50.0 * days;
        return cost;
    }
}
