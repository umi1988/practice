package Solid_Principles.ISP;

/**
 *
 * Definition: Clients should not be forced to depend on interfaces they do not use.
 *
 * Why it matters: ISP prevents classes from being bloated with unnecessary methods,
 * making them easier to implement and maintain.
 *
 * Example:
 * A single interface for all worker types forces unrelated functionality on certain classes.
 *
 */

// Violates ISP
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        System.out.println("Robot is working");
    }

    public void eat() {
        // Robots don't eat, but forced to implement
        throw new UnsupportedOperationException("Robots don't eat");
    }
}

public class Interface_Segregation_Principle_Violation_Example
{
    public static void main(String[] args) {
        //main method code
    }
}
