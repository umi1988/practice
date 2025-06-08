class Counter1{
    int count;
    public synchronized void increment() {
        count++;
    }
}

public class RaceConditionSolutionInThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Counter1 c = new Counter1();
        Runnable t1 =  () ->{
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
    };
    Runnable t2 = () ->
    {
            for (int i = 0; i < 1000; i++) {
               c.increment();
            }
    };

    Thread th1 = new Thread(t1);
    Thread th2 = new Thread(t2);
    //t2.setPriority(Thread.MAX_PRIORITY);

    th1.start();
    th2.start();

    // join is the special method which allows main thread to wait for the other two thread to come back and join 
    th1.join();
    th2.join();

    System.out.println(c.count);

    // we should get 2k as output since we have added the synchronised keyword to make sure that this method will be called only one thread at a time.

    }
    
}
