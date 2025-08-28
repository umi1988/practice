package DesignPattern.CreationalPatterns;

/**
 * Purpose: Separates the construction of a complex object from its representation.
 * Use Case: Building objects with many optional fields, like a configuration object.
 *
 * Explanation: The Builder class allows step-by-step construction of a Car object,
 * making it easy to create objects with optional attributes.
 */

class Car {
    private String engine;
    private String wheels;
    private String color;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.color = builder.color;
    }

    public static class Builder {
        private String engine;
        private String wheels;
        private String color;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheels(String wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", color=" + color + "]";
    }
}

public class Builder_Pattern_Example
{
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .setEngine("V8")
                .setWheels("Alloy")
                .setColor("Red")
                .build();
        System.out.println(car); // Output: Car [engine=V8, wheels=Alloy, color=Red]
    }
}
