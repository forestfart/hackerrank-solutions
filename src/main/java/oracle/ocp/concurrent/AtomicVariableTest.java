package oracle.ocp.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class CounterAtomic {
    public static Integer integer = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
}

public class AtomicVariableTest {
    static class Incremeter extends Thread {
        public void run() {
            CounterAtomic.integer++;
            CounterAtomic.atomicInteger.getAndIncrement();
        }
    }

    static class Decrementer extends Thread {
        public void run() {
            CounterAtomic.integer--;
            CounterAtomic.atomicInteger.decrementAndGet();
        }
    }

    public static void main(String[] args) {
        Thread[] threadIncrementer = new Incremeter[1000];
        Thread[] threadDecrementer = new Decrementer[1000];

        IntStream.range(0, 1000).forEach(i -> {
            threadIncrementer[i] = new Incremeter();
            threadDecrementer[i] = new Decrementer();
            threadIncrementer[i].start();
            threadDecrementer[i].start();
        });

        IntStream.range(0, 1000).forEach(i -> {
            try {
                threadIncrementer[i].join();
                threadDecrementer[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.printf("Integer value is: %d, AtomicInteger value is: %d",
                CounterAtomic.integer, CounterAtomic.atomicInteger.get());
    }

}
