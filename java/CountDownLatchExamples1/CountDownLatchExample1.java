package CountDownLatchExamples1;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * By using CountDownLatch in threading concept we will allow main thread to wait and execute other services.
 * We will use CountDownLatch when we need to allow to wait for 1 or more no of threads to complete the task by other threads.
 *
 * Google defination-
 * In Java's concurrent programming, CountDownLatch is a synchronization aid that allows one or more
 * threads to wait until a set of operations being performed by other threads completes.
 * It is part of the java.util.concurrent package, which was introduced in Java 5.
 *
 * A CountDownLatch operates based on a count initialized upon creation.
 * Threads performing operations decrement this count by calling countDown().
 * Other threads waiting for these operations to finish call await(),
 * which blocks until the count reaches zero. Once the count hits zero, waiting threads are released.
 *
 * Key features and usage:-
 * 1> CountDownLatch is for single synchronization events and cannot be reset. For reusable synchronization,
 * consider CyclicBarrier or Semaphore.
 * 2> It blocks threads until the countdown finishes.
 * 3> It provides unidirectional synchronization, where threads wait for events,
 * but it doesn't coordinate multiple phases.
 *
 * Practical applications: -
 * 1> It's useful in scenarios like system startup to ensure services are ready,
 * parallel processing to wait for subtasks to complete before combining results,
 * and testing concurrent code to simulate real-world behavior.
 * 2>CountDownLatch helps coordinate threads, allowing tasks to proceed only after prerequisites are met.
 */
public class CountDownLatchExample1 {
    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3;
        ExecutorService executorService1 = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices);// count down meaning counting 10 to 0 and latch meaning is kundi/tala(lock)
        executorService1.submit(new DependentService1(latch));
        executorService1.submit(new DependentService1(latch));
        executorService1.submit(new DependentService1(latch));
        latch.await();

        System.out.println("Main");
        executorService1.shutdown();
        //executorService1.shutdownNow();

    }
}

class  DependentService1 implements Callable<String> {

    private final CountDownLatch latch;

    public DependentService1(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started ");
            Thread.sleep(2000);
        }finally {
            latch.countDown();
        }
        return "ok";
    }
}
