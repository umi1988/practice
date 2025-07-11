package CountDownLatchExamples1;

import java.util.concurrent.*;

public class LatchWithThreads {// CountDownLatch without executor
        public static void main (String[]args) throws InterruptedException {
            int numberOfServices = 3;
           // ExecutorService executorService1 = Executors.newFixedThreadPool(numberOfServices);
            CountDownLatch latch = new CountDownLatch(numberOfServices);// count down meaning counting 10 to 0 and latch meaning is kundi/tala(lock)
            /*executorService1.submit(new DependentService2(latch));
            executorService1.submit(new DependentService2(latch));
            executorService1.submit(new DependentService2(latch));*/
            for (int i =0 ;i< numberOfServices;i++){
                new Thread(new DependentService2(latch)).start();
            }
            latch.await();
           // latch.await(5, TimeUnit.SECONDS);

            System.out.println("Main");
            //executorService1.shutdown();

        }
    }

    class DependentService2 implements Runnable {

        private final CountDownLatch latch;

        public DependentService2(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run()  {
            try {
                System.out.println(Thread.currentThread().getName() + " service started ");
                Thread.sleep(2000);
            } catch (Exception e){

            } finally{
                latch.countDown();
            }
        }
    }


