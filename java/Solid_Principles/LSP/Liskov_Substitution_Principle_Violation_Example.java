package Solid_Principles.LSP;

/**
 * Definition: Subtypes must be substitutable for their base types without altering the
 * correctness of the program.
 *
 * Why it matters: LSP ensures that inheritance hierarchies are designed correctly,
 * so subclasses can be used in place of their parent classes without unexpected behavior.
 *
 * Example:
 * A Rectangle class with a Square subclass that overrides behavior inappropriately violates LSP.
 */

// Violates LSP
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getArea() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Forces height to equal width
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Forces width to equal height
    }
}

public class Liskov_Substitution_Principle_Violation_Example {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println(rectangle.getArea());// Expect 50, but get 100 (10*10)
    }
}
