// It is NOT necessary to change this file
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
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

	public Connection getConnection() throws SQLException {

		// db parameters
		Properties p = getPropertiesFromFile("resources/config.properties");
		String dbName = p.getProperty("db");
		String url = p.getProperty("url");
		String userName = p.getProperty("user");
		String password = p.getProperty("password");

		Connection conn = null;
		conn = DriverManager.getConnection(url + dbName, userName, password);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

}