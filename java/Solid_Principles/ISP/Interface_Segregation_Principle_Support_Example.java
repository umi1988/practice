package Solid_Principles.ISP;

/**
 * Refactored to follow ISP:
 * Split the interface into smaller, specific ones.
 *
 * System Design Benefit: ISP promotes modular designs, such as in APIs or microservices,
 * where clients only depend on the specific interfaces they need, reducing coupling.
 *
 */
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }
}

class Robot1 implements Workable {
    public void work() {
        System.out.println("Robot is working");
    }
}

public class Interface_Segregation_Principle_Support_Example {
    public static void main(String[] args) {
        //main method
    }
}
