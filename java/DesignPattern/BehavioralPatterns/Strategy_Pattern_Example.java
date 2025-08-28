package DesignPattern.BehavioralPatterns;

/**
 * Purpose: Defines a family of algorithms and makes them interchangeable.
 * Use Case: Sorting algorithms, payment methods.
 *
 *Explanation: The ShoppingCart uses different PaymentStrategy implementations interchangeably,
 * allowing flexible payment methods.
 */

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class Strategy_Pattern_Example
{
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100.0); // Output: Paid $100.0 via Credit Card

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(50.0); // Output: Paid $50.0 via PayPal
    }
}
