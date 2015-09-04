package concurrency.locks;

import concurrency.locks.*;
import concurrency.locks.Feest;
import concurrency.locks.Koekjes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Koekiemonster implements Runnable {
    private Thread thread;
    private String naam;
    private Lock lock;
    private Condition lockCondition;

    public Koekiemonster(String naam) {
        this.naam = naam;
        thread = new Thread(this);
        thread.start();
    }

    public Koekiemonster(String string, Lock lock) {
        this(string);
        this.lock = lock;
        this.lockCondition = this.lock.newCondition();
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
        lock.lock();
        try {
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
            lockCondition.await();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(naam + ": " + gepakt);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }
}