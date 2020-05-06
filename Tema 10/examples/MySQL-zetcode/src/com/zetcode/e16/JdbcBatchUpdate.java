/*
 * MySQL Java tutorial
 * http://zetcode.com/db/mysqljava/
 * Jan Bodnar
 *
 * Batch updates
 */

package com.zetcode.e16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcBatchUpdate {

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

                st.addBatch("DROP TABLE IF EXISTS Authors2");
                st.addBatch("CREATE TABLE Authors2(Id INT PRIMARY KEY, "
                        + "Name VARCHAR(100))");
                st.addBatch("INSERT INTO Authors2(Id, Name) "
                        + "VALUES(1, 'Jack London')");
                st.addBatch("INSERT INTO Authors2(Id, Name) "
                        + "VALUES(2, 'Honore de Balzac')");
                st.addBatch("INSERT INTO Authors2(Id, Name) "
                        + "VALUES(3, 'Lion Feuchtwanger')");
                st.addBatch("INSERT INTO Authors2(Id, Name) "
                        + "VALUES(4, 'Emile Zola')");
                st.addBatch("INSERT INTO Authors2(Id, Name) "
                        + "VALUES(5, 'Truman Capote')");
                st.addBatch("INSERT INTO Authors2(Id, Name) "
                        + "VALUES(6, 'Umberto Eco')");

                int counts[] = st.executeBatch();

                con.commit();

                System.out.printf("Committed %d updates", counts.length);

            } catch (SQLException ex) {
                try {

                    con.rollback();
                } catch (SQLException ex2) {

                    Logger lgr = Logger.getLogger(JdbcBatchUpdate.class.getName());
                    lgr.log(Level.FINEST, ex2.getMessage(), ex2);
                }

                Logger lgr = Logger.getLogger(JdbcBatchUpdate.class.getName());
                lgr.log(Level.FINEST, ex.getMessage(), ex);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JdbcBatchUpdate.class.getName());
            lgr.log(Level.FINEST, ex.getMessage(), ex);
        }
    }
}
