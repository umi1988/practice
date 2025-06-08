
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  here the output is not defined*/

public class UnfairLockExample {

    private final Lock unfairLock = new ReentrantLock();
    
    public void accessResource(){
        unfairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " aquired the lock");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally{
            
            System.out.println(Thread.currentThread().getName() + " release the lock");
            unfairLock.unlock();
        }
    }
    
    public static void main(String[] args) {
        UnfairLockExample unfair = new UnfairLockExample();
        
        Runnable task = new Runnable() {

            @Override
            public void run() {
                unfair.accessResource();
            }
        };
        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        Thread t3 = new Thread(task, "Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}
