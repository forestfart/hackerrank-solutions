package oracle.ocp.concurrent;

import static java.lang.String.format;
import static java.lang.Thread.sleep;

public class ThreadThrowingException {

    private class Action implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(format("Thread %s interrupted while running", Thread.currentThread().getName()));
            }
        }
    }

    public static void main(String[] args) {
        Action action = new ThreadThrowingException().new Action();

        Thread thread1 = new Thread(action);
        thread1.setName("thread #1");
        thread1.start();
        System.out.println(format("%s, %s is alive: %s", Thread.currentThread().getName(), thread1.getName(), thread1.isAlive()));
        thread1.interrupt();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName());
        }
    }

}
