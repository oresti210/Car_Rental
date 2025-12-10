package payment;

import java.time.LocalDate;

public class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(int paymentId, int rentalId, double amount, LocalDate paymentDate, String method, String cardNumber) {
        super(paymentId, rentalId, amount, paymentDate, method);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Charging card ****" + (cardNumber.length()>4 ? cardNumber.substring(cardNumber.length()-4) : cardNumber) + " for " + amount);
    }
}
