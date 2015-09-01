import java.io.Console;

class RaadGetal{
  
  public static void main (String args[]){
    Console console = System.console();
    int grens, getal, gok, teller;
    double random;
    // getal onder de tien, of getal onder opgegeven getal kiezen.
    if (args.length==0){
      grens=10;  
    }
    else {
      grens = Integer.parseInt(args[0]);
    }
    // genereer random getal onder het opgegeven getal
    random = Math.random()*grens;
    getal = (int) Math.floor(random);
    gok = -1;
    teller = 1;
    // doe een eerste gok
    gok = Integer.parseInt(console.readLine("Geef een getal onder de %d: ",grens));
    String boodschap;
    // als niet meteen geraden, geef dan aan of het gezochte getal groter of kleiner is.
    // laat een teller meelopen om het aantal pogingen bij te houden.
    while (gok!=getal){
      if (gok>getal){
        boodschap="kleiner";
      }
      else {
        boodschap="groter";
      }
      gok = Integer.parseInt(console.readLine(
       "Het gezochte getal is %-7s dan %d:  ",boodschap, gok));
      teller++; 
    }
    console.format("%nHet getal %d is geraden in %d pogingen.",getal, teller);
  }
}