package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample1
{
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        for(int i=0;i<=5;i++){
            final int task = i;
            es.submit(() -> {
                System.out.println("Executing task :- " + task + " on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        es.shutdown();
    }
}
