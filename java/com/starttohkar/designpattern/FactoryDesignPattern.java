package com.starttohkar.designpattern;

/**
 * The Factory Method pattern is a way to make things without saying exactly what kind of thing to make
 *
 * To implement the Factory Pattern, we will need to:-
 * 1>Define an interface or abstract class that declares the factory method for creating objects.
 * 2>Create concrete classes that implement the interface or abstract class and provide their own
 *              implementation of the factory method.
 * 3>Define a client class that uses the factory method to create objects without knowing their exact class.
 */

interface Animal{
    void speak();
}

class Dog implements Animal{
    @Override
    public void speak(){
        System.out.println("Dog Says:- - Bow Bow");
    }
}
class Cat implements Animal{
    @Override
    public void speak(){
        System.out.println("Cat Says:- - Meow Meow");
    }
}

interface AnimalFactory {
    Animal createAnimal();
}
class DogFactory implements AnimalFactory{
    @Override
    public Animal createAnimal(){
        return new Dog();
    }
}

class CatFactory implements AnimalFactory{
    @Override
    public Animal createAnimal(){
        return new Cat();
    }
}

public class FactoryDesignPattern{
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.speak();

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.speak();
    }
}

