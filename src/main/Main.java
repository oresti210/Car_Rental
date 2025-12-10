package main;

import managers.CarManager;
import managers.UserManager;
import managers.RentalManager;
import model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Car Rental Management System - Skeleton");

        CarManager carManager = new CarManager();
        UserManager userManager = new UserManager();
        RentalManager rentalManager = new RentalManager();

        // Example seed data
        model.Sedan s1 = new model.Sedan(1, "Toyota", "Camry", 2020, 40.0, false);
        model.SUV s2 = new model.SUV(2, "Jeep", "Cherokee", 2019, 60.0, true);
        carManager.addCar(s1);
        carManager.addCar(s2);

        Customer cust = new Customer(1, "Alice", "alice@example.com", "+355123", "secret", "L12345");
        userManager.addUser(cust);

        System.out.println("Available cars:");
        for (Car c : carManager.getAvailableCars()) c.displayInfo();

        // Attempt a rental
        try {
            rental.Rental r = rentalManager.rentCar(s1, cust, LocalDate.now(), LocalDate.now().plusDays(3));
            System.out.println("Rented: " + r.getRentalId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
