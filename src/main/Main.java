package main;

import model.Car;
import model.Customer;
import rental.Rental;
import rental.Payment;
import rental.RentalManager;

public class Main {
    public static void main(String[] args) {
        
    	Car car1 = new Car("C001", "Mercedes Benz", 2007, 65.5);
        Customer customer1 = new Customer("U001", "Lazarel Goga", "lazarel.goga24@umt.edu.al");
        Rental rental1 = new Rental(customer1, car1, 2);
        Payment payment1 = new Payment(car1, 2);
        payment1.makePayment();

        Car car2 = new Car("C002", "Tesla", 2025, 300.0);
        Customer customer2 = new Customer("U002", "Elon Musk", "Elon.musk@Tesla.com");
        Rental rental2 = new Rental(customer2, car2, 7);
        Payment payment2 = new Payment(car2, 7);
        payment2.makePayment();

        RentalManager manager = new RentalManager();
        manager.addRental(rental1);
        manager.addRental(rental2);

        manager.listRentals();

        System.out.println("\n<== Payment Summaries ==>");
        System.out.println(customer1.getName() + ": " + payment1);
        System.out.println(customer2.getName() + ": " + payment2);

        //Total-Revenue
        double totalRevenue = payment1.getTotalAmount() + payment2.getTotalAmount();
        System.out.println("\n~Total Revenue: $" + totalRevenue);
    }
}
