/*
 * MySQL Java tutorial
 * http://zetcode.com/db/mysqljava/
 * Jan Bodnar
 *
 * Transaction support
 */

// SELECT Name, Title From Authors, Books WHERE Authors.Id=Books.AuthorId;

package com.zetcode.e14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcTransaction {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
        String user = "testuser";
        String password = "test623";

        // use docker inspect to get the IP of mysql container
        /*
        String url = "jdbc:mysql://172.17.0.2:3306/testdb";
        String user = "root";
        String password = "docker";
        */

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            try (Statement st = con.createStatement()) {

                con.setAutoCommit(false);

                st.executeUpdate("UPDATE Authors SET Name = 'Leo Tolstoy'"
                        + "WHERE Id = 1");
                st.executeUpdate("UPDATE Books SET Title = 'War and Peace'"
                        + "WHERE Id = 1");
                st.executeUpdate("UPDATE Books SET Titl = 'Anna Karenina'"
                        + "WHERE Id = 2");  // There is no Titl column in the table

                con.commit();

            } catch (SQLException ex) {

                try {

                    con.rollback();
                } catch (SQLException ex1) {

                    Logger lgr = Logger.getLogger(JdbcTransaction.class.getName());
                    lgr.log(Level.WARNING, ex1.getMessage(), ex1);
                }

                Logger lgr = Logger.getLogger(JdbcTransaction.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcTransaction.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}
