/*
 * How to run .SQL script using JDBC?
 * https://www.tutorialspoint.com/how-to-run-sql-script-using-jdbc
 * Nishtha Thakur
 *
 * You can execute .sql script files in Java using the runScript() method of the ScriptRunner class of Apache iBatis
 * https://github.com/mybatis/mybatis-3
 */

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class RunSQLScript {

    private String sqlScriptName;
    private String propertiesFileName;

    public RunSQLScript(String sqlScriptName, String propertiesFileName) {
        this.sqlScriptName = sqlScriptName;
        this.propertiesFileName = propertiesFileName;
    }

    public boolean run() {
        boolean result = false;
        Properties props = getProperties();

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            //Initialize the script runner
            ScriptRunner sr = new ScriptRunner(con);
            //Creating a reader object
            Reader reader = new BufferedReader(new FileReader(sqlScriptName));
            //Running the script
            sr.runScript(reader);
            result = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            return result;
        }
    }

    private Properties getProperties() {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream(propertiesFileName)) {
            props.load(fis);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return props;
    }
}

