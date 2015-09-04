package concurrency.executors;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Voorbeeld faculteit via paralelle ThreadPool
 *
 */
public class FactorialThreadPoolParallel implements Callable<BigInteger> {

  private final long start;
  private final long end;

  public FactorialThreadPoolParallel(long start, long end) {
    this.start = start;
    this.end = end;
  }

  public static void main(String[] args) {
    final ExecutorService executorService = Executors.newFixedThreadPool(4);
    final long startTime = System.currentTimeMillis();
    List<Future<BigInteger>> futures = new ArrayList<>();
    ArrayList<Callable<BigInteger>> callables = new ArrayList<>(1400);
    for (int i = 1; i <= 1400; i += 10) {
      Callable<BigInteger> factorial = new FactorialThreadPoolParallel(i, i + 9);
      callables.add(factorial);
    }
    try {
      futures = executorService.invokeAll(callables);
    } catch (InterruptedException e1) {
        e1.printStackTrace();
    }
    BigInteger result = BigInteger.ONE;

    for (Future<BigInteger> f : futures) {
      try {
        BigInteger b = f.get();
        result = result.multiply(b);
      } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
      }
    }

    final long endTime = System.currentTimeMillis();
    System.out.println("Result " + result);
    System.out.println("Duration " + (endTime - startTime)+" ms");
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