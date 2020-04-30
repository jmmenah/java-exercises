/*
 * SQLite Java: Select Data
 * http://www.sqlitetutorial.net/sqlite-java/select/
 *
 */

//package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sqlitetutorial.net
 */
public class SelectApp {

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
     * select all rows in the warehouses table
     */
    public void selectAll() {
        String sql = "SELECT id, name, capacity FROM warehouses";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Get the warehouse whose capacity greater than a specified capacity
     *
     * @param capacity
     */
    public void getCapacityGreaterThan(double capacity) {
        String sql = "SELECT id, name, capacity "
                + "FROM warehouses WHERE capacity > ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setDouble(1, capacity);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        System.out.println("Calling selectAll()...");
        app.selectAll();
        System.out.println("\nCalling getCapacityGreaterThan(3600)...");
        app.getCapacityGreaterThan(3600);
    }
}