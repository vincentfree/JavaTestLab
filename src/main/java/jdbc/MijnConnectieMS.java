/*

package jdbc;

import com.microsoft.sqlserver.jdbc.*;
import org.postgresql.jdbc2.optional.SimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

*/
/**
 * Created by nerom on 7-9-2015.
 *//*


public class MijnConnectieMS {
    String connectionString = "jdbc:sqlserver://xh9kfg5xxu.database.windows.net:1433" + ";" +
            "database=vincentfree" + ";" + "user=vincentfree@xh9kfg5xxu" + ";" +
            "password=po2Y#Scq" + ";" +
            "encrypt=true" + ";" + "hostNameInCertificate=*.int.mscds.com" + ";" +
            "loginTimeout=30";

    static Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DataSource ds = new SimpleDataSource();
            Connection conn = ds.getConnection("eeqpqotkayfqcp", "U_d-9cYakIbUrH5vDHReRTaSI4");
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException sqle) {
            System.out.println("Fout bij het inloggen: " + sqle.getMessage());
            return null;
        }
    }
}

//jdbc:sqlserver://xh9kfg5xxu.database.windows.net:1433;database=vincentfree;user=vincentfree@xh9kfg5xxu;password={your_password_here};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;

*/
