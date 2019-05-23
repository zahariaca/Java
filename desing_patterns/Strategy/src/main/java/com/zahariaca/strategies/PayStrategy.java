package com.zahariaca.strategies;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 21.05.2019
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
