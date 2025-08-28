package DesignPattern.CreationalPatterns;

/**
 * Pros:
 * Simple and effective
 * Ensures thread safety
 *
 * Cons:
 * synchronized adds overhead every time getInstance() is called—even after the instance
 * is initialized
 *
 *
 * Why it's better:
 * Uses volatile to prevent instruction reordering
 * Synchronization only happens once during initialization
 *
 *
 */
class Singleton1 {
    private static volatile Singleton1 instance;

    private Singleton1() {}

    public static Singleton1 getInstance() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton Instance!");
    }
}
public class SingletonPattern_Double_Checked_Locking
{
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        singleton1.showMessage();
    }
}
