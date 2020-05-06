/*
 * How to run .SQL script using JDBC?
 * https://www.tutorialspoint.com/how-to-run-sql-script-using-jdbc
 * Nishtha Thakur
 *
 * You can execute .sql script files in Java using the runScript() method of the ScriptRunner class of Apache iBatis
 * https://github.com/mybatis/mybatis-3
 */
package com.zetcode.e02;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

// Creating and populating tables: mysql_tables.sql
// http://zetcode.com/db/mysqljava/
// This example is not in the original tutorial

public class RunningSQLScript {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost";
        // use docker inspect to get the IP of mysql container
        /*
        String url = "jdbc:mysql://172.17.0.2:3306";
        String user = "root";
        String password = "docker";
        */

       String user = "testuser";
       String password = "test623";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement()) {

            //Initialize the script runner
            ScriptRunner sr = new ScriptRunner(con);
            //Creating a reader object
            Reader reader = new BufferedReader(new FileReader("mysql_tables.sql"));
            //Running the script
            sr.runScript(reader);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(RunningSQLScript.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

