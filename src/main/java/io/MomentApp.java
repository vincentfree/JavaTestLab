import java.io.*;

public class MomentApp extends ReadWrite {

  public static void main(String args[]) throws IOException, ClassNotFoundException{
    Moment moment = new Moment();
    if(args[0].equals("nu")) {
      moment.setTijd();
      write(moment, "Moment.obj");
    }
    if(args[0].equals("toen")) {
      moment = (Moment)read("Moment.obj");      
    }
    System.out.println(moment.getTijd());
  }
  
}