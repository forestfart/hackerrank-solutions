package oracle.ocp.concurrent;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    static int count = 0;
}

class DoStuff implements Runnable {
    String name;
    ReentrantLock lock;

    public DoStuff(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            // First lock count
            System.out.println(name + " is waiting to lock count");
            lock.lock();
            System.out.println(name + " is locking count");
            SharedResource.count++;
            System.out.println(name + ": " + SharedResource.count);
            System.out.println(name + " is sleeping");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            System.out.println(name + " is unlocking count");
            lock.unlock();
        }

    }
}

public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);

        new Thread(new DoStuff("A", reentrantLock)).start();
        new Thread(new DoStuff("B", reentrantLock)).start();
        new Thread(new DoStuff("C", reentrantLock)).start();

    }

}
