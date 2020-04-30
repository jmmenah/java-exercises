/*
 * SQLite Java: Connect To The SQLite Database Using SQLite JDBC Driver
 * http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
 *
 * using try-with-resources Statement
 * and a java properties file (resources/config.properties)
 *
 */

//package net.sqlitetutorial;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author sqlitetutorial.net
 */
public class SQLiteJDBCDriverConnection3 {
    /**
     * Connect to a sample database
     */
    public static void connect() {
        try {
            // db parameters
            String url = getURLFromPropertiesFile();

            // create a connection to the database with try-with-resources statement
            // that ensures that each resource is closed at the end of the statement
            try (Connection conn = DriverManager.getConnection(url)) {
                System.out.println("Connection to SQLite has been established.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read URL from properties file
     *
     * @throws IOException
     */
    public static String getURLFromPropertiesFile() throws IOException {
        Properties p = new Properties();
        // load arading/T78/PairMountains properties file
        p.load(new FileReader("resources/config.properties"));
        return p.getProperty("db.url");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}