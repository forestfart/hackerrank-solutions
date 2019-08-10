package oracle.ocp.concurrent;

public class WhizTest implements Runnable {

    public static void main(String[] args) {
        WhizTest whizTest = new WhizTest();
        Thread thread1 = new Thread(whizTest);
        thread1.setName("thread#1");
        thread1.start();
        System.out.println(Thread.currentThread().getName() + " ");
        try {
            thread1.join();
        } catch (Exception e) {}
        System.out.println(Thread.currentThread().getName());
    }


    public void run() {
        System.out.println(Thread.currentThread().getName() + " ");
    }
}
