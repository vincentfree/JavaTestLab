import java.util.*;
class Format2 {
  public static void main (String args[]) {
    Map<String,Float> prijzen = new HashMap<String,Float>();
    prijzen.put("koffie",1.5f);
    prijzen.put("appelgebak",2.5f);
    prijzen.put("pizza",11f);
    for (String prijs:prijzen.keySet()){
      System.out.format("De prijs van %1$s is %2$.2f Euro",prijs, prijzen.get(prijs));
      System.out.println();
    }
  }
} 