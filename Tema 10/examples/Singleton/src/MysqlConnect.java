/*
 * A Singleton Java class for MySQL DB connection
 * http://rdeshapriya.com/a-singleton-java-class-for-mysql-db-connection/
 * 
 */

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class MysqlConnect {
	public Connection conn;
	private Statement statement;
	public static MysqlConnect db;

	private MysqlConnect() {
		// db parameters
		Properties p = getPropertiesFromFile("resources/config.properties");
		String dbName = p.getProperty("db");
		String url = p.getProperty("url");
		String userName = p.getProperty("user");
		String password = p.getProperty("password");

		try {
			this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * @desc Method to get properties from config file
	 * @param fileName String
	 * @return Properties
	 */
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

	/**
	 *
	 * @return MysqlConnect Database connection object
	 */
	public static synchronized MysqlConnect getDbCon() {
		if (db == null) {
			db = new MysqlConnect();
		}
		return db;
	}

	/**
	 *
	 * @param query String The query to be executed
	 * @return a ResultSet object containing the results or null if not available
	 * @throws SQLException
	 */
	public ResultSet query(String query) throws SQLException {
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		//System.out.println(query + "\n");
		return res;
	}

	/**
	 * @desc Method to insert data to a table
	 * @param insertQuery String The Insert query
	 * @return boolean
	 * @throws SQLException
	 */
	public int insert(String insertQuery) throws SQLException {
		statement = db.conn.createStatement();
		int result = statement.executeUpdate(insertQuery);
		// System.out.println(insertQuery + "\n");
		return result;
	}
}