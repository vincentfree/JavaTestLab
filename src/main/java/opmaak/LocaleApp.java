import java.util.*;
import java.text.*;

class LocaleApp {
  public static void main (String args[]) {
    Date nu = new Date();
    Locale frans = Locale.FRENCH;
    Locale duits = Locale.GERMAN;
    DateFormat dfFrans = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, frans);
    DateFormat dfDuits = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, duits);
    System.out.println(dfFrans.format(nu));
    System.out.println(dfDuits.format(nu));
  }
}