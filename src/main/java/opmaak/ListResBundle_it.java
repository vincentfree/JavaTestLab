import java.util.ListResourceBundle;

public class ListResBundle_it extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return contents;
  }

  static final Object[][] contents = { 
    { "morning_greeting", "Buongiorno" },
    { "evening_greeting", "Buonasera" },
    { "night_greeting", "Bonnanotte" } 
  };
}