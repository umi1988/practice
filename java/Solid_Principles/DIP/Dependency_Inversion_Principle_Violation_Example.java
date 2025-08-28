package Solid_Principles.DIP;

/**
 * Definition: High-level modules should not depend on low-level modules.
 * Both should depend on abstractions. Abstractions should not depend on details;
 * details should depend on abstractions.
 *
 * Why it matters: DIP reduces coupling between components, making systems more flexible
 * and easier to test or modify.
 *
 * Example:
 * A notification system tightly coupled to a specific messaging service violates DIP.
 */

// Violates DIP
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class Notification {
    private EmailService emailService = new EmailService();

    public void send(String message) {
        emailService.sendEmail(message);
    }
}

public class Dependency_Inversion_Principle_Violation_Example
{
    public static void main(String[] args) {

    }
}
