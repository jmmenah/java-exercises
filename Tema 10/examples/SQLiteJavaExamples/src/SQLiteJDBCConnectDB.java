// https://www.tutorialspoint.com/sqlite/sqlite_java.htm

// Connect to Database

import java.sql.*;

public class SQLiteJDBCConnectDB {
	public static void main(String args[]) {
		Connection c = null;

		try {
			// Class.forName("org.sqlite.JDBC");
			// c = DriverManager.getConnection("jdbc:sqlite:test.db");

			c = DriverManager.getConnection("jdbc:sqlite::memory:");

			System.out.println(c.getMetaData().getDriverVersion());
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}