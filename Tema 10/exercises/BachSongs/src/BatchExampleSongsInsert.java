/*
 * Based on:
 * JDBC PreparedStatement example – Batch Update
 * https://www.mkyong.com/jdbc/jdbc-preparedstatement-example-batch-update/
 *
 * Batch Insert In Java – JDBC
 * https://viralpatel.net/blogs/batch-insert-in-java-jdbc/
 *
 */

// MySQL Connector/J 8.0 Developer Guide - Connector/J Reference - Configuration Properties  
// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-configuration-properties.html

// Data plants (plants-insert.sql) from:
// https://mockaroo.com/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExampleSongsInsert {

    private static void batchInsertRecordsIntoTable(MysqlConnect my, boolean usingBatch) {

        new DropCreateTable(my);

        try (Statement stmt = my.conn.createStatement();
             BufferedReader sqlReader = new BufferedReader(new FileReader("data/songs-insert.sql"))
        ) {
            my.conn.setAutoCommit(false);


            String row;
            long millis = System.currentTimeMillis();
            int count = 0;

            while ((row = sqlReader.readLine()) != null) {

                count++;

                if (!usingBatch) {
                    stmt.executeUpdate(row);
                    // System.out.println(row);
                } else {
                    stmt.addBatch(row.replace(";", ""));
                    if (count % 200 == 0) {
                        stmt.executeBatch();
                        stmt.clearBatch();
                    }
                }
            }

            if (usingBatch) {
                stmt.executeBatch();
                stmt.clearBatch();
            }
            System.out.println("Execution time: " + (System.currentTimeMillis() - millis) + " milliseconds");
            my.conn.commit();
            System.out.printf("%d Records inserted into %s table!%n", count, my.getTableName());

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            try {
                my.conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //  JDBC batch performance: insert from sql script
        System.out.println("-- Batch Example Songs. Data rows from sql script --");
        System.out.println("---> Statement");

        MysqlConnect my = MysqlConnect.getDbCon();

        System.out.println("\nUsing executeUpdate");
        batchInsertRecordsIntoTable(my, false);

        System.out.println("\nUsing addBatch - executeBatch");
        batchInsertRecordsIntoTable(my, true);

        try {
            my.conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
