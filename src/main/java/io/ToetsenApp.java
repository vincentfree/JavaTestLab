import java.io.*;
import static java.awt.event.KeyEvent.VK_ENTER;

class ToetsenApp {
  public static void main (String args[]) throws IOException {
    int aanslag;
    StringBuilder sb = new StringBuilder();
    System.out.println("Type een boodschap en druk op Enter");
    while((aanslag=System.in.read()) != VK_ENTER) {
      sb.insert(0,(char)aanslag);
    }
    System.out.println(sb);
  }
}