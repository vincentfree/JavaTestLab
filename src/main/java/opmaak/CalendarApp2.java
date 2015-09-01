import java.util.Calendar;
import static java.util.Calendar.*;

class CalendarApp2 {

  public static void main (String args[]) {
    Calendar kalender = Calendar.getInstance();
    System.out.println("Voor: " + kalender.getTime());
    kalender.set(MONTH, OCTOBER);
    kalender.roll(MONTH,3);
    kalender.add(DAY_OF_WEEK,-3);    
    System.out.println("Na:   " + kalender.getTime());
  }
}
