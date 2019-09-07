package oracle.ocp.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMethods {

    AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {
        AtomicIntegerMethods aim = new AtomicIntegerMethods();

        System.out.println(aim.atomicInteger.addAndGet(5));

    }
}
