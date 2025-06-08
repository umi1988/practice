class BankAccount{
    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if(balance>= amount){
                System.out.println(Thread.currentThread().getName() + " proceeding to withdraw " );
             try {
                 Thread.sleep(10000);
             } catch (InterruptedException ex) {
            }
             balance -= amount; 
            System.out.println(Thread.currentThread().getName() + " completed withdrawl. Remaining balance: - " +  balance );
        }else{
            System.out.println(Thread.currentThread().getName() + " insufficient balance " );
        }
    }
}

public class ThreadSynchronization2Demo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {

            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();


    }
    
}
