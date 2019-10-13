package oracle.ocp.concurrent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

class ExecutorsTestTwo {
    static class CallerThread implements Callable<String> {
        String str;
        public CallerThread(String s) {
            this.str=s;
        }
        public String call() throws Exception {
            return str.concat("Call");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4); //line n1
        Future future1 = es.submit(new CallerThread("Call "));
        System.out.println(future1.get());

    }
}

class ExecutorsTestThree {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(new Task());
        Future<String> future = es.submit(() -> "Call task.call()");
        System.out.println(future.get());
        es.shutdown();
    }
}

class FileThread implements Runnable {
    String fName;
    public FileThread(String fName) {
        this.fName = fName;
    }
    public void run() {
        System.out.println(fName);
    }
    public static void main (String[] args) throws IOException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Stream<Path> listOfFiles = Files.walk(Paths.get("src\\main\\resources"));
        listOfFiles.forEach(line -> {
            executor.execute(new FileThread(line.getFileName().toString())); // line n1
        });
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.DAYS); // line n2
    }
}

class Caller implements Callable<String> {
    String str;
    public Caller (String s) {
        this.str=s;
    }
    public String call() throws Exception {
        return str.concat("Caller");
    }
}
class Runner implements Runnable {
    String str;
    public Runner (String s) {
        this.str=s;
    } public void run () {
        System.out.println (str.concat("Runner"));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future f1 = executorService.submit(new Caller ("Call"));
        Future f2 = executorService.submit(new Runner ("Run"));
        String str1 = (String) f1.get();
        String str2 = (String) f2.get(); //line n1
        System.out.println(str1+ ":" + str2);
        executorService.shutdown();
    }
}

class ThreadRunner implements Runnable {
    public void run () {
        System.out.print("Runnable") ;
    }
}
class ThreadCaller implements Callable {
    public String call() throws Exception {
        return "Callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Runnable r1 = new ThreadRunner();
        Callable c1 = new ThreadCaller();
        Future f1 = es.submit(r1);
        Future<String> f2 = es.submit(c1);
        System.out.println(f2.get());
        es.shutdown();
    }
}


