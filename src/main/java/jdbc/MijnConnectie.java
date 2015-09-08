package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Created by nerom on 7-9-2015.
 */
public class MijnConnectie {

    public static Connection connect() {
        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setURL("jdbc:mysql://localhost:3306/javacursus");
            Connection conn = ds.getConnection("cursist", "vh_cursus");
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException sqle) {
            System.out.println("Fout bij het inloggen: " + sqle.getMessage());
            return null;
        }
    }

    static Connection connect(String User, String Password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setURL("jdbc:mysql://localhost:3306/javacursus");
            Connection conn = ds.getConnection(User, Password);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException sqle) {
            System.out.println("Fout bij het inloggen: " + sqle.getMessage());
            return null;
        }
    }
}