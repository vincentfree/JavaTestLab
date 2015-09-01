import java.net.*;
import java.util.Scanner;
import java.io.Console;

class Datagram {
  public static void main (String args[]) throws Exception {
    if(args.length==3 && args[0].equals("verzend")) { // starten in verzend modus
      Console console = System.console();          // console om te verzenden tekst mee op te vragen
      DatagramSocket socket=new DatagramSocket(); // aanmaken socket
      String bericht=null;
      while(!"stop".equals(bericht)){             // verzenden tot stop is opgegeven
        bericht=console.readLine();               // bericht = een regel tekst
                                                  // maak Datagram aan met ingevoerd bericht, 
                                                  // en opgegeven IP adres en poort:
        DatagramPacket datagram = new DatagramPacket(bericht.getBytes(),bericht.length(),
                                  InetAddress.getByName(args[1]),Integer.parseInt(args[2]));
        socket.send(datagram);                    // verzend het bericht
      }
      
    } else if (args.length==2 && args[0].equals("ontvang") ){  // starten in ontvang modus
      
      System.out.println(                            // toon het lokale IP adres
            InetAddress.getLocalHost().getHostAddress());
      byte[] gegevens=new byte[1024];            // maak een buffer aan om 
      String bericht=null;                       // om berichten in te bericht
                                                 // luister naar de opgegeven poort:
      DatagramSocket socket = new DatagramSocket(Integer.parseInt(args[1]));
      while (!"stop".equals(bericht)){           // ga door tot "stop" is bericht
                                                 // maak een leeg datagram aan
                                                 // op basis van de buffer
        DatagramPacket datagram=new DatagramPacket(gegevens, gegevens.length);
        socket.receive(datagram);                // ontvang een bericht
                                                 // en pak het bericht uit:
        bericht=new String(datagram.getData(),0,datagram.getLength());
        System.out.println(bericht);                // toon het bericht
      
      }
    }
  }
}