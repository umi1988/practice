package DesignPattern.StructuralPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: Treats individual objects and compositions of objects uniformly.
 * Use Case: Representing hierarchical structures, like file systems.
 *
 * Explanation: The Composite class allows treating individual Leaf objects
 * and groups of objects (Composite) uniformly.
 *
 */

interface Component {
    void show();
}

class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Leaf: " + name);
    }
}

class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private String name;

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void show() {
        System.out.println("Composite: " + name);
        for (Component component : components) {
            component.show();
        }
    }
}
public class Composite_Pattern_Example
{
    public static void main(String[] args) {
        Composite root = new Composite("Root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite sub = new Composite("Sub");
        sub.add(new Leaf("Leaf C"));
        root.add(sub);

        root.show();
        // Output:
        // Composite: Root
        // Leaf: Leaf A
        // Leaf: Leaf B
        // Composite: Sub
        // Leaf: Leaf C
    }
}
