package model;

public class ElectricCar extends Car {
    private double batteryCapacity;

    public ElectricCar(int id, String brand, String model, int year, double rentalPricePerDay, double batteryCapacity) {
        super(id, brand, model, year, rentalPricePerDay);
        this.batteryCapacity = batteryCapacity;
    }
    
    public double getBatteryCapacity() {
		return batteryCapacity;
	}

	@Override
    public double calculateRentalCost(int days) {
        return super.calculateRentalCost(days) * 0.9;
    }
}
