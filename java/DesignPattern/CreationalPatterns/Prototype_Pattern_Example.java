package DesignPattern.CreationalPatterns;

/**
 * Purpose: Creates new objects by copying an existing object (prototype).
 * Use Case: When object creation is costly, e.g., cloning database connections.
 *
 *Explanation: The Prototype class implements Cloneable to create a copy of itself,
 * allowing efficient object creation without re-initializing.
 */


class Prototype implements Cloneable {
    private String data;

    public Prototype(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

public class Prototype_Pattern_Example
{
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype original = new Prototype("Original Data");
        Prototype cloned = original.clone();
        cloned.setData("Cloned Data");

        System.out.println(original.getData()); // Output: Original Data
        System.out.println(cloned.getData()); // Output: Cloned Data
    }
}
