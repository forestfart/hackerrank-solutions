package oracle.ocp.concurrent;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationTest {
    static Instant start = Instant.now();

    static class Task1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Task #1");
        }
    }

    static class Task2 implements Callable<String> {

        @Override
        public String call() {
            System.out.println("Task #2");
            try {
                Thread.sleep(4500);
            } catch (InterruptedException e) {
                long elapsed = Duration.between(start, Instant.now()).toMillis();
                System.err.printf("Interrupted exception arrived after: %sms", elapsed);
            } finally {
                return "Passed the variable ;>";
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future future1 = pool.submit(new Task1());
        Future future2 = pool.submit(new Task2());

        pool.awaitTermination(4, TimeUnit.SECONDS);

        pool.shutdownNow();

        try {
            System.out.printf("\nFutures: #1: %s #2: %s", future1.get(), future2.get());
        } catch (ExecutionException e) {
            System.err.println("Unable to retrieve futures");
        }
    }
}
