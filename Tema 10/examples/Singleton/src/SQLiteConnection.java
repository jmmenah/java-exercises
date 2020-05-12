// SQLite Connection
// Using Singleton Design Pattern

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

public class SQLiteConnection {

	private static Connection sqliteConnection = null;

	private SQLiteConnection() {
	}

	public static Connection getSQLiteConnection(String dbName) {
		if (sqliteConnection == null) {
			try {
				String url = "jdbc:sqlite:db/" + dbName;
				SQLiteConfig config = new SQLiteConfig();
				config.enforceForeignKeys(true);
				sqliteConnection = DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sqliteConnection;
	}

	public static void closeSQLiteConnection() {
		if (sqliteConnection != null) {
			try {
				sqliteConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}