
public class LoadMySQLScript {
    public static void main(String[] args) {
        RunSQLScript myScript = new RunSQLScript("resources/createsampletables_mysql.sql", "resources/mysql.properties");

        if (!myScript.run()) System.out.println("ERROR");
    }
}
