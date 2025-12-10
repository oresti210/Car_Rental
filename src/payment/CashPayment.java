package payment;

import java.time.LocalDate;

public class CashPayment extends Payment {
    private String receivedBy;

    public CashPayment(int paymentId, int rentalId, double amount, LocalDate paymentDate, String method, String receivedBy) {
        super(paymentId, rentalId, amount, paymentDate, method);
        this.receivedBy = receivedBy;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Received cash " + amount + " by " + receivedBy);
    }
}
