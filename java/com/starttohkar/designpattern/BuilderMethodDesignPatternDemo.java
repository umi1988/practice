package com.starttohkar.designpattern;
/**
 The Builder design pattern is a way to build things step-by-step. It helps you make complicated
 things using a specific process. This pattern separates the building part from the final thing,
 so you can make different final things using the same process. The Builder pattern is useful when
 you want to make complicated things, but the process to make them is simple. It lets you make the
 thing little by little and then get the final thing when it's done.
 */

public class BuilderMethodDesignPatternDemo {
    public static void main(String[] args) {
        // create the director
        Director director = new Director();

        // create the builder
        Builder builder = new ConcreteBuilder();

        // construct the complex object
        director.construct(builder);

        // retrieve the finished product
        ComplexObject complexObject = builder.getResult();
    }
}

class ComplexObject {
    // fields for the complex object
}

class Director {
    public void construct(Builder builder) {
        // use the builder to construct the complex object
    }
}

abstract class Builder {
    // methods for constructing the complex object
    public abstract ComplexObject getResult();
}

class ConcreteBuilder extends Builder {
    private ComplexObject object = new ComplexObject();

    // methods for constructing the complex object
    public ComplexObject getResult() {
        return object;
    }
}
