class Split {
  public static void main (String args[]) {
    String[] woorden;
    String tekst=args[1];
    String scheidingsteken=args[0];
    woorden = tekst.split(scheidingsteken);
    for (String woord:woorden) {
      System.out.println(woord);
    }
  }
}