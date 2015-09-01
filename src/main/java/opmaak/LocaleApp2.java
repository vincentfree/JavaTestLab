import java.util.Locale;

class LocaleApp2 {
  public static void main (String args[]) {
  for (String naam:Locale.getISOLanguages()) 
    System.out.println(new Locale(naam).getDisplayLanguage(Locale.FRENCH));
  }
}