package DesignPattern.CreationalPatterns;

/**
 * Purpose: Defines an interface for creating objects but lets subclasses decide which class to
 * instantiate.
 * Use Case: Creating objects without specifying the exact class, e.g., UI component factories.
 *
 * Explanation: The AnimalFactory abstract class defines a method for creating Animal objects,
 * but concrete factories (DogFactory, CatFactory) decide which specific class to instantiate.
 */

interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meow!");
    }
}

abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Cat();
    }
}

public class Factory_Method_Pattern_Example
{
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.speak(); // Output: Woof!

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.speak(); // Output: Meow!
    }
}
