public class TellerApp {

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
      Thread    thread1 = new Thread(teller1);
      Thread    thread2 = new Thread(teller2);
      Thread    thread3 = new Thread(teller3);
      thread1.setPriority(Thread.MIN_PRIORITY);
      thread2.setPriority(Thread.NORM_PRIORITY);
      thread3.setPriority(Thread.MAX_PRIORITY);
      thread1.start();
      thread2.start();
      thread3.start();
      
      
    }
}
