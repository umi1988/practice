import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();
    
    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer Method...");
            innerMethod();
        }finally{
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inner Method...");
        }finally{
            lock.unlock();
          //  lock.unlock(); //this will give exception 
        }
    }
    
    public static void main(String[] args) {
        ReentrantLockDemo r1 = new ReentrantLockDemo();
        r1.outerMethod();
    }
}
