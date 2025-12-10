package payment;

import java.time.LocalDate;
import interfaces.Payable;

public class Payment implements Payable {
    protected int paymentId;
    protected int rentalId;
    protected double amount;
    protected LocalDate paymentDate;
    protected String method;

    public Payment(int paymentId, int rentalId, double amount, LocalDate paymentDate, String method) {
        this.paymentId = paymentId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " by " + method);
    }

    public void displayPaymentInfo() {
        System.out.println("Payment " + paymentId + ": amount=" + amount + ", method=" + method);
    }
}
