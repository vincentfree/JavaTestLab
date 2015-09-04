package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Koekiemonster implements Runnable {
  private Thread thread;
  private String naam;
  private int gepakt = 0;
  private CountDownLatch countDownLatch;

  public Koekiemonster(String naam, CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
    this.naam = naam;
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
    while (Feest.doorgaan()) {
      eet(Feest.koektrommel, 3);
      System.out.println(naam + ": " + gepakt);
    }
  }

  public void eet(Koekjes koekjes, int aantal) {
    int pakweg = 0;
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    int resterend = koekjes.size();
    if (aantal < resterend) {
      pakweg = aantal;
    } else {
        pakweg = resterend;
    }
    for (int i = 0; i < pakweg; i++) {
      koekjes.remove();
      gepakt++;
    }
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
  }
}