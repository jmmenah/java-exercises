
import java.io.*;
import java.sql.*;

public class Skyscrapers {


    public static void main(String[] args) {
        createTable();
        inserts();
        deleteHeight(250);
        exportHTML();
        //selectAll();

    }

    public void executeUpdate(String sql) {

        Connection c = SQLiteConnectionShutdown.getSqliteConnection();

        try (Statement stmt = c.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println(sql + "\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createTable() {

        Skyscrapers sky = new Skyscrapers();

        sky.executeUpdate("DROP TABLE IF EXISTS sky;");

        String tableSky = "CREATE TABLE sky (\n"
                + "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "  name TEXT NOT NULL,\n"
                + "  city TEXT NOT NULL,\n"
                + "  height INTEGER NOT NULL,\n"
                + "  floors INTEGER NOT NULL\n"
                + ");";
        sky.executeUpdate(tableSky);
        System.out.println("Table sky created!");
    }

    public static void inserts(){

        int countInserts=0;

        Connection c = SQLiteConnectionShutdown.getSqliteConnection();

        String insertTableSQL = "INSERT INTO sky (name,city,height,floors) "
                + " VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = c.prepareStatement(insertTableSQL)) {
            try (BufferedReader csvReader = new BufferedReader(new FileReader("data/skyscrapers.csv"))) {
                c.setAutoCommit(false);
                String row;

                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",", -1);

                    preparedStatement.setString(1, data[0]);
                    preparedStatement.setString(2, data[1]);
                    preparedStatement.setInt(3, Integer.parseInt(data[2]));
                    preparedStatement.setInt(4, Integer.parseInt(data[3]));
                    preparedStatement.addBatch();

                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();

                    c.commit();
                    countInserts++;
                }
            }
            System.out.println(countInserts+" rows inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            try {
                c.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void selectAll() {

        Connection c = SQLiteConnectionShutdown.getSqliteConnection();

        String sql = "SELECT id, name, city, height, floors FROM sky";

        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +"\t"+
                        rs.getString("name") +"\t"+
                        rs.getString("city") +"\t"+
                        rs.getInt("height") +"\t"+
                        rs.getInt("floors") +"\t"
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteHeight(int height) {

        int deletedRows = 0;

        Connection c = SQLiteConnectionShutdown.getSqliteConnection();

        String sql = "DELETE FROM sky WHERE height < ?";

        try (PreparedStatement pstmt = c.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, height);
            // execute the delete statement
            deletedRows = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Deleted rows = " + deletedRows);
    }

    public static void exportHTML() {

        Connection c = SQLiteConnectionShutdown.getSqliteConnection();

        String csvFilePath = "data/skyscrapers.html";

        try (Statement statement = c.createStatement()) {
            String sql = "SELECT * FROM sky";

            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

            fileWriter.write("<ol>");

            while (result.next()) {
                String name = result.getString("name");
                String city = result.getString("city");
                int height = result.getInt("height");

                String line = String.format("<li>[%d meters] %s (%s)</li>",height,name,city);

                fileWriter.newLine();
                fileWriter.write(line);
            }
            fileWriter.newLine();
            fileWriter.write("</ol>");
            fileWriter.close();
            System.out.println("Ordered list created!");

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }

    }

}
