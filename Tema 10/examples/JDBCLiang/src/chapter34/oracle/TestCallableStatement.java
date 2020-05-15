/*
 * Examples from Introduction to Java Programming, 11E, Y. Daniel Liang
 * https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/content/ExampleByChapters.html
 */

package chapter34.oracle;

// CallableStatement enables you to execute SQL stored procedures.

// Jacob Smith

import java.sql.*;

public class TestCallableStatement {
    /**
     * Creates new form TestTableEditor
     */
    public static void main(String[] args) throws Exception {
//    Class.forName("oracle.jdbc.driver.OracleDriver");
        //Class.forName("com.mysql.jdbc.Driver");
//    Connection connection = DriverManager.getConnection(
//      "jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//      "scott", "tiger");
        Connection connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:49161:xe", "scott", "tiger");


        // Create a callable statement
        CallableStatement callableStatement = connection.prepareCall(
                "{? = call studentFound(?, ?)}");

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter student's first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter student's last name: ");
        String lastName = input.nextLine();
        input.close();

        callableStatement.setString(2, firstName);
        callableStatement.setString(3, lastName);
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.execute();

        if (callableStatement.getInt(1) >= 1)
            System.out.println(firstName + " " + lastName +
                    " is in the database");
        else
            System.out.println(firstName + " " + lastName +
                    " is not in the database");
    }
}