package rental;

import java.util.ArrayList;
import java.util.List;

public class RentalManager {
    private List<Rental> rentals;

    // Constructor
    public RentalManager() {
        rentals = new ArrayList<>();
    }

    // Get Method
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void listRentals() {
        System.out.println("\n<== All Rentals ==>");
        for (Rental r : rentals) {
            System.out.println("Customer: " + r.getCustomer().getName() +
                               " | Car: " + r.getCar().getModel() +
                               " | Days: " + r.getDays());
        }
    }

    public int getTotalRentals() {
        return rentals.size();
    }
}
