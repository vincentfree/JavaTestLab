import java.sql.*;

class JDBCFunctie {

  public static void main (String args []) throws SQLException {

    Connection con = MijnConnectie.connect();

    CallableStatement cs = con.prepareCall("{? = call naam_ophalen(?)}");

    cs.registerOutParameter(1, Types.VARCHAR);

    int klantnummer = Integer.parseInt(args[0]);
    cs.setInt(2, klantnummer);

    cs.executeUpdate();
    System.out.println(cs.getString(1));

    cs.close();
    con.close();

  }
  
}
