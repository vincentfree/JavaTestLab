import java.util.concurrent.Semaphore;

public class Koekiemonster implements Runnable {
  private Thread thread;
  private String naam;
  private Semaphore semaphore;

  public Koekiemonster(String naam) {
    this.naam = naam;
    thread = new Thread(this);
    thread.start();
  }

  public Koekiemonster(String string, Semaphore semaphore) {
    this(string);
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    while (Feest.doorgaan()) {
      eet(Feest.koektrommel, 3);
    }
  }

  public void eet(Koekjes koekjes, int aantal) {
    int gepakt = 0;
    int pakweg = 0;
    try {
      semaphore.acquire();
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
      Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(naam + ": " + gepakt);
    semaphore.release();
  }
}