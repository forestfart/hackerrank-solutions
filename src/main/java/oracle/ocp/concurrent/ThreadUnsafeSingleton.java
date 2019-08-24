package oracle.ocp.concurrent;

public class ThreadUnsafeSingleton {

    private static ThreadUnsafeSingleton threadSafeSingleton;

    private ThreadUnsafeSingleton() {}

    public static ThreadUnsafeSingleton getInstance() {
        if (threadSafeSingleton == null) {
            return threadSafeSingleton = new ThreadUnsafeSingleton();
        }
        return threadSafeSingleton;
    }

}
