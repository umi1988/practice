package DesignPattern.CreationalPatterns;

/**
 * Best Practice: Bill Pugh Singleton (Using Inner Static Class)
 *
 * Why this rocks:-
 * Lazy initialization
 * Thread-safe without synchronization
 * Clean and elegant
 *
 *
 */

class Singleton2 {
    private Singleton2() {}

    private static class Holder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return Holder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Singleton Instance!");
    }
}

public class Bill_Pugh_Singleton_Example
{
    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2.showMessage();
    }
}
