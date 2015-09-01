import java.sql.*;
import oracle.jdbc.*;

public class TestApplicatie {

	public static void main (String args []) throws SQLException {

		Connection con =		MijnConnectie.connect();

		DatabaseMetaData dmd = con.getMetaData();

		System.out.println("Database: "  + '\n' + dmd.getDatabaseProductVersion());

		System.out.println("Maximaal aantal kolommen in een tabel: " + 
							dmd.getMaxColumnsInTable());

		System.out.println("Gebruikersnaam: " + dmd.getUserName());


		con.close();

		
	}

}
