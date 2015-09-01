import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Voorbeeld try-with-resources
 *
 */
public class TryWithResources {

  public static void main(String[] args) {
    read();
  }

  public static void read() {
    File file = new File("C:/Temp/test.txt");
    try (FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      String lineRead = null;
      while ((lineRead = bufferedReader.readLine()) != null) {
        System.out.println(lineRead);
      }
    } catch (IOException e){
          e.printStackTrace();
    }
  }
}
