class Counter123{
    private int count = 0;

    // this is critical section
    // with out using the synchronized keyword in the below method, the result was coming as everytime differently as the outcome depends on threads relative time since threads are running concurrently. This condition is called as race condition.
    public synchronized void increment(){ // by adding synchronized keyword we are making sure that only one thread will access it at once
        /*synchronized(this){ // synchronized block
            count++;
        }
            */
        count++;
    }

    // by adding synchronized keyword in the above method, we are making sure that only once the critical section can be executed by one thread. we are acheiving mutual exclusion to ensure that multiple threads won't be able to access the resouces simultaneousely.
    // by adding synchronized keyword in the above method, we are locking the shared resouces and this type of lock is called intrinsic lock(automatic lock)
    // two types of locks --> intrinsic lock, explicit lock
    // intrinsic lock(or automatic lock) -- > These are build into every object in java. we don't use them, but they're there. when we use synchronized keyword we are using these automatic locks.
    // explicit lock(or manual lock) --> These are more advanced locks we can control ourselves using the Lock class from java.util.concurrent.locks. we explicitly say when tto lock and unlock, giving us more control over how and when people can write in the notebook.

    public int getCount(){
        return count;
    }
}

class MyThread extends Thread{
    private Counter123 counter;

    public MyThread(Counter123 counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    
}

public class ThreadSynchronizationDemo {
    public static void main(String[] args) {
        Counter123 counter = new Counter123(); // counter object , it a shared resources -- 
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
        System.out.println(counter.getCount());

    }

    
    
}
