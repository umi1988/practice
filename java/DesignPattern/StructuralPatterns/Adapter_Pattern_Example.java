package DesignPattern.StructuralPatterns;

/**
 * Structural patterns focus on how objects and classes are composed to form larger structures.
 *
 * a. Adapter Pattern :-
 * Purpose: Converts the interface of a class into another interface that a client expects.
 *
 * Use Case: Integrating legacy systems with new systems.
 *
 * Explanation: The Adapter class bridges the gap between the NewSystem interface
 * and the LegacySystem, allowing the legacy code to work with the new interface.
 *
 */

interface NewSystem {
    void newRequest();
}

class LegacySystem {
    public void oldRequest() {
        System.out.println("Legacy System Request");
    }
}

class Adapter implements NewSystem {
    private LegacySystem legacySystem;

    public Adapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public void newRequest() {
        legacySystem.oldRequest();
    }
}

public class Adapter_Pattern_Example
{
    public static void main(String[] args) {
        LegacySystem legacy = new LegacySystem();
        NewSystem adapter = new Adapter(legacy);
        adapter.newRequest(); // Output: Legacy System Request
    }
}
