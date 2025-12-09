package model;

public class Car {
    private String id;
    private String model;
    private int year;
    private double dailyRate;

    //Constructor
    public Car(String id, String model, int year, double dailyRate) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
    }

    // Get Method
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    @Override
    public String toString() {
        return model + " (" + year + ")";
    }
}
