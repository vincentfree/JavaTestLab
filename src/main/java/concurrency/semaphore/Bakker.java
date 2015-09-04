package concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class Bakker implements Runnable {
    private int aantal = 0;
    private Thread thread;
    private Semaphore semaphore;

    public Bakker(int aantal) {
        this.aantal = aantal;
        thread = new Thread(this);
        thread.start();
    }

    public Bakker(int i, Semaphore semaphore) {
        this(i);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (Feest.doorgaan()) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bak(Feest.koektrommel, aantal);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }
    }

    public void bak(Koekjes koekjes, int aantal) {
        for (int i = 0; i < aantal; i++) {
            koekjes.add();
        }
        System.out.println("Voorraad : " + koekjes.size());
    }
}