package DesignPattern.CreationalPatterns;


/**
 * Purpose: Ensures a class has only one instance and provides a global point of access to it.
 * Use Case: Database connection pools, logging frameworks.
 *
 * Explanation: The Singleton class ensures only one instance exists by making the constructor
 * private and controlling instantiation through getInstance().
 * The synchronized keyword ensures thread safety.
 *
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }// Private constructor to prevent instantiation

    // Thread-safe singleton with lazy initialization
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton Instance!");
    }
}


public class SingletonPattern_Example
{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}
