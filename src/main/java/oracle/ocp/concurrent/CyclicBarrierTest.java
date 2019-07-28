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
