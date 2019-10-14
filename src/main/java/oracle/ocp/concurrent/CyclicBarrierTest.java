package oracle.ocp.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class DoubleSquashGame extends Thread {
    public void run() {
        System.out.println("All players are ready to go.. Love all.");
    }
}

class Player extends Thread {
    private CyclicBarrier waitPoint;

    Player(CyclicBarrier waitPoint, String name) {
        this.setName(name);
        this.waitPoint = waitPoint;
        this.start();
    }

    public void run() {
        System.out.println("Player " + getName() + " is ready to play.");
        try {
            waitPoint.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println("While waiting this happened:");
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierTest {
    public static void main(String[] args) {
        System.out.println("Reserving squash court..");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new DoubleSquashGame());
        new Player(cyclicBarrier, "Luo");
        new Player(cyclicBarrier, "Carl");
        new Player(cyclicBarrier, "Mark");
        new Player(cyclicBarrier, "Niuniek");
    }

}

class Worker extends Thread {
    CyclicBarrier cb;
    public Worker(CyclicBarrier cb) {
        this.cb = cb;
    }
    public void run () {
        try {
            cb.await();
            System.out.println("Worker…");
        } catch (Exception ex) {}
    }
}
class Master implements Runnable {   //line n1
    public void run ()   {
        System.out.println("Master…");
    }

    public static void main(String[] args) {
        Master master = new Master();
        CyclicBarrier cb = new CyclicBarrier(1, master);
        Worker worker = new Worker(cb);
        worker.start();
    }
}

