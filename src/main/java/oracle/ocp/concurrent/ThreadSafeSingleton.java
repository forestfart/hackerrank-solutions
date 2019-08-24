package oracle.ocp.concurrent;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton threadSafeSingleton;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (threadSafeSingleton == null) {
            return threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }

}
