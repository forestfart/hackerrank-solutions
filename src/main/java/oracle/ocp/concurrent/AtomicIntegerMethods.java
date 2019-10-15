package oracle.ocp.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMethods {

    AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {
        AtomicIntegerMethods aim = new AtomicIntegerMethods();

        System.out.println(aim.atomicInteger.addAndGet(5));

    }
}

class MyThready implements Runnable {
    private static AtomicInteger count = new AtomicInteger(0);
    public void run() {
        int x = count.incrementAndGet();
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThready());
        Thread thread2 = new Thread(new MyThready());
        Thread thread3 = new Thread(new MyThready());
        Thread[] ta = {thread1, thread2, thread3};
        for (int x = 0; x < 3; x++) {
            ta[x].start();
        }
    }
}