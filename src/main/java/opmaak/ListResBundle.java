import java.util.ListResourceBundle;

public class ListResBundle extends ListResourceBundle {
  @Override
  protected Object[][] getContents() {
    return contents;
  }

  static final Object[][] contents = {
    { "morning_greeting", "Good morning" },
    { "evening_greeting", "Good evening" },
    { "night_greeting", "Good night" } 
  };
}
