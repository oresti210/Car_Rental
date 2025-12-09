package rental;

import model.Car;
import model.Customer;

public class Rental {
    private Customer customer;
    private Car car;
    private int days;

    //Constructor
    public Rental(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
    }

    //Get Method
    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }
}
