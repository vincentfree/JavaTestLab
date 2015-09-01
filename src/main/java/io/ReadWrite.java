import java.io.*;

abstract class ReadWrite {
 
  public static Object read(String bestand) throws IOException, ClassNotFoundException {
    FileInputStream f = new FileInputStream(bestand);
    ObjectInputStream in = new ObjectInputStream(f);
    Object o = in.readObject();
    in.close();
    return o;
  }

  public static void write(Object o, String bestand) throws IOException {
    FileOutputStream f = new FileOutputStream(bestand);
    ObjectOutputStream out = new ObjectOutputStream(f);
    out.writeObject(o);
    out.close();
  }

}