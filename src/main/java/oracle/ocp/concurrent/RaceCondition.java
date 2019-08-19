package oracle.ocp.concurrent;

import java.util.ArrayList;
import java.util.List;

class Counter {
    static long count = 0;
}

class UseCounter implements Runnable {

    private List<Sddd> list;
    private static int xf;

    public UseCounter(List<Sddd> list) {
        this.list = list;
    }

    private synchronized void increment() {
        Counter.count++;
        System.out.printf("Counter is: %d, thread: %s\n", Counter.count, Thread.currentThread().getName());
        list.add(new UseCounter.Sddd("instance-" + xf++));


    }

    @Override
    public void run() {
        increment();
        increment();
        increment();
    }

    static class Sddd {
        String string;
        public Sddd(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        List<UseCounter.Sddd> list = new ArrayList<>();

        UseCounter useCounter = new UseCounter(list);
        Thread thread1 = new Thread(useCounter);
        Thread thread2 = new Thread(useCounter);
        Thread thread3 = new Thread(useCounter);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        list.stream().forEach(System.out::println);
        list.forEach(System.out::println);
    }

}
