package concurrency.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Bakker implements Runnable {
    private int aantal = 0;
    private Thread thread;
    private Lock lock;
    Condition lockCondition;


    public Bakker(int aantal) {
        this.aantal = aantal;
        thread = new Thread(this);
        thread.start();
    }

    public Bakker(int i, Lock lock) {
        this(i);
        this.lock = lock;
        this.lockCondition = this.lock.newCondition();
    }

    @Override
    public void run() {
        while (Feest.doorgaan()) {
            lock.lock();
            try {
                bak(Feest.koektrommel, aantal);
                lockCondition.await();
                //lockCondition.signal();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (InterruptedException ie) {
                ie.printStackTrace();

            } finally {
                lock.unlock();
            }
        }
    }

    public void bak(Koekjes koekjes, int aantal) {
        for (int i = 0; i < aantal; i++) {
            koekjes.add();
        }
        System.out.println("Voorraad : " + koekjes.size());
    }
}