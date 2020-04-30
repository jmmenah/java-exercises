/*
 * SQLite Java: Connect To The SQLite Database Using SQLite JDBC Driver
 * http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
 *
 * using try-with-resources Statement
 *
 */

//package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sqlitetutorial.net
 */
public class SQLiteJDBCDriverConnection2 {
    /**
     * Connect to a sample database
     */
    public static void connect() {
        // db parameters
        String url = "jdbc:sqlite:db/chinook.db";

        // create a connection to the database with try-with-resources statement
        // that ensures that each resource is closed at the end of the statement
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}