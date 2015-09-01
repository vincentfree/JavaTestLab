import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

/**
 * Voorbeeld directory watch API
 */
public class FileWatcher {

  public static void main(String[] args) {
    Path path = Paths.get("C:/Temp/");
    WatchService watchService = null;
    try {
      watchService = path.getFileSystem().newWatchService();
      path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
    } catch (IOException e1) {
        e1.printStackTrace();
    }

    for (;;) {
      WatchKey key = null;
      try {
        key = watchService.poll(2, TimeUnit.SECONDS);
      } catch (InterruptedException e1) {
          e1.printStackTrace();
      }
      if (key != null) {
        for (WatchEvent<?> event : key.pollEvents()) {
          switch (event.kind().name()) {
            case "OVERFLOW":
              System.out.println("We lost some events");
              break;
            case "ENTRY_MODIFY":
              System.out.println("File " + event.context() + " is changed");
              break;
          }
        }
        key.reset();
      }
    }
  }
}