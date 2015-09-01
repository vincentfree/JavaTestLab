import java.util.concurrent.Exchanger;

/**
 * Voorbeeld voor de Exchanger
 *
 */
public class RunnableExchanger implements Runnable {
  private String text;
  private Exchanger<String> exchanger;

  public static void main(String[] args) {
    Exchanger<String> exchanger = new Exchanger<>();
    RunnableExchanger runnableExchanger1 = new RunnableExchanger(exchanger, "A");
    RunnableExchanger runnableExchanger2 = new RunnableExchanger(exchanger, "B");
    new Thread(runnableExchanger1).start();
    new Thread(runnableExchanger2).start();
  }

  public RunnableExchanger(Exchanger<String> exchanger, String text) {
    this.exchanger = exchanger;
    this.text = text;
  }
	
  public void run() {
    String previous = this.text;
    try {
      this.text = this.exchanger.exchange(this.text);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.text);
  }
}