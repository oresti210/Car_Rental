package model;

public class SUV extends Car {
    private boolean fourWheelDrive;

    public SUV(int id, String brand, String model, int year, double rentalPricePerDay, boolean fourWheelDrive) {
        super(id, brand, model, year, rentalPricePerDay);
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = super.calculateRentalCost(days);
        if (fourWheelDrive) cost += 75.0 * days;
        return cost;
    }
}
