package Solid_Principles.SRP;


/**
 *Refactored to follow SRP:
 * Split the responsibilities into separate classes.
 *
 * System Design Benefit: In a large system, separating concerns (e.g., data access,
 * business logic, and presentation) ensures that changes in one area (e.g., database schema)
 * don’t ripple through unrelated components.
 *
 */
// Responsible for employee data
class Employee1 {
    private String name;
    private double salary;

    public String getName() { return name; }
    public double getSalary() { return salary; }
}

// Responsible for persistence
class EmployeeRepository {
    public void saveToDatabase(Employee1 employee) {
        System.out.println("Saving " + employee.getName() + " to database");
    }
}

// Responsible for report generation
class EmployeeReportGenerator {
    public void generateReport(Employee1 employee) {
        System.out.println("Generating report for " + employee.getName());
    }
}

public class Single_Responsibility_Principle_Support_Example {
    public static void main(String[] args) {
        //main method call
    }
}
