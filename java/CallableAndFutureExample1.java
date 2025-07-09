package Thread;

import java.util.concurrent.*;

public class CallableAndFutureExample1
{
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Callable<String> callable_task = () -> {
            Thread.sleep(1000);
            return "Result from callable";
        };

        Future<String> future = es.submit(callable_task);
        System.out.println(" Doing other work ... ");
        try {
            System.out.println(" Received " +  future.get());// blocks until result is available
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        es.shutdown();
    }
}