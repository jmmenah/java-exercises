// https://liveexample.pearsoncmg.com/liang/intro11e/html/SimpleJdbcWithAutoClose.html

package chapter34.mysql;

import java.sql.*;

public class SimpleJdbcWithAutoClose {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        //Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Driver loaded");

        // Connect to a database
        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook", "scott", "tiger")) {
            System.out.println("Database connected");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a statement
            ResultSet resultSet = statement
                    .executeQuery("select firstName, mi, lastName from Student where lastName " + " = 'Smith'");

            // Iterate through the result and print the student names
            while (resultSet.next())
                System.out.println(
                        resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
        }
    }
}
