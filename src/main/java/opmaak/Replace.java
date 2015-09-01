import java.util.regex.*;

class Replace {

  public static void main (String args[]) {
     Pattern patroon = Pattern.compile(args[0]);     // eerste woord is patroon
     String vervang = args[1];                       // tweede woord vervangt de gematchte tekst
     StringBuffer tekst = new StringBuffer(args[2]); // tekst begint met derde woord
     for (int i=3;i<args.length;i++)                 // voeg overige woorden toe
       tekst.append(" "+args[i]);
     Matcher matcher   = patroon.matcher(tekst);
     System.out.println(matcher.replaceAll(vervang));
  }
}