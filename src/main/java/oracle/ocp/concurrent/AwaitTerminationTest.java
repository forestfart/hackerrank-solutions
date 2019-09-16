package oracle.ocp.concurrent;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    static class Task2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Task #2");
            try {
                Thread.sleep(4500);
            } catch (InterruptedException e) {
                long elapsed = Duration.between(start, Instant.now()).toMillis();
                System.err.printf("Interrupted exception arrived after: %sms", elapsed);;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(new Task1());
        pool.submit(new Task2());

        pool.awaitTermination(4, TimeUnit.SECONDS);

        pool.shutdownNow();
    }
}
