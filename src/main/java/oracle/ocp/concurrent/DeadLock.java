package oracle.ocp.concurrent;

class Balls {
    public static long balls = 0;
}

class Runs {
    public static long runs = 0;
}

class CounterRunBalls implements Runnable {

    public void incrementBallsAfterRuns() {
        synchronized (Runs.class) {
            synchronized (Balls.class) {
                Runs.runs++;
                Balls.balls++;
            }
        }
    }

    public void incrementRunsAfterBalls() {
        synchronized (Balls.class) {
            synchronized (Runs.class) {
                Balls.balls++;
                Runs.runs++;
            }
        }
    }

    @Override
    public void run() {
        incrementBallsAfterRuns();
        incrementRunsAfterBalls();
    }
}

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        CounterRunBalls counterRunBalls = new CounterRunBalls();
        Thread thread1 = new Thread(counterRunBalls);
        Thread thread2 = new Thread(counterRunBalls);

        thread1.start();
        thread2.start();
        System.out.println("Waiting for threads to complete execution..");
        thread1.join();
        thread2.join();
        System.out.println("Done!");
    }

}
