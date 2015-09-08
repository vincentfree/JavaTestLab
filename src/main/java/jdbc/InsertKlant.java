package jdbc;

import java.sql.*;

/**
 * Created by Vincent Free on 7-9-2015.
 */
public class InsertKlant {
    public static void main(String[] args) throws SQLException {
        Connection connection = MijnConnectie.connect();
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("insert into j_klanten values " +
                "(1012,'de Koning','Gierstraat','88','9823HD','Nieuwegein',760)");
        connection.commit();
        System.out.println("Aantal verwerkte rijen: " + rows);
        statement.close();
        connection.close();

    }
}

/*
CREATE TABLE J_KLANTEN
" +
                "(\n" +
                "KLANTNR int,\n" +
                "NAAM varchar(255),\n" +
                "STRAAT varchar(255),\n" +
                "NUMMER int,\n" +
                "POSTCODE varchar(255)\n" +
                "PLAATS varchar(255)\n" +
                "OPENSALDO double\n" +
                ");\n"
 */