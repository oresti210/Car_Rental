package model;

public abstract class Vehicle {
    protected int id;
    protected String brand;
    protected String model;

    public Vehicle(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }

    public abstract double calculateRentalCost(int days);
    public void displayInfo() {
        System.out.println(brand + " " + model + " (id=" + id + ")");
    }
}
