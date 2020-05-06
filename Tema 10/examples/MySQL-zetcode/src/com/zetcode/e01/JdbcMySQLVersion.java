/*
 * MySQL Java tutorial
 * http://zetcode.com/db/mysqljava/
 * Jan Bodnar
 *
 * Java MySQL version
 */
package com.zetcode.e01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

// check the version of the MySQL server

public class JdbcMySQLVersion {

    public static void main(String[] args) {

        //String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false";

        //5.1.14 MySQL Server Time Zone Support
        // https://dev.mysql.com/doc/refman/8.0/en/time-zone-support.html
        // https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=" + TimeZone.getDefault().getID();
        // use docker inspect to get the IP of mysql container
        // String url = "jdbc:mysql://172.17.0.2:3306";

        //String user = "root";
        //String password = "docker";

        String user = "testuser";
        String password = "test623";

        String query = "SELECT VERSION()";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcMySQLVersion.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}

