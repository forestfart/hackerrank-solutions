package oracle.ocp.concurrent;

class Counter {
    static long count = 0;
}

class UseCounter implements Runnable {
    private void increment() {
        synchronized (this) {
            Counter.count++;
            System.out.printf("Counter is: %d, thread: %s\n", Counter.count, Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        increment();
        increment();
        increment();
    }
}

public class RaceCondition {
    public static void main(String[] args) {
        UseCounter useCounter = new UseCounter();
        Thread thread1 = new Thread(useCounter);
        Thread thread2 = new Thread(useCounter);
        Thread thread3 = new Thread(useCounter);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
