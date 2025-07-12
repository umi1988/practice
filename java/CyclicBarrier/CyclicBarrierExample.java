package CyclicBarrier;


import java.util.concurrent.*;

/**
 *CountDownLatch is not a reusable...once the count reaches zero, it can't be reset.
 * If we want to achieve reusable CountDownLatch use case then instead of CountDownLatch you
 * need to use CyclicBarrier
 *
 * CyclicBarrier doesn't block main thread.
 *
 * A CyclicBarrier is a synchronizer that allows a set of threads to wait for each other to reach a
 * common execution point, also called a barrier.
 *
 * CyclicBarriers are used in programs in which we have a fixed number of threads that must wait for
 * each other to reach a common point before continuing execution.
 *
 * The barrier is called cyclic because it can be re-used after the waiting threads are released.
 *
 * The threads that need to synchronize their execution are also called parties and calling
 * the await() method is how we can register that a certain thread has reached the barrier point.
 *
 * This call is synchronous and the thread calling this method suspends execution till a specified number
 * of threads have called the same method on the barrier. This situation where the required number of
 * threads have called await(), is called tripping the barrier.
 *
 *
 * cyclicbarrier in java real time example:-
 * Here's a real-time example of CyclicBarrier in Java:
 *
 * Data aggregation in a financial analytics platform:-
 * Imagine a financial analytics platform that collects and processes data from various sources such
 * as stock prices, foreign exchange (forex) rates, and commodity prices. Each data source is handled
 * by a different thread, operating independently. However, to provide a consistent and unified snapshot
 * of the data, all sources must synchronize at specific intervals.
 *
 * Here's how CyclicBarrier can be used:-
 * Initialization: A CyclicBarrier is created with the number of data sources (threads) as the parties
 *                  argument. An optional Runnable action (barrier action) is passed, which gets executed
 *                  once all threads reach the barrier. In this example, the barrier action would be to
 *                  aggregate the data from all sources.
 * Thread Execution: Each thread (data source) fetches its respective data.
 * Synchronization: Once a thread has finished fetching its data, it calls CyclicBarrier.await().
 *                  This suspends the thread until the other data source threads also call await().
 * Barrier Tripping: When the last thread (data source) calls await(), the barrier is tripped,
 *                  meaning all threads have reached the synchronization point.
 * Barrier Action Execution: The Runnable action (data aggregation) is executed. This ensures that the
 *                      aggregation happens only when all data sources are ready, preventing inconsistencies.
 * Release and Reset: All the waiting threads are released and can proceed to the next phase of
 *                      their operation. The CyclicBarrier automatically resets its internal count,
 *                      allowing it to be reused for the next synchronization cycle, which might involve
 *                      fetching data again after a delay.
 *
 * In essence, the CyclicBarrier ensures that a set of threads wait for each other at a common point
 *              before continuing execution, according to Medium. This makes it ideal for iterative and
 *              phased tasks like data aggregation in real-time analytics platforms, guaranteeing that
 *              each phase begins only when all necessary data has been gathered.
 *
 * Example code (simplified)
 * A simplified example of how CyclicBarrier can be used for data aggregation is provided in the referenced documents.
 * Benefits
 *
 * Using CyclicBarrier in this scenario offers several benefits:
 * Ensures data consistency: Data aggregation occurs only when all sources are ready,
 *                          preventing the use of outdated data.
 * Simplifies multi-threaded synchronization: Threads can synchronize by simply calling await(),
 *                                  with CyclicBarrier managing the logic.
 * Reusability: The barrier automatically resets after being tripped, enabling repeated synchronization
 *              in iterative tasks.
 * Barrier action support: An optional Runnable can be executed once all threads reach the
 *                          barrier, facilitating tasks like logging or status updates.
 * Overall, CyclicBarrier is well-suited for scenarios with multiple phases of execution where
 * threads need to align at each stage to ensure synchronized progress.
 *
 *
 *
 *
 *
 *
 * A real-time example of CyclicBarrier in Java involves a scenario where multiple threads need to
 * synchronize their execution at a common point before proceeding to the next phase of a task.
 *
 * Example: A Multi-Stage Data Processing Pipeline
 * Imagine a system that processes data in multiple stages, where each stage depends on the
 * completion of the previous stage by all participating threads.
 *
 * Stage 1: Data Preparation:
 * Multiple worker threads (e.g., ThreadA, ThreadB, ThreadC) are responsible for preparing different
 * subsets of raw data. This could involve cleaning, parsing, or transforming data from various sources.
 *
 * Barrier Point 1 (CyclicBarrier):
 * After completing their individual data preparation tasks, all threads must synchronize at a CyclicBarrier.
 * This ensures that no thread proceeds to the next stage until all data preparation is complete.
 * A Runnable action can be executed at this point, for example, to log that all data is ready for
 * processing.
 *
 * Stage 2: Data Analysis:
 * Once all threads have reached the first barrier, they can proceed to the data analysis stage.
 * Each thread might perform specific analytical operations on its prepared data subset.
 *
 * Barrier Point 2 (CyclicBarrier):
 * After completing their data analysis, the threads synchronize at a second CyclicBarrier
 * (or reuse the same one). This ensures that all analysis is complete before combining the results.
 * Again, a Runnable can be executed here to trigger the aggregation of results.
 *
 * Stage 3: Result Aggregation:
 * Finally, after the second barrier is tripped, the threads (or a designated thread) can aggregate
 * the analyzed data to produce a final report or insight.
 *
 * Why CyclicBarrier is suitable:-
 *
 * Synchronization:
 * It forces all threads to wait at a specific point until all participating threads have arrived.
 * Reusability:
 * The same CyclicBarrier instance can be reused for multiple synchronization points within a cyclic process,
 *          such as the multi-stage pipeline described above.
 * Barrier Action:
 * It allows for a Runnable to be executed when the barrier is tripped, enabling actions like logging,
 * validation, or triggering the next phase.
 */
public class CyclicBarrierExample
{
    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3;
        ExecutorService es_cyb = Executors.newFixedThreadPool(numberOfServices);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfServices);
        es_cyb.submit(new DependentService10(cyclicBarrier));
        es_cyb.submit(new DependentService10(cyclicBarrier));
        es_cyb.submit(new DependentService10(cyclicBarrier));

        System.out.println("Main");
        //cyclicBarrier.reset();
        //System.out.println(cyclicBarrier.getParties());
        //System.out.println(cyclicBarrier.getNumberWaiting());

        es_cyb.shutdown();


    }
}

class  DependentService10 implements Callable<String> {

    private final CyclicBarrier barrier;

    public DependentService10(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started. ");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " is waiting at the barrier. ");
            //Thread.sleep(5000);
            barrier.await();
        }catch (Exception e){}
        return "ok";
    }
}
