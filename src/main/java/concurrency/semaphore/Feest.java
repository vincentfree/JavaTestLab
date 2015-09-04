package concurrency.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Voorbeeldcode voor de Semaphore
 */
public class Feest {
    public static Koekjes koektrommel;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1, true);
        koektrommel = new Koekjes(1);
        new Bakker(17, semaphore);
        new Koekiemonster("Monster1", semaphore);
        new Koekiemonster("Monster2", semaphore);
        new Koekiemonster("Monster3", semaphore);
    }

    public static boolean doorgaan() {
        return (koektrommel != null && koektrommel.size() > 0);
    }
}