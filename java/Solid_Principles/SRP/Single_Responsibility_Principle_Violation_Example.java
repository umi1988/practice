package Solid_Principles.SRP;

/**
 * Definition: A class should have only one reason to change, meaning it should have only
 * one responsibility or job.
 *
 * Why it matters: SRP reduces the complexity of a class by ensuring it focuses on a single task.
 * This makes the class easier to understand, maintain, and test, and minimizes the impact of
 * changes.
 *
 * Example:
 * Consider a class that handles both employee data persistence and report generation.
 * This violates SRP because it has multiple responsibilities.
 *
 */
// Violates SRP: Handles both persistence and report generation

class Employee {
    private String name;
    private double salary;

    public void saveToDatabase() {
        // Code to save employee to database
        System.out.println("Saving " + name + " to database");
    }

    public void generateReport() {
        // Code to generate a report
        System.out.println("Generating report for " + name);
    }
}

public class Single_Responsibility_Principle_Violation_Example {
    public static void main(String[] args) {
        //main method call
    }
}
