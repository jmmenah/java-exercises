import org.sqlite.SQLiteConfig;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLiteConnectionShutdown {
    private static Connection sqliteConnection = null;

    private SQLiteConnectionShutdown() {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new closeSQLiteConnection());
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("resources/sqlite.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");

        SQLiteConfig sqLiteConfig = new SQLiteConfig();
        sqLiteConfig.enforceForeignKeys(true);

        try {
            sqliteConnection = DriverManager.getConnection(url, sqLiteConfig.toProperties());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getSqliteConnection()  {
        if (sqliteConnection == null)
            new SQLiteConnectionShutdown();
        return sqliteConnection;
    }

    static class closeSQLiteConnection extends Thread {
        public void run() {
            try {
                Connection connection = getSqliteConnection();
                if (connection != null)
                    connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println("Bye.");
        }
    }
}
