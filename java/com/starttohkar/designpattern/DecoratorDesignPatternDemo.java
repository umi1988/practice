package com.starttohkar.designpattern;
/**
 * The Decorator pattern is a way to add new things to an object without changing how it
 * looks or works. You make a new class that goes around the old object and adds new stuff to it.
 *
 * To implement the Decorator Pattern, we will need to:
 *
 * Create an interface or abstract class that defines the methods to be implemented
 *              by both the original object and the decorator.
 * Create a concrete class that implements the interface or abstract class and
 *              represents the original object.
 * Create a decorator class that implements the same interface or abstract class and
 *              contains an instance of the original object.
 * Implement the methods of the interface or abstract class in the decorator class by
 *              calling the appropriate methods of the original object instance and adding new functionality.
 */

// Interface or abstract class
interface Car {
    void assemble();
}

// Concrete class that implements the Car interface
class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Basic Car.");
    }
}

// Decorator class that implements the Car interface and contains an instance of the Car interface
class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}

// Concrete decorator class that adds new functionality to the original object
class SportsCarDecorator extends CarDecorator {
    public SportsCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Sports Car.");
    }
}

// Client code
public class DecoratorDesignPatternDemo {
    public static void main(String[] args) {
        Car basicCar = new BasicCar();
        basicCar.assemble();

        Car sportsCar = new SportsCarDecorator(new BasicCar());
        sportsCar.assemble();
    }
}



