public class PriemGetal {
  public static void main(String[] args) {
    int begin = Integer.parseInt(args[0]);
    int eind = Integer.parseInt(args[1]);
    for (int cnt = begin; cnt <= eind; cnt++) {
      boolean isPriem = isPriem(cnt);
      if (isPriem) {
        System.out.println(cnt + " Priemgetal");
      } else {
        System.out.println(cnt + " Geen priemgetal");
      }
    }
  }

  public static boolean isPriem(int getal) {
    boolean returnValue = true;
    int wortel = new Double(Math.sqrt(getal)).intValue();
    if (getal % 2 == 0 & getal > 2) {
      returnValue = false;
    } else {
      int deler = 3;
      while (deler <= wortel) {
        if (getal % deler == 0) {
          returnValue = false;
          break;
        } else {
            returnValue = true;
            break;
        }
      }
    }
    return returnValue;
  }
}