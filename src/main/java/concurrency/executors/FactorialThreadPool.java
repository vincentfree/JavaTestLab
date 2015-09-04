package concurrency.executors;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Voorbeeld faculteit via seriele ThreadPool
 *
 */
public class FactorialThreadPool implements Callable<BigInteger> {

  private final long n;

  public FactorialThreadPool(long n) {
    this.n = n;
  }

  public static void main(String[] args) {
    Callable<BigInteger> factorial = new FactorialThreadPool(1400);
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    long startTime = System.currentTimeMillis();
    Future<BigInteger> future = executorService.submit(factorial);
    try {
      System.out.println("Factorial is: " + future.get());
      long end = System.currentTimeMillis();
      System.out.println("Duration: " + (end - startTime) + " ms");
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    } finally {
    executorService.shutdown();
    }
  }

  @Override
  public BigInteger call() throws Exception {
    if (n <= 0) {
      throw new Exception("n must be > 0");
    } else {
      BigInteger factorial = BigInteger.valueOf(1);
      for (long i = 1; i <= n; i++) {
        factorial = factorial.multiply(BigInteger.valueOf(i));
      }
      return factorial;
    }
  }
}