package com.starttohkar.AbstractCLassDemo;

/*
- abstract class can have method abstract method and concrete method.
- abstract class object creation is not allowed, we need to create a concrete class and that class object we can create.
- abstract method can only be inside abstract class.
- abstract class can have only concrete method, but this we won't be able to use abstract keyword flavour.
- abstract class can have only abstract method, but then this would be done with the help of interface in java till JDK 7.
 */
 abstract class Car{ // abstract class
    public abstract void drive();
    public abstract  void fly();

    public void playMusic(){
        System.out.println("Playing Music...");
    }
}

abstract class Benz extends Car{ // abstract class
    @Override
    public void drive() {
        System.out.println("Driving...");
    }
}

class UpdatedBenz extends Benz{// concrete class
    @Override
    public void fly() {
        System.out.println("flying...");
    }
}

class AbstractCLassDemo{
    public static void main(String[] args) {
        Car car = new UpdatedBenz();
        car.drive();
        car.playMusic();
        car.fly();
    }
}