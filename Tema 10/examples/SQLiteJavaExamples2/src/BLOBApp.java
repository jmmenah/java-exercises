/*
 * SQLite Java: Write and Read BLOB
 * http://www.sqlitetutorial.net/sqlite-java/jdbc-read-write-blob/
 *
 * See AlterTableMaterials.java
 *
 */

//package net.sqlitetutorial;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sqlitetutorial.net
 */
public class BLOBApp {
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Read the file and returns the byte array
     *
     * @param file
     * @return the bytes of the file
     */
    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1; ) {
                bos.write(buffer, 0, len);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }

    /**
     * Update picture for a specific material
     *
     * @param materialId
     * @param filename
     */
    public void updatePicture(int materialId, String filename) {
        // update sql
        String updateSQL = "UPDATE materials "
                + "SET picture = ? "
                + "WHERE id=?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // set parameters
            pstmt.setBytes(1, readFile(filename));
            pstmt.setInt(2, materialId);

            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * read the picture file and insert into the material master table
     *
     * @param materialId
     * @param filename
     */
    public void readPicture(int materialId, String filename) {
        // update sql
        String selectSQL = "SELECT picture FROM materials WHERE id=?";
        ResultSet rs = null;
        FileOutputStream fos = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = connect();
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, materialId);
            rs = pstmt.executeQuery();

            // write binary stream into file
            File file = new File(filename);
            fos = new FileOutputStream(file);

            System.out.println("Writing BLOB to file " + file.getAbsolutePath());
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("picture");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BLOBApp app = new BLOBApp();

        // Insert BLOB data into SQLite database
        app.updatePicture(1, "img/HP_Laptop.jpg");

        // Query BLOB data from SQLite database
        app.readPicture(1, "img/HP_Laptop_BLOB.jpg");
    }
}