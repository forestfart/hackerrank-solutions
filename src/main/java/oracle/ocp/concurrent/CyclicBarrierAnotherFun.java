package oracle.ocp.concurrent;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CyclicBarrierAnotherFun {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println(list));
        Runnable runnable = () -> {
            try {
                Thread.sleep(100 * atomicInteger.incrementAndGet());
                list.add("Hit");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {}
        };
        IntStream.range(0, 30).forEach(n -> new Thread(runnable).start());
        barrier.reset();
    }
}
