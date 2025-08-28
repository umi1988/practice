package DesignPattern.StructuralPatterns;

/**
 * Purpose: Dynamically adds responsibilities to objects in a flexible way.
 * Use Case: Adding features to objects, like adding toppings to a pizza.
 *
 *Explanation: The MilkDecorator adds milk to a SimpleCoffee,
 * extending its functionality without modifying the original class.
 */

interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double getCost() {
        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}

public class Decorator_Pattern_Example
{
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
        // Output: Simple Coffee, Milk $6.5
    }
}
