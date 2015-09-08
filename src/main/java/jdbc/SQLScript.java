package jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

class SQLScript {

  public static void main(String args[]) throws SQLException{
    Connection conn=MijnConnectie.connect();
    Statement stm = conn.createStatement();
    for(String regel:openFile(args[0])) {
      stm.addBatch(regel);
    }
    int[] regels = stm.executeBatch();
    for(int i:regels){
      System.out.println(i+" regels verwerkt.");
    }
    conn.commit();
    stm.close();
    conn.close();
  }
  
  private static Vector<String> openFile(String naam) {
    Vector<String> regels=null; 
    try {
      File bestand = new File(naam);
      Reader reader = new FileReader(bestand);               
      BufferedReader bufferedReader = new BufferedReader(reader);
      regels = new Vector<String>(10);
      String tekst;
      do{
        tekst=bufferedReader.readLine();
        if (tekst!=null){
          regels.add(tekst.replace(';',' ').trim());
        }
      }while(tekst!=null);
    }
    catch(IOException ie){ie.printStackTrace();}
     return regels;
  }
  
}
