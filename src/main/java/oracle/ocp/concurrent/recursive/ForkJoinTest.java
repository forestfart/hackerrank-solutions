package oracle.ocp.concurrent.recursive;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
    private static long N = 2_000_000_000L;
    private static int numberOfThreads;

    static class RecursiveSumOfN extends RecursiveTask<Long> {
        long from, to;

        RecursiveSumOfN(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public Long compute() {
            if ((to - from) <= N / numberOfThreads) {
                long localSum = 0L;
                for (long i = from; i <= to; i++) {
                    localSum += i;
                }
                //Long localSum = LongStream.range(from, to+1).reduce(Long::sum).getAsLong(); // <<-- appears to be less efficient here
                System.out.printf("\t Summing of value range %d to %d is %d %n", from, to, localSum);
                return localSum;
            } else {
                long mid = (from + to) / 2;
                System.out.printf("Forking computation into two ranges: " + "%d to %d and %d to %d %n", from, mid, mid, to);

                RecursiveSumOfN firstHalf = new RecursiveSumOfN(from, mid);
                firstHalf.fork();

                RecursiveSumOfN secondHalf = new RecursiveSumOfN(mid + 1, to);
                long resultSecond = secondHalf.compute();

                return firstHalf.join() + resultSecond;
            }
        }
    }

    public static void main(String[] args) {
        int maximumNumberOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.printf("Number of available processors: %d\n", maximumNumberOfThreads);
        long formulaSum = (N * (N + 1)) / 2;

        HashMap<Integer, Long> executionTimings = new HashMap<>();
        for (numberOfThreads = 1; numberOfThreads <= maximumNumberOfThreads; numberOfThreads++) {
            System.out.printf("Number of threads for this test: %d\n", numberOfThreads);
            ForkJoinPool pool = new ForkJoinPool(numberOfThreads);

            long startTime = System.currentTimeMillis();
            long computedSum = pool.invoke(new RecursiveSumOfN(0, N)); //submit the computation task to the fork-join pool
            long executionTime = System.currentTimeMillis() - startTime;

            System.out.printf("Sum for range 1..%d; computed sum = %d, formula sum = %d \n", N, computedSum, formulaSum);
            System.out.printf("-----------------------------\nTime elapsed: %d ms\n\n", executionTime);
            executionTimings.put(numberOfThreads, executionTime);
        }
        System.out.printf("\nSummary:\n---------------------------\n%10s %10s", "threads", "time\n---------------------------\n");
        executionTimings.keySet().stream().sorted().forEach( threads -> System.out.printf("%8d %5d ms\n", threads, executionTimings.get(threads)));
    }

}
