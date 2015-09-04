package threads;

public class TellerApp implements Runnable {

    private long tijd;
    private long teller;

    public TellerApp() {
        tijd = 0;
        teller = 0;
    }

    public long getTijd() {
        return tijd;
    }

    public static void main(String[] args) {

        TellerApp teller1 = new TellerApp();
        TellerApp teller2 = new TellerApp();
        TellerApp teller3 = new TellerApp();
        Thread thread1 = new Thread(teller1);
        Thread thread2 = new Thread(teller2);
        Thread thread3 = new Thread(teller3);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Teller 1: " + teller1.getTijd() + " milliseconde");
        System.out.println("Teller 2: " + teller2.getTijd() + " milliseconde");
        System.out.println("Teller 3: " + teller3.getTijd() + " milliseconde");

    }

    @Override
    public void run() {
        long startTijd = System.currentTimeMillis();
        while (teller < 5_000_000) {
            teller++;
            Thread.yield();
        }
        tijd = (System.currentTimeMillis() - startTijd);
    }
}