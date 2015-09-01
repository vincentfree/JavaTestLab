import java.io.*;
import java.net.*;

class KopieServer {

  static ServerSocket server=null;
  static File directory = null;

  static {
    directory = new File("clientbestanden/");  // directory voor inkomende bestanden
    directory.mkdirs();                         // wordt aangemaakt als ie nog niet bestaat
  }


  public static void main (String args[]) {
    try {
      initServer();
      while(true){
        ontvangClient();
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
  private static void initServer() throws IOException, UnknownHostException{
    server = new ServerSocket(1234);
    System.out.println("Server adres: " + InetAddress.getLocalHost().getHostAddress());
  }

  private static void ontvangClient() throws IOException, UnknownHostException{
    System.out.println("Wachten op een client...");
    
    // socket aanmaken en adres tonen

    // data input stream aanmaken om client gegevens op te halen
    
    // lengte bestandsnaam ophalen en tonen
    
    // bestandsnaam ophalen en tonen
    
    // bestand aanmaken en vullen
    
    int gelezen=0;
    do {
      gelezen = input.read(buffer);
      if (gelezen>0) {
        output.write(buffer,0,gelezen);
      }
    } while (gelezen>-1);
    
    // streams en socket sluiten
    
    
    System.out.println("Connectie met client gesloten");
  }
  
}