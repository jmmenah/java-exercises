/*
 * MySQL Java tutorial
 * http://zetcode.com/db/mysqljava/
 * Jan Bodnar
 *
 * Testing MySQL prepared and not prepared statements
 */

package com.zetcode.e04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcNotPreparedTesting {

    public static void main(String[] args) {

        String cs = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
        String user = "testuser";
        String password = "test623";

        // use docker inspect to get the IP of mysql container
        /*
        String cs = "jdbc:mysql://172.17.0.2:3306/testdb";
        String user = "root";
        String password = "docker";
        */

        // https://howtodoinjava.com/java/date-time/execution-elapsed-time/
        Instant start = Instant.now();

        try (Connection con = DriverManager.getConnection(cs, user, password);
             Statement st = con.createStatement()) {

            for (int i = 1; i <= 5000; i++) {

                String sql = "INSERT INTO Testing(Id) VALUES(" + 2 * i + ")";
                st.executeUpdate(sql);
            }

            Instant finish = Instant.now();

            long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
            System.out.println("Time = " + timeElapsed);

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcNotPreparedTesting.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
