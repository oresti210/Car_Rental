package interfaces;

import exceptions.InvalidPaymentException;

public interface Payable {
    void processPayment(double amount) throws InvalidPaymentException;
}
