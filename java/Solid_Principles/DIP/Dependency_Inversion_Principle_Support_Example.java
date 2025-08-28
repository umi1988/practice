package Solid_Principles.DIP;

/**
 * Refactored to follow DIP:
 * Introduce an abstraction (interface) and inject the dependency.
 *
 * System Design Benefit: DIP enables dependency injection and inversion of control,
 * which are critical in frameworks like Spring, allowing systems to swap implementations
 * (e.g., database providers) without changing business logic.
 *
 */
interface MessageService {
    void sendMessage(String message);
}

class EmailService1 implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class Notification1 {
    private MessageService messageService;

    public Notification1(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String message) {
        messageService.sendMessage(message);
    }
}

public class Dependency_Inversion_Principle_Support_Example {
    public static void main(String[] args) {
        Notification1 emailNotification = new Notification1(new EmailService1());
        emailNotification.send("Hello via Email");

        Notification1 smsNotification = new Notification1(new SMSService());
        smsNotification.send("Hello via SMS");
    }
}
