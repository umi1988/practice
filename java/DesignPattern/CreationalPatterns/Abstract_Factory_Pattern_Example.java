package DesignPattern.CreationalPatterns;


/**
 * Purpose: Provides an interface for creating families of related objects without specifying their concrete classes.
 * Use Case: Creating UI kits for different platforms (e.g., Windows, macOS).
 *
 *Explanation: The GUIFactory creates families of related objects (e.g., buttons and checkboxes for Windows or Mac),
 * ensuring compatibility within the family.
 *
 */

interface Button {
    void render();
}

interface Checkbox {
    void check();
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Windows Checkbox");
    }
}

class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Mac Checkbox");
    }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class Abstract_Factory_Pattern_Example
{
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.render(); // Output: Rendering Windows Button
        checkbox.check(); // Output: Checking Windows Checkbox
    }
}
