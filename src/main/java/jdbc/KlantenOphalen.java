import java.sql.*;

class KlantenOphalen {

  public static void main (String args []) throws SQLException {

  Connection con = MijnConnectie.connect();

  Statement stmt = con.createStatement ();

  ResultSet rset = stmt.executeQuery ("select naam from j_klanten");

  while (rset.next ())
    System.out.println (rset.getString (1));
    
  rset.close();
  stmt.close();
  con.close();

  }
}
