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
                    + "  id INT PRIMARY KEY,"
                    + "  scientific_name VARCHAR(115),"
                    + "  common_name VARCHAR(40),"
                    + "  family VARCHAR(35)"
                    + ")";
            mysqlConnect.insert(table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
