import java.text.*;
import java.util.Date;

class DateFormatApp2 {
  public static void main (String args[]) {
  DateFormat df = DateFormat.getInstance();
  SimpleDateFormat sf = (SimpleDateFormat)df;
  sf.applyPattern("dd-MM-yyyy");
  try {
      Date nu = df.parse(args[0]);
      System.out.println(nu);
    } catch (ParseException pe) {System.err.println(pe.getMessage());}
  }
}