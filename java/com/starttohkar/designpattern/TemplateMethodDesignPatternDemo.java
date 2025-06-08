package com.starttohkar.designpattern;
/**
 The Template Method pattern is a way to design things that lets you make a list of steps to do something,
    but some of the steps can be done in different ways. You start by making a base list of steps,
    then you make a main step that tells the other steps to run. Each step can be different, and they
    all work together to do the thing you want to do.

 To implement the Template Pattern, we will need to:

 Create an abstract base class that defines a template method. The template method should call other
            methods (abstract or concrete) to perform specific steps of the algorithm.
 Define abstract methods in the base class for the steps that need to be implemented by subclasses.
 Create concrete subclasses that implement the abstract methods to provide specific implementations
            for the steps.
 Client code can create an instance of the concrete subclass and call the template method to execute
            the algorithm.
 */

// Abstract base class with a template method
abstract class AbstractClass {
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    protected abstract void step1();
    protected abstract void step2();
    protected abstract void step3();
}

// Concrete subclass that provides specific implementations for the steps
class ConcreteClass extends AbstractClass {
    protected void step1() {
        System.out.println("ConcreteClass: step 1");
    }

    protected void step2() {
        System.out.println("ConcreteClass: step 2");
    }

    protected void step3() {
        System.out.println("ConcreteClass: step 3");
    }
}

// Client code
public class TemplateMethodDesignPatternDemo {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
