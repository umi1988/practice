package CountDownLatchExamples1;

import java.util.concurrent.*;

/**
 * By using CountDownLatch in threading concept we will allow main thread to wait and execute other services.
 */
public class CountDownLatch_Need_Example
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // our agenda is to execute all the service using f1.get(), f2.get(), f3.get()
        //Then main service will be executed - //System.out.println("All dependent services finished. Starting main services");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> f1 = executorService.submit(new DependentService());
        Future<String> f2 = executorService.submit(new DependentService());
        Future<String> f3 = executorService.submit(new DependentService());

        f1.get();
        f2.get();
        f3.get();

        System.out.println("All dependent services finished. Starting main services");
        executorService.shutdown();

    }
}

class  DependentService implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started");
        Thread.sleep(2000);
        return "ok";
    }
}
