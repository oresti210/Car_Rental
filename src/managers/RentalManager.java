package managers;

import rental.Rental;
import model.Car;
import model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;
import exceptions.CarNotAvailableException;
import exceptions.InvalidRentalPeriodException;

public class RentalManager {
    private List<Rental> rentals;
    private int nextId;

    public RentalManager() {
        this.rentals = new ArrayList<>();
        this.nextId = 1;
    }

    public Rental rentCar(Car car, Customer customer, LocalDate start, LocalDate end)
            throws CarNotAvailableException, InvalidRentalPeriodException {

        if (!car.isAvailable())
            throw new CarNotAvailableException("Car " + car.getBrand() + " " + car.getModel() + " is not available.");
        if (end.isBefore(start))
            throw new InvalidRentalPeriodException("End date cannot be before start date.");

        Rental rental = new Rental(nextId++, car, customer, start, end);
        car.setAvailable(false);
        rentals.add(rental);
        customer.addRentalToHistory(rental);

        System.out.println("[RentalManager] Rental created for " + customer.getName() + " (" + car.getModel() + ")");
        return rental;
    }

    public void returnCar(int rentalId) {
        for (Rental r : rentals) {
            if (r.getRentalId() == rentalId && r.isActive()) {
                r.closeRental();
                System.out.println("[RentalManager] Rental " + rentalId + " closed successfully.");
                return;
            }
        }
        System.out.println("[RentalManager] Rental not found or already returned.");
    }

    public Rental findRentalById(int rentalId) {
        for (Rental r : rentals) {
            if (r.getRentalId() == rentalId)
                return r;
        }
        return null;
    }

    public List<Rental> getActiveRentals() {
        return rentals.stream().filter(Rental::isActive).collect(Collectors.toList());
    }

    public List<Rental> getPastRentals() {
        return rentals.stream().filter(r -> !r.isActive()).collect(Collectors.toList());
    }

    public List<Rental> getRentalsByCustomer(Customer c) {
        return rentals.stream()
                .filter(r -> r != null && r.isActive() && r.getCustomer().equals(c))
                .collect(Collectors.toList());
    }

    public List<Rental> getRentalsByDate(LocalDate date) {
        return rentals.stream()
                .filter(r -> (date.isAfter(r.getStartDate().minusDays(1)) && date.isBefore(r.getEndDate().plusDays(1))))
                .collect(Collectors.toList());
    }

    public void displayAllRentals() {
        if (rentals.isEmpty()) {
            System.out.println("[RentalManager] No rentals recorded.");
            return;
        }
        for (Rental r : rentals) {
            r.displayRentalDetails();
        }
    }

    public int getTotalRentals() {
        return rentals.size();
    }
}
