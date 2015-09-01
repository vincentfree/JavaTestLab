import java.io.Console;

public class Login {

  public static void main (String args[]){
    Console console = System.console();
    String gebruikersnaam = console.readLine("Wat is uw gebruikersnaam? ");
    char[] wachtwoord = console.readPassword("Geef het wachtwoord op van %s: ", gebruikersnaam);
    if (String.valueOf(wachtwoord).equals("vh_cursus"))
      console.printf("Welkom %s.",gebruikersnaam);
    else
      console.printf("Onbekend wachtwoord");
  }
}