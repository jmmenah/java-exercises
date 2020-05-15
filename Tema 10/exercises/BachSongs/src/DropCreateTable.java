/*
 * See next examples:
 * 	- BatchExamplePlantsInsert.java
 * 	- BatchExamplePlantsCSV.java
 */

import java.sql.SQLException;

public class DropCreateTable {

    public DropCreateTable(MysqlConnect mysqlConnect) {
        try {
            String tableName = mysqlConnect.getTableName();

            mysqlConnect.insert("DROP TABLE IF EXISTS " + tableName);
            String table = "CREATE TABLE IF NOT EXISTS " + tableName + "("
                    + "  id INTEGER auto_increment,"
                    + "  theme TEXT NOT NULL,"
                    + "  title TEXT NOT NULL,"
                    + "  artist TEXT NOT NULL,"
                    + " year INTEGER NOT NULL CHECK (year > 1900 AND year < 2020),"
                    + " url TEXT,"
                    + " PRIMARY KEY (id)"
                    + ")";
            mysqlConnect.insert(table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
