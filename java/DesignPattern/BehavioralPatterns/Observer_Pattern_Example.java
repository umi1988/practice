package DesignPattern.BehavioralPatterns;


/**
 * Behavioral patterns manage object collaboration and communication.
 *
 * a. Observer Pattern
 * Purpose: Defines a one-to-many dependency where changes in one object notify all dependent objects.
 * Use Case: Event handling systems, like GUI frameworks.
 *
 * Explanation: The Subject maintains a list of Observer objects and notifies them when
 * its state changes.
 */

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class Observer_Pattern_Example
{
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new ConcreteObserver("Observer 1"));
        subject.addObserver(new ConcreteObserver("Observer 2"));

        subject.setMessage("Hello Observers!");
        // Output:
        // Observer 1 received: Hello Observers!
        // Observer 2 received: Hello Observers!
    }
}
