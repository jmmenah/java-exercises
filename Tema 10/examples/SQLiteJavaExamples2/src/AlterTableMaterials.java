/*
 * SQLite Java: Alter Table
 * SQLite Java: Write and Read BLOB
 * http://www.sqlitetutorial.net/sqlite-java/jdbc-read-write-blob/
 *
 */

// package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sqlitetutorial.net
 */
public class AlterTableMaterials {

    /**
     * Alter table materials. Add new column
     */
    public static void alterTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/test.db";

        // SQL statement for Alter table, adding a new column
        String sql = "ALTER TABLE materials ADD COLUMN picture blob";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // Check if materials table exists
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getTables(null, null, "materials", null);

            if (!rs.next()) {
                System.out.println("Table 'materials' does not exist");
                return;
            }
            // execute alter table
            stmt.execute(sql);

            System.out.println(sql + "\n");

            // Describe materials table
            sql = "SELECT sql FROM sqlite_master WHERE name='materials'";
            rs = stmt.executeQuery(sql);
            rs.next();
            System.out.println(rs.getString(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        alterTable();
    }
}