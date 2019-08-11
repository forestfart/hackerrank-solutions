package oracle.ocp.concurrent.recursive;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private static int MAX;
    private static int NUMBER_OF_THREADS;
    private int low;
    private int high;
    private int[] array;

    private SumTask(int[] arr, int lo, int hi) {
        array = arr;
        low = lo;
        high = hi;
    }

    @Override
    public Long compute() {
        if(high - low <= MAX / SumTask.NUMBER_OF_THREADS) {
            long sum = 0;
            for(int i = low; i <high; ++i) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = low + (high - low) / 2;
            SumTask left = new SumTask(array, low, mid);
            left.fork();
            SumTask right = new SumTask(array, mid, high);
            long rightAnswer = right.compute();
            long leftAnswer = left.join();
            System.out.println(leftAnswer + " + " + rightAnswer);
            return leftAnswer + rightAnswer;
        }
    }

    public static void main(String[] args) {
        SumTask.NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
        SumTask.MAX = 50_000;
        int[] array = new int[SumTask.MAX];
        array[1] = 10;
        array[37_997] = 45;
        SumTask sumTask = new SumTask(array, 0, SumTask.MAX);

        ForkJoinPool pool = new ForkJoinPool(SumTask.NUMBER_OF_THREADS);

        long result = pool.invoke(sumTask);

        System.out.printf("Result is: %d, computed with use of %d threads.", result, SumTask.NUMBER_OF_THREADS);
    }
}
