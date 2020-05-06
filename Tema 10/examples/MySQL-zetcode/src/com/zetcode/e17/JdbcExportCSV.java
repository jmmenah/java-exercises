/*
 * MySQL Java tutorial
 * http://zetcode.com/db/mysqljava/
 * Jan Bodnar
 *
 * Exporting data to a CSV file
 */

// GRANT FILE ON *.* TO 'testuser'@'localhost';
/*
mysql> SHOW VARIABLES LIKE "secure_file_priv";
+------------------+-----------------------+
| Variable_name    | Value                 |
+------------------+-----------------------+
| secure_file_priv | /var/lib/mysql-files/ |
+------------------+-----------------------+
 */

package com.zetcode.e17;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcExportCSV {

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

        String query = "SELECT Name, Title INTO OUTFILE "
                + "'/var/lib/mysql-files/authors_books.csv' "
                + "FIELDS TERMINATED BY ',' "
                + "FROM Authors, Books WHERE "
                + "Authors.Id=Books.AuthorId";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.execute();
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcExportCSV.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}

