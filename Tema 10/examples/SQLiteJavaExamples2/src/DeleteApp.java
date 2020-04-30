/*
 * SQLite Java: Deleting Data
 * http://www.sqlitetutorial.net/sqlite-java/delete/
 *
 */

//package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author sqlitetutorial.net
 */
public class DeleteApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Delete a warehouse specified by the id
     *
     * @param id
     */
    public int delete(int id) {
        String sql = "DELETE FROM warehouses WHERE id = ?";
        int deletedRows = 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            deletedRows = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deletedRows;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DeleteApp app = new DeleteApp();
        // delete the row with id 3
        if (app.delete(3) == 1)
            System.out.println("deleted row with id 3");
        else System.out.println("No row found with id 3");
    }
}