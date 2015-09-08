package jdbc;

import java.sql.*;

class PreparedUpdate {

    public static void main(String args[]) throws SQLException {

        Connection conn = MijnConnectie.connect();

        PreparedStatement pstmt =
                conn.prepareStatement("update j_klanten set opensaldo = ? where naam = ?");

        pstmt.setInt(1, 2500);
        pstmt.setString(2, "Willemsen");
        pstmt.execute();

        pstmt.setInt(1, 0);
        pstmt.setString(2, "de Koning");
        pstmt.execute();

        conn.commit();
        pstmt.close();
        conn.close();
    }
}

