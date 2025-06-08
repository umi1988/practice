package com.starttohkar.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * The Observer pattern is a way for objects to talk to each other.
 * It's like when you tell your friends about something, and they all know what's going on.
 * It's used when many objects need to know when something happens to one object.
 *
 * To implement the Observer Pattern, we will need to:
 *
 * Define an interface for the Observer objects that specifies the method(s) to be called
 *              when the state of the observed object changes.
 * Define an interface for the Subject (observed) object that allows Observer objects to register,
 *              remove, and notify them about changes.
 * Create concrete Observer classes that implement the Observer interface and provide their own
 *              implementation of the update method.
 * Create a concrete Subject class that implements the Subject interface and maintains a list of
 *              registered Observer objects. This class also provides methods to modify the state of
 *              the object, which triggers notifications to all registered Observers.
 *
 */


// Observer interface
interface Observer {
    void update(int value);
}

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Observer class
class ConcreteObserver implements Observer {
    @Override
    public void update(int value) {
        System.out.println("Value changed to " + value);
    }
}

// Concrete Subject class
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int value;

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(value);
        }
    }
}

// Client code
public class ObserverDesignPatterDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        // Create observers and register them
        Observer observer1 = new ConcreteObserver();
        subject.registerObserver(observer1);

        Observer observer2 = new ConcreteObserver();
        subject.registerObserver(observer2);

        // Modify the value of the subject, which triggers notifications to all observers
        subject.setValue(10);

        // Remove one observer and modify the value again
        subject.removeObserver(observer1);
        subject.setValue(20);
    }
}
