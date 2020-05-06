/*
 * MySQL Java tutorial
 * http://zetcode.com/db/mysqljava/
 * Jan Bodnar
 *
 * MySQL Java writing images
 */
/*
 * tree.png
 * Autor pictogramas: Sergio Palao Procedencia: ARASAAC (http://arasaac.org)
 * Licencia: CC (BY-NC-SA) Propiedad: Gobierno de Aragón
 */

package com.zetcode.e12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcWriteImage {

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
        String sql = "INSERT INTO Images(Data) VALUES(?)";

        try (Connection con = DriverManager.getConnection(cs, user, password);
             PreparedStatement pst = con.prepareStatement(sql)) {

            File myFile = new File("resources/tree.png");

            try (FileInputStream fin = new FileInputStream(myFile)) {

                pst.setBinaryStream(1, fin, (int) myFile.length());
                pst.executeUpdate();

            } catch (IOException ex) {

                Logger lgr = Logger.getLogger(JdbcWriteImage.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcWriteImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
