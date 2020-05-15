/*
 * Examples from Introduction to Java Programming, 11E, Y. Daniel Liang
 * https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/content/ExampleByChapters.html
 */

package chapter35;

import java.sql.SQLException;
import javax.sql.RowSet;

import com.sun.rowset.*;

public class SimpleRowSet {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        //Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Driver loaded");

        // Create a row set
        RowSet rowSet = new JdbcRowSetImpl();

        // Set RowSet properties
        rowSet.setUrl("jdbc:mysql://localhost/javabook");
        //rowSet.setUrl("jdbc:oracle:thin:@localhost:49161:xe");

        rowSet.setUsername("scott");
        rowSet.setPassword("tiger");
        rowSet.setCommand("select firstName, mi, lastName " +
                "from Student where lastName = 'Smith'");
        rowSet.execute();

        // Iterate through the result and print the student names
        while (rowSet.next())
            System.out.println(rowSet.getString(1) + "\t" +
                    rowSet.getString(2) + "\t" + rowSet.getString(3));

        // Close the connection
        rowSet.close();
    }
}