package oracle.ocp.concurrent;

class CounterFun extends Thread {
    private int i;
    public synchronized void display(CounterFun counterFun) {
        try {
            Thread.sleep(500);
            System.out.println("locking " + counterFun);
            counterFun.increment(this);
            System.out.println("unlocked " + counterFun);
        } catch (InterruptedException e) {}
    }

    public synchronized void increment(CounterFun obj) {
        System.out.println(++i);
    }
}

public class DeadLock2 {
    public static void main(String[] args) {
        CounterFun counter1 = new CounterFun();
        CounterFun counter2 = new CounterFun();
        new Thread(() -> counter1.display(counter2)).start();
        new Thread(() -> counter2.display(counter1)).start();
    }
}
