/*
 * MySQL Java tutorial
 * http://zetcode.com/db/mysqljava/
 * Jan Bodnar
 *
 * Java MySQL multiple statements
 */

package com.zetcode.e09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcMulStat {

    public static void main(String[] args) throws SQLException {

        String cs = "jdbc:mysql://localhost:3306/"
                + "testdb?allowMultiQueries=true&useSSL=false";
        String user = "testuser";
        String password = "test623";

        // use docker inspect to get the IP of mysql container
        /*
        String cs = "jdbc:mysql://172.17.0.2:3306/"
                + "testdb?allowMultiQueries=true&useSSL=false";;
        String user = "root";
        String password = "docker";
        */

        String query = "SELECT Id, Name FROM Authors WHERE Id=1;"
                + "SELECT Id, Name FROM Authors WHERE Id=2;"
                + "SELECT Id, Name FROM Authors WHERE Id=3";

        try (Connection con = DriverManager.getConnection(cs, user, password);
             PreparedStatement pst = con.prepareStatement(query);) {

            boolean isResult = pst.execute();

            do {
                try (ResultSet rs = pst.getResultSet()) {

                    while (rs.next()) {

                        System.out.print(rs.getInt(1));
                        System.out.print(": ");
                        System.out.println(rs.getString(2));
                    }

                    isResult = pst.getMoreResults();
                }

            } while (isResult);
        }
    }
}
