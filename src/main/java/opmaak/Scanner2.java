import java.io.*;
import java.util.*;

class Scanner2 {
  public static void main(String args[]) {
    try {
      File bestand = new File("j_werknemers.csv");
      Scanner regels=new Scanner(bestand); // 
      int totaal=0;
      while (regels.hasNextLine()){   // lees bestand regel voor regel in
        Scanner werknemer = new Scanner(regels.nextLine());
        werknemer.useDelimiter(",");
                                      // lees afzonderlijke velden in:
        System.out.println("naam:    "+werknemer.next());
        System.out.println("functie: "+werknemer.next());
                                      // haal volgende veld als int-waarde op:
        int salaris= werknemer.nextInt();
        System.out.println("salaris: "+salaris);
        totaal+=salaris;
        System.out.println();
      }
      System.out.println("totaal:  " + totaal);
    }
    catch(IOException ie){ie.printStackTrace();}
  }
}
