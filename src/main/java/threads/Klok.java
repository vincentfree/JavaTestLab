import java.util.Calendar;
import java.util.Arrays;

class Klok extends Thread {

  char[] wis;
  
  Klok() {
    wis = new char[30];     // character array van 30 elementen lang
    Arrays.fill(wis,'\b');  // wis vullen met backspace characters
    start();
  }

  public static void main(String args[]) {
    new Klok();
  }

  public void run() {
    while (true) {
      Calendar c= Calendar.getInstance();  // huidige moment ophalen
      System.out.print(wis);               // eerst regel leeg maken
      System.out.print(c.getTime());       // dan tijd uitprinten
      System.out.flush();                  // en weergeven
      try {
        Thread.sleep(1000);                // wacht 1000 miliseconden
      } catch (InterruptedException ie) {}
    }
  }
}
