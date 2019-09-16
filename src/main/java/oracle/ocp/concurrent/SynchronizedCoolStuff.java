package oracle.ocp.concurrent;

public class SynchronizedCoolStuff implements Runnable {
    int runningToThisVariable = 10;

    @Override
    public void run() {
        while (runningToThisVariable > 0) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            synchronized (this) {
                runningToThisVariable -= 1;
            }
            System.out.print(runningToThisVariable);
        }
    }

    public static void main(String[] args) {

        SynchronizedCoolStuff synchronizedCoolStuff = new SynchronizedCoolStuff();
        Thread thread1 = new Thread(synchronizedCoolStuff);
        Thread thread2 = new Thread(synchronizedCoolStuff);

        thread1.start();
        thread2.start();
    }
}
