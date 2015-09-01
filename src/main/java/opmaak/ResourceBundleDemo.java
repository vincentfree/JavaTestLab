import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Demonstreert het gebruik van een ResourceBundle
 *
 */
public class ResourceBundleDemo {

  public static void main(String[] args) {
    ResourceBundle propertiesResourceBundle = ResourceBundle.getBundle("PropsResBundle", new Locale("nl_NL"));
    System.out.println(propertiesResourceBundle.getString("morning_greeting"));

    // Locale localeIt = new Locale("it", "IT", "");
    ResourceBundle listResourceBundle = ResourceBundle.getBundle("ListResBundle", Locale.ENGLISH);

    System.out.println(listResourceBundle.getString("morning_greeting"));
  }

}
