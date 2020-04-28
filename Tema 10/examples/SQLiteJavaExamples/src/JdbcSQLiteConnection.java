// Making SQLite JDBC connection
// https://www.codejava.net/java-se/jdbc/connect-to-sqlite-via-jdbc

//package net.codejava.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This program demonstrates making JDBC connection to a SQLite database.
 * 
 * @author www.codejava.net
 *
 */
public class JdbcSQLiteConnection {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:product.db";
			Connection conn = DriverManager.getConnection(dbURL);

			// String dbURLMemory = "jdbc:sqlite::memory:";
			// Connection conn = DriverManager.getConnection(dbURLMemory);

			if (conn != null) {
				System.out.println("Connected to the database");
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				conn.close();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}