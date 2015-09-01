import java.sql.*;


public class SaldoApplicatie 
{
  
  public static void main(String[] args) throws SQLException
  {
    Connection conn = MijnConnectie.connect();
    Statement stMut = conn.createStatement(); // pas deze regel aan
    
	  ResultSet rsMut = st.executeQuery
		  ("select klantnr, mutatie from j_saldomutatie for update");
    
	  PreparedStatement psKlan = conn.prepareStatement
		  ("update j_klanten set opensaldo = opensaldo + ? where klantnr = ?");

	/*

		Verwerk de gegevens uit de resultset rsMut
		met behulp van het PreparedStatement psKlan
		
	*/      


  rsMut.close();
  psKlan.close();
  stMut.close();
  conn.close();
  }
}