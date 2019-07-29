package oracle.ocp.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Factorial implements Callable<Long> {
    long n;

    public Factorial(long n) {
        this.n = n;
    }

    @Override
    public Long call() throws Exception {
        if (n <= 0) {
            throw new Exception("For finding factorial,N should be > 0");
        }
        long fact = 1;
        for (long longVal = 1; longVal <= n; longVal++) {
            fact *= longVal;
        };
        return fact;
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long N = 35;
        Callable<Long> task = new Factorial(N);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(task);

        System.out.printf("factorial of %d is %d", N, future.get());

        executorService.shutdown();
    }

}
