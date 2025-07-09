package Thread;

import java.util.concurrent.CountDownLatch;

/**
 * A CountDownLatch is a versatile synchronization tool and can be used for a number of purposes.
 * A CountDownLatch initialized with a count of one serves as a simple on/ off latch, or gate:
 * all threads invoking await wait at the gate until it is opened by a thread invoking countDown.
 *
 * A CountDownLatch initialized to N can be used to make one thread wait until N threads have completed
 * some action, or some action has been completed N times.
 *
 * A useful property of a CountDownLatch is that it doesn't require that threads calling countDown wait
 * for the count to reach zero before proceeding, it simply prevents any thread from proceeding past an
 * await until all threads could pass.
 */
public class CountDownLatchExample
{
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        for(int i=0;i<=3;i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " done.");
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All threads completed. Proceeding...");
    }
}
