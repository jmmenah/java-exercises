/*
 * SQLite Java: Create a New Table
 * http://www.sqlitetutorial.net/sqlite-java/create-table/
 *
 */

// package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sqlitetutorial.net
 */
public class TestCreateNewTable {

    /**
     * Create a new table in the test database
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/test.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " capacity real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }
}