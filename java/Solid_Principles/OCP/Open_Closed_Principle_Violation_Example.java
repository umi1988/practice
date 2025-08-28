package Solid_Principles.OCP;

/**
 * Definition: Classes should be open for extension but closed for modification.
 *
 * Why it matters: OCP allows you to add new functionality without altering existing code,
 * reducing the risk of introducing bugs in stable components.
 *
 * Example:
 * A payment processing system that supports only one payment method (e.g., credit card) violates
 * OCP if you need to modify it to add new payment methods.
 */

// Violates OCP: Need to modify for new payment methods
class PaymentProcessor {
    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing credit card payment");
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Processing PayPal payment");
        }
    }
}

public class Open_Closed_Principle_Violation_Example {
    public static void main(String[] args) {
        //main method code
    }
}
