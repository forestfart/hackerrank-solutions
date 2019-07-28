package oracle.ocp.concurrent;

public class MyThread extends Thread {
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("In run(), thread name is: %s, id: %d\n", getName(), getId());
    }

    public static void main(String... args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.printf("In main(), thread name is: %s, id: %s\n", Thread.currentThread().getName(), Thread.currentThread().getId());
    }
}
