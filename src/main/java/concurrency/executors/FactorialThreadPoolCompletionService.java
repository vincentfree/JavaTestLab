package concurrency.executors;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Voorbeeld faculteit via ThreadPool en CompletionService
 */
public class FactorialThreadPoolCompletionService implements Callable<BigInteger> {
    private final long start;
    private final long end;

    public FactorialThreadPoolCompletionService(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService<BigInteger> completionService = new ExecutorCompletionService<BigInteger>(executorService);
        long startTime = System.currentTimeMillis();
        int nrOfJobs = 0;
        for (int i = 1; i <= 1490; i += 10) {
            Callable<BigInteger> factorial = new FactorialThreadPoolCompletionService(i, i + 9);
            completionService.submit(factorial);
            nrOfJobs++;
        }
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= nrOfJobs; i++) {
            try {
                BigInteger b = completionService.take().get();
                result = result.multiply(b);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        //System.out.println("Result " + result);
        System.out.println("Duration " + (endTime - startTime));
        executorService.shutdown();
    }

    @Override
    public BigInteger call() throws Exception {
        BigInteger factorial = BigInteger.valueOf(1);
        for (long cnt = start; cnt <= end; cnt++) {
            factorial = factorial.multiply(BigInteger.valueOf(cnt));
        }
        return factorial;
    }
}
