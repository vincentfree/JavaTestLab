import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Voorbeeld Streaming IO via Channel
 */
public class FileChannelExample {

public static void main(String[] args) {
  FileInputStream fileInputStream = null;
  try {
    fileInputStream = new FileInputStream("src/tmp.txt");
    FileChannel fileChannel = fileInputStream.getChannel();
    int size = (int) fileChannel.size();
    ByteBuffer buffer = ByteBuffer.allocate(size);
    fileChannel.read(buffer);
    buffer.flip();
    long t1 = System.currentTimeMillis();
    while (buffer.hasRemaining()) {
      buffer.get();
    }
    long t2 = System.currentTimeMillis();
    System.out.println("Duration: " + (t2 - t1));
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  } catch (IOException e) {
      e.printStackTrace();
  } finally {
      try {
        fileInputStream.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
  }
}
