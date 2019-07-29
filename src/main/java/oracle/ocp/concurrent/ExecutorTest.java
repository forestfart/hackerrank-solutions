package oracle.ocp.concurrent;

import java.util.concurrent.Executor;
import java.util.stream.IntStream;

class Task implements Runnable {
    public void run() {
        System.out.println("Calling task.run()");
    }
}

class RepeatedExecutor implements Executor {

    @Override
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }

    public void execute(Runnable runnable, int times) {
        System.out.printf("Calling Task.run() %d times through Executor.execute() %n", times);
        IntStream.range(0, times).forEach( i -> execute(runnable));
    }
}

public class ExecutorTest {
    public static void main(String[] args) {
        Runnable runnable = new Task();
        System.out.println("Calling Task.run() by directly creating a Thread");
        Thread thread = new Thread(runnable);
        thread.start();
        RepeatedExecutor executor = new RepeatedExecutor();
        executor.execute(runnable,3);
    }
}
