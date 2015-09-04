package concurrency.executors;

import java.math.BigInteger;

/**
 * Voorbeeld faculteit serieel
 *
 */
class FactorialSerial {

  public static void main(String[] args) {
    long n = 1400;
    long startTime = System.currentTimeMillis();
    System.out.println("Factorial is: " + factorial(n));
    long endTime = System.currentTimeMillis();
    System.out.println("Duration: " + (endTime - startTime));
  }

  public static BigInteger factorial(long factorial) {
    BigInteger fac = BigInteger.ONE;
    for (int i = 1; i <= factorial; i++) {
      fac = fac.multiply(BigInteger.valueOf(i));
    }
    return fac;
  }
}