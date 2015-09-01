import java.util.Date;
import java.text.DateFormat;
import static java.text.DateFormat.*;

class DateFormatApp {
  public static void main (String args[]) {
    Date nu = new Date();
    DateFormat dfDefault = getDateInstance();
    DateFormat dfShort =   getDateInstance(SHORT);
    DateFormat dfMedium =  getDateInstance(MEDIUM);
    DateFormat dfLong  =   getDateInstance(LONG);
    DateFormat dfFull =    getDateInstance(FULL);
    
    System.out.println(dfDefault.format(nu));
    System.out.println(dfShort.format(nu));
    System.out.println(dfMedium.format(nu));
    System.out.println(dfLong.format(nu));
    System.out.println(dfFull.format(nu));
  }
}