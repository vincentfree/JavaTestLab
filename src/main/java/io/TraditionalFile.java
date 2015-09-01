import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TraditionalFile {

  public static void main(String[] args) {
    try {
      readFile();
    } catch (IOException e) {
        e.printStackTrace();
	Throwable[] throwables = e.getSuppressed();
	for (Throwable throwable : throwables)
	  throwable.printStackTrace();
    }
  }

  public static void readFile() throws IOException {
    BufferedReader bufferedReader = null;
    Exception suppressedException = null;
    try {
      File file = new File("");
      FileReader fileReader = new FileReader(file);
      bufferedReader = new BufferedReader(fileReader);
      String lineRead = null;
      while ((lineRead = bufferedReader.readLine()) != null) {
        System.out.println(lineRead);
      }
    } catch (IOException e) {
        suppressedException = e;
	throw e;
    } finally {
        try {
          bufferedReader.close();
        } catch (Exception e) {
	    if (suppressedException != null) {
              s.addSuppressed(suppressedException);
            }
            throw e;
        }
    }
  }
}
