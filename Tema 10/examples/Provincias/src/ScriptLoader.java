import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// PRAGMA foreign_keys = ON;

public class ScriptLoader {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Connection c = SQLiteConnectionShutdown.getSqliteConnection();

        List<String> statementsList = createStatementsList("resources/autonomias-provincias.sql");
        /*
        for (int i = 0; i < statementsList.size(); i++) {
            System.out.printf("Statement #%d%n", i);
            System.out.println(statementsList.get(i));
        }
        */
        Statement statement = c.createStatement();

        for (String s : statementsList) {
            statement.addBatch(s);
        }

        statement.executeBatch();

        statement.close();
    }

       private static List<String> createStatementsList(String scriptFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(scriptFile));
        List<String> statementsList = new ArrayList<>();
        sc.useDelimiter(";");

        while (sc.hasNext()) {
            statementsList.add(sc.next());
        }
        return statementsList;
    }

}
