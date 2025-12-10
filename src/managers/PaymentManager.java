package managers;

import model.Customer;
import rental.Rental;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import exceptions.InvalidPaymentException;
import interfaces.Payable;

public class PaymentManager implements Payable {

    private List<PaymentRecord> paymentRecords;

    public PaymentManager() {
        this.paymentRecords = new ArrayList<>();
    }


    @Override
    public void processPayment(double amount) throws InvalidPaymentException {
        if (amount <= 0) {
            throw new InvalidPaymentException("Payment amount must be greater than zero.");
        }
        System.out.println("[PaymentManager] Processing payment of $" + amount);
    }

    public void makePayment(Customer customer, Rental rental, String method) throws InvalidPaymentException {
        if (customer == null || rental == null) {
            throw new InvalidPaymentException("Invalid payment: customer or rental is null.");
        }

        double amount = rental.getTotalCost();
        if (amount <= 0) {
            throw new InvalidPaymentException("Invalid payment amount: " + amount);
        }

       
        processPayment(amount);

        PaymentRecord record = new PaymentRecord(
                customer.getUserId(),
                rental.getRentalId(),
                amount,
                method,
                LocalDate.now()
        );

        paymentRecords.add(record);
        System.out.println("[PaymentManager] Payment recorded for " + customer.getName() +
                " | Amount: $" + amount + " | Method: " + method);
    }

  
    public List<PaymentRecord> getAllPayments() {
        return paymentRecords;
    }

    public List<PaymentRecord> getPaymentsByCustomer(Customer c) {
        if (c == null) return new ArrayList<>();
        List<PaymentRecord> results = new ArrayList<>();
        for (PaymentRecord pr : paymentRecords) {
            if (pr.getCustomerId() == c.getUserId()) {
                results.add(pr);
            }
        }
        return results;
    }


    public void displayAllPayments() {
        if (paymentRecords.isEmpty()) {
            System.out.println("[PaymentManager] No payments recorded.");
            return;
        }

        System.out.println("===== Payment Records =====");
        for (PaymentRecord p : paymentRecords) {
            p.displayPaymentInfo();
        }
    }


    public static class PaymentRecord {
        private int customerId;
        private int rentalId;
        private double amount;
        private String paymentMethod;
        private LocalDate paymentDate;

        public PaymentRecord(int customerId, int rentalId, double amount, String paymentMethod, LocalDate paymentDate) {
            this.customerId = customerId;
            this.rentalId = rentalId;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.paymentDate = paymentDate;
        }

        public void displayPaymentInfo() {
            System.out.println("CustomerID: " + customerId +
                    " | RentalID: " + rentalId +
                    " | Amount: $" + amount +
                    " | Method: " + paymentMethod +
                    " | Date: " + paymentDate);
        }

        public int getCustomerId() { return customerId; }
        public int getRentalId() { return rentalId; }
        public double getAmount() { return amount; }
        public String getPaymentMethod() { return paymentMethod; }
        public LocalDate getPaymentDate() { return paymentDate; }
    }
}
