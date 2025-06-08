
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount1{
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw1(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS))
            {
            if(balance>= amount){
                try{
                     System.out.println(Thread.currentThread().getName() + " proceeding to withdraw " );
                     Thread.sleep(3000);
                     balance -= amount; 
                     System.out.println(Thread.currentThread().getName() + " completed withdrawl. Remaining balance: - " +  balance );
                }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                }finally{
                        lock.unlock();
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " insufficient balance " ); 
            }
           }else{
            System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later " ); 
        }
        } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        }
    }
}

public class ThreadSynchronizationWithExplicitLockDemo {
    public static void main(String[] args) {
        BankAccount1 bankAccount = new BankAccount1();
        Runnable task = new Runnable() {

            @Override
            public void run() {
                bankAccount.withdraw1(50);
            }
        };

        Thread thread11 = new Thread(task, "Thread 1");
        Thread thread22 = new Thread(task, "Thread 2");

        thread11.start();
        thread22.start();


    }
    
}
