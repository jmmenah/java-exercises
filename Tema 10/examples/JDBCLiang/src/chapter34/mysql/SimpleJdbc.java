/*
 * Examples from Introduction to Java Programming, 11E, Y. Daniel Liang
 * https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/content/ExampleByChapters.html
 */

package chapter34.mysql;

import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        // Class.forName("com.mysql.jdbc.Driver");
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //System.out.println("Driver loaded");

        // Establish a connection
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook", "scott", "tiger");

        System.out.println("Database connected");

        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a statement
        ResultSet resultSet = statement.executeQuery
                ("select firstName, mi, lastName from Student where lastName "
                        + " = 'Smith'");

        // Iterate through the result and print the student names
        while (resultSet.next())
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" + resultSet.getString(3));

        // Close the connection
        connection.close();
    }
}