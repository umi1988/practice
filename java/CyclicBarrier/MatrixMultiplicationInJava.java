package CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Each thread calculates one row of the result matrix.
 *
 * After finishing its row, it calls barrier.await().
 *
 * The barrier action runs once all threads have reached it—printing the final matrix.
 *
 *
 */
public class MatrixMultiplicationInJava
{
    static int[][] A = {
            {1, 2},
            {3, 4}
    };
    static int[][] B = {
            {5, 6},
            {7, 8}
    };
    static int[][] result = new int[A.length][B[0].length];

    static CyclicBarrier barrier = new CyclicBarrier(A.length, () -> {
        System.out.println("All threads have finished computation!");
        System.out.println("Result matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    });

    static class Worker implements Runnable {
        private int row;

        public Worker(int row) {
            this.row = row;
        }

        @Override
        public void run() {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    result[row][j] += A[row][k] * B[k][j];
                }
            }
            try {
                barrier.await(); // Wait for other threads
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(A.length);

        for (int i = 0; i < A.length; i++) {
            executor.submit(new Worker(i));
        }

        executor.shutdown();
    }
}
