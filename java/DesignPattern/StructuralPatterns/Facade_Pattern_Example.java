package DesignPattern.StructuralPatterns;

/**
 * Purpose: Provides a simplified interface to a complex subsystem.
 * Use Case: Simplifying interactions with a complex library or framework.
 *
 *Explanation: The ComputerFacade simplifies interaction with the CPU, Memory,
 * and HardDrive classes by providing a single startComputer method.
 */

class CPU {
    public void start() {
        System.out.println("CPU started");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory loaded");
    }
}

class HardDrive {
    public void read() {
        System.out.println("Hard Drive reading");
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.read();
    }
}

public class Facade_Pattern_Example
{
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
        // Output:
        // CPU started
        // Memory loaded
        // Hard Drive reading
    }
}
