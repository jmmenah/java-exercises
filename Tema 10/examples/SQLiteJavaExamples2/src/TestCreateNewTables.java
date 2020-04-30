/*
 * SQLite Java: Transaction
 * http://www.sqlitetutorial.net/sqlite-java/transaction/
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
public class TestCreateNewTables {

    /**
     * Create new tables in the test database
     */
    public static void createNewTable(String table) {
        // SQLite connection string
        String url = "jdbc:sqlite:db/test.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(table);
            System.out.println(table);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // SQL statement for creating a new table materials
        String sql = "CREATE TABLE IF NOT EXISTS materials (\n"
                + "  id integer PRIMARY KEY,\n"
                + "  description text NOT NULL UNIQUE\n"
                + ");";
        createNewTable(sql);

        // SQL statement for creating a new table inventory
        sql = "CREATE TABLE IF NOT EXISTS inventory (\n"
                + "  warehouse_id integer,\n"
                + "  material_id integer,\n"
                + "  qty real,\n"
                + "  PRIMARY KEY (warehouse_id, material_id),\n"
                + "  FOREIGN KEY (warehouse_id) REFERENCES warehouses (id),\n"
                + "  FOREIGN KEY (material_id) REFERENCES materials (id)\n"
                + ");";
        createNewTable(sql);
    }
}