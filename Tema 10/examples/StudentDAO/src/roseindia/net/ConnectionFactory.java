/*
 *  Data Access object (DAO) Design Pattern
 *  https://www.roseindia.net/tutorial/java/jdbc/dataaccessobjectdesignpattern.html
 *
 */

package roseindia.net;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    // String driverClassName = "com.mysql.jdbc.Driver";
	// db parameters
	private String connectionUrl;
	private String dbUser;
	private String dbPwd;

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
		Properties p = getPropertiesFromFile("resources/config.properties");
		connectionUrl = p.getProperty("url");
		dbUser = p.getProperty("user");
		dbPwd = p.getProperty("password");
		/*
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

	private static Properties getPropertiesFromFile(String fileName) {
		Properties prop = new Properties();
		// load a properties file
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
