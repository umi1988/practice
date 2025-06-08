package com.starttohkar.designpattern;
/**
 The Command pattern is a way to organize and control requests in a computer program.
        Instead of directly giving instructions, we use objects called commands to represent and
        execute our requests. This helps us use different requests with different clients, keep
        a record of previous requests, and even undo previous actions. We create an
        interface or a class to define how commands should be executed, and then create different
        classes to represent different types of commands.

 To implement the Command Pattern, we will need to:

 Create a Command interface or abstract class that defines the execute method.
 Create concrete classes that implement the Command interface and represent different commands.
            These classes should contain a reference to the receiver object that will execute the command.
 Create an invoker class that will execute the commands by calling their execute method.
 Client code should create instances of the concrete Command classes and pass them to the invoker class.
 */


// Command interface
interface Command {
    void execute();
}

// Concrete command classes
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver class
class Light {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
public class CommandDesignPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
    }
}

