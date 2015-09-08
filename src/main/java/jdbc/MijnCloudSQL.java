package jdbc;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nerom on 7-9-2015.
 */
public class MijnCloudSQL {
    public static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("postgres://eeqpqotkayfqcp:U_d-9cYakIbUrH5vDHReRTaSI4@ec2-54-217-202-109.eu-west-1.compute.amazonaws.com:5432/d8fs2jf5ccevdf"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgres://"
                + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
}