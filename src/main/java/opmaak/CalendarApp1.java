import java.util.Calendar;
import static java.util.Calendar.*;

class CalendarApp1 {

  public static void main (String args[]) {
    Calendar kalender = Calendar.getInstance();
    String dag        = dag(kalender.get(DAY_OF_WEEK));  
    int dagInMaand    = kalender.get(DAY_OF_MONTH);
    int maand         = kalender.get(MONTH)+1;
    int jaar          = kalender.get(YEAR);
    int uur           = kalender.get(HOUR_OF_DAY);
    int minuut        = kalender.get(MINUTE);
    int seconde       = kalender.get(SECOND);
    
    System.out.println(dag+" "+dagInMaand+"-"+maand+"-"+jaar);    
    System.out.println(uur+":"+minuut+":"+seconde);
  }
  
  static String dag(int d){
    switch(d) {
      case MONDAY: return "maandag";
      case TUESDAY: return "dinsdag";
      case WEDNESDAY: return "woensdag";
      case THURSDAY: return "donderdag";
      case FRIDAY: return "vrijdag";
      case SATURDAY: return "zaterdag";
      case SUNDAY: return "zondag";
    }
    return "fout";
  }
}
