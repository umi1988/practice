package DesignPattern.BehavioralPatterns;

/**
 * Purpose: Encapsulates a request as an object, allowing parameterization and queuing.
 * Use Case: Undo/redo functionality, task scheduling.
 *
 *Explanation: The Command interface encapsulates a request (TurnOnLightCommand),
 * and the RemoteControl invokes it.
 */

interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Command_Pattern_Example
{
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnLightCommand(light);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOn);
        remote.pressButton(); // Output: Light is ON
    }
}
