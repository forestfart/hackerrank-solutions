package oracle.ocp.concurrent;

public class ThreadSafeSingleton {

    volatile private static ThreadSafeSingleton threadSafeSingleton;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (threadSafeSingleton == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (threadSafeSingleton == null) {
                    return threadSafeSingleton = new ThreadSafeSingleton();
                }
            }
        }
        return threadSafeSingleton;
    }

}
