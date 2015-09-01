import java.util.Date;
class Format {
  public static void main (String args[]) {
    System.out.format("De prijs van %1$s is %2$f Euro", "een paar schoenen", 120f);
    System.out.println();
    System.out.format("Het is vandaag %1$tD.", new Date());
  }
}
