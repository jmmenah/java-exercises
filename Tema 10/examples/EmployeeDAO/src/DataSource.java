/*
 * Data Access Object Design Pattern or DAO Pattern
 * https://ramj2ee.blogspot.com/2013/08/data-access-object-design-pattern-or.html
 * https://github.com/ramram43210/Java/tree/master/designpattern/DAO
 */

import java.sql.Connection;

// The DBCP Component
// https://commons.apache.org/proper/commons-dbcp/
import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {
    private Connection connection = null;
    private BasicDataSource bdSource = new BasicDataSource();

    public DataSource() {
        // bdSource.setDriverClassName("com.mysql.jdbc.Driver");
        bdSource.setUrl("jdbc:mysql://localhost:3306/EMP");
        bdSource.setUsername("root");
        bdSource.setPassword("root");
    }

    public Connection createConnection() {
        Connection con = null;
        try {
            if (connection != null) {
                System.out.println("Can't create a New Connection");
            } else {
                con = bdSource.getConnection();
            }
        } catch (Exception e) {
            System.out.println("Error Occurred " + e.toString());
        }
        return con;
    }
}
