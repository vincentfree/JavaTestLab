import java.util.Vector;

public class Koekjes {
  private Vector<Koekje> koekjes;

  Koekjes(int aantal) {
    koekjes = new Vector<Koekje>(aantal);
    for (int i = 0; i < aantal; i++) {
      koekjes.add(new Koekje());
    }
  }

  public void add() {
    koekjes.add(new Koekje());
  }

  public void remove() {
    koekjes.remove(0);
  }

  public int size() {
    return koekjes.size();
  }

  private class Koekje {
    public Koekje() { 
    }
  }
}