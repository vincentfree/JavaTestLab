package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Bakker implements Runnable {
  private int aantal = 0;
  private Thread thread;
  private CountDownLatch countDownLatch;

  public Bakker(int aantal, CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
    this.aantal = aantal;
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
  while (Feest.doorgaan()) {
    bak(Feest.koektrommel, aantal);
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
  }
}

public void bak(Koekjes koekjes, int aantal) {
  for (int i = 0; i < aantal; i++) {
    koekjes.add();
  }
  this.countDownLatch.countDown();
  System.out.println("Voorraad: " + koekjes.size());
  }
}
