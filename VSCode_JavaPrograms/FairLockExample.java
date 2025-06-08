import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*here the output is defined */
public class FairLockExample {
    
    private final Lock fairLock = new ReentrantLock(true);// this true made it FIFO - All the thread will get chance
    
    public void accessResource1(){
        fairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " aquired the lock");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally{
            System.out.println(Thread.currentThread().getName() + " release the lock");
            fairLock.unlock();
        }
    }
    
    public static void main(String[] args) {
        FairLockExample fair = new FairLockExample();
        
        Runnable task = new Runnable() {

            @Override
            public void run() {
                fair.accessResource1();
            }
        };
        Thread t11 = new Thread(task, "Thread11");
        Thread t22 = new Thread(task, "Thread22");
        Thread t33 = new Thread(task, "Thread33");

        t11.start();
        t22.start();
        t33.start();
    }
}

