import java.sql.*;

public class Database {

    public static void connect() {
        // db parameters
        String url = "jdbc:sqlite:db/fruits.db";

        // create a connection to the database with try-with-resources statement
        // that ensures that each resource is closed at the end of the statement
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/fruits.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS fruit (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " color text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param color
     */
    public void insert(String name, String color) {
        String sql = "INSERT INTO fruit(name,color) VALUES(?,?)";
        String url = "jdbc:sqlite:db/fruits.db";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, color);
            pstmt.executeUpdate();
            System.out.printf("INSERT INTO fruits VALUES(%s, %s);%n", name, color);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAll() {
        String sql = "SELECT id, name, color FROM fruit";
        String url = "jdbc:sqlite:db/fruits.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +"\t"+
                        rs.getString("name") +"\t"+
                        rs.getString("color"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
        createNewTable();
        Database fruit = new Database();
        fruit.insert("apple","red");
        fruit.insert("banana","yellow");
        fruit.insert("watermelon","green");
        fruit.insert("pear","yellow");
        fruit.insert("orange","orange");
        fruit.insert("apple","yellow");
        fruit.insert("grape","purple");
        fruit.insert("apple","green");
        fruit.insert("kiwi","green");
        fruit.insert("strawberry","red");

        System.out.println("id"+"\t"+"name"+"\t"+"color");
        System.out.println("---------------------------");
        fruit.selectAll();

    }
}
