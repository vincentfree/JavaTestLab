import java.util.concurrent.CountDownLatch;

/**
 * Voorbeeld van CountDownLatch
 *
 */
public class Feest {
  public final static Koekjes koektrommel = new Koekjes(1);
  static CountDownLatch countDownLatch = null;

  public static void main(String[] args) {
    countDownLatch = new CountDownLatch(1);
    new Koekiemonster("Monster1", countDownLatch);
    new Koekiemonster("Monster2", countDownLatch);
    new Koekiemonster("Monster3", countDownLatch);
    new Bakker(10, countDownLatch);
  }

  public static boolean doorgaan() {
    return (koektrommel != null && koektrommel.size() > 0);
  }
}
