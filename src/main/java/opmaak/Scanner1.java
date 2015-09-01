import java.util.Scanner;

class Scanner1 {
  public static void main (String args[]) {
      Scanner scanner = new Scanner("een,twee,drie,vier,vijf");
      scanner.useDelimiter(",");
      while(scanner.hasNext()) {
        System.out.println(scanner.next());
      }
   }
}