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

// Data plants (plants.csv) from:
// https://mockaroo.com/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExamplePlantsCSV {

    private static void batchInsertRecordsIntoTable(MysqlConnect my, boolean usingBatch) {

        new DropCreateTable(my);

        String insertTableSQL = "INSERT INTO " + my.getTableName() + "(id, scientific_name, common_name, family) "
                + " VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = my.conn.prepareStatement(insertTableSQL);
             BufferedReader csvReader = new BufferedReader(new FileReader("data/plants.csv"))
        ) {
            my.conn.setAutoCommit(false);

            String row;
            long millis = System.currentTimeMillis();
            int count = 0;

            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");

                //System.out.println(data[0] + "# " + data[2]);

                preparedStatement.setInt(1, Integer.parseInt(data[0]));
                preparedStatement.setString(2, data[1]);
                preparedStatement.setString(3, data[2]);
                preparedStatement.setString(4, data[3]);

                count++;

                if (!usingBatch) {
                    preparedStatement.executeUpdate();
                    //System.out.println(preparedStatement);
                } else {
                    preparedStatement.addBatch();
                    if (count % 200 == 0) {
                        preparedStatement.executeBatch();
                        preparedStatement.clearBatch();
                    }
                }
            }

            if (usingBatch) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
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
        //  JDBC batch performance: insert from CSV
        System.out.println("-- Batch Example Plants. Data rows from CSV --");
        System.out.println("----> PreparedStatement !!");
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
