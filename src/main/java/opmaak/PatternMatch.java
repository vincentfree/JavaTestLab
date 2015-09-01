import java.util.regex.*;

class PatternMatch {

  public static void main (String args[]) {
     Pattern patroon = Pattern.compile(args[0]);     // eerste woord is patroon
     StringBuffer tekst = new StringBuffer(args[1]); // tekst begint met tweede woord
     for (int i=2;i<args.length;i++)                 // voeg overige woorden toe
       tekst.append(" "+args[i]);
     Matcher matcher   = patroon.matcher(tekst);
     int aantal=0;
     while(matcher.find()) {
       aantal++;
       System.out.print(matcher.group()+":"+matcher.start()+" ");
     }
     System.out.println();
     System.out.println(patroon+" " + aantal + " maal gevonden in " + tekst);
  }
}