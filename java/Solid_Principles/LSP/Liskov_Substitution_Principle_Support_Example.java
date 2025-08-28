package Solid_Principles.LSP;

/**
 *
 * Refactored to follow LSP:
 * Avoid inheritance if the subclass cannot fully substitute the parent. Instead, use a different
 * approach, such as a common interface.
 *
 * System Design Benefit: LSP ensures polymorphic behavior in systems (e.g., plugin architectures)
 * where components must be interchangeable without breaking functionality.
 *
 */

interface Shape {
    int getArea();
}

class Rectangle1 implements Shape {
    private int width;
    private int height;

    public Rectangle1(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() { return width * height; }
}

class Square1 implements Shape {
    private int side;

    public Square1(int side) {
        this.side = side;
    }

    public int getArea() { return side * side; }
}

public class Liskov_Substitution_Principle_Support_Example {
    public static void main(String[] args) {
        Shape rectangle1 = new Rectangle1(5, 10);
        Shape square1 = new Square1(5);
        System.out.println(rectangle1.getArea()); // 50
        System.out.println(square1.getArea()); // 25
    }
}
