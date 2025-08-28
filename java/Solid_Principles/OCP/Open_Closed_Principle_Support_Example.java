package Solid_Principles.OCP;

/**
 * Refactored to follow OCP:
 * Use an interface to allow new payment methods to be added without modifying the existing code.
 *
 * System Design Benefit: In a microservices architecture, OCP enables you to add new
 * features (e.g., new payment gateways) by deploying new modules without altering existing services.
 */

interface PaymentMethod {
    void processPayment();
}

class CreditCardPayment implements PaymentMethod {
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}

class PayPalPayment implements PaymentMethod {
    public void processPayment() {
        System.out.println("Processing PayPal payment");
    }
}

class PaymentProcessor1 {
    public void process(PaymentMethod paymentMethod) {
        paymentMethod.processPayment();
    }
}
public class Open_Closed_Principle_Support_Example {
    public static void main(String[] args) {
        // main method code
        PaymentProcessor1 processor = new PaymentProcessor1();
        processor.process(new CreditCardPayment()); // Extensible for new payment methods
        processor.process(new PayPalPayment());
    }
}
