package concurrency.locks;

import concurrency.locks.Bakker;
import concurrency.locks.Koekiemonster;
import concurrency.locks.Koekjes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Voorbeeldcode voor de Semaphore
 */
public class Feest {
    public static Koekjes koektrommel;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        //Condition lockCondition = lock.newCondition();
        koektrommel = new Koekjes(1);
        new Bakker(17, lock);
        new Koekiemonster("Monster1", lock);
        new Koekiemonster("Monster2", lock);
        new Koekiemonster("Monster3", lock);
    }

    public static boolean doorgaan() {
        return (koektrommel != null && koektrommel.size() > 0);
    }
}