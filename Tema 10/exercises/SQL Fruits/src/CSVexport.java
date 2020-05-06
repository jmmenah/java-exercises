import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CSVexport {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:sqlite:db/fruits.db";

        String csvFilePath = "out/fruits.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL)) {
            String sql = "SELECT * FROM fruit";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

            // write header line containing column names
            fileWriter.write("id,name,color");

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String color = result.getString("color");

                String line = String.format("%d,%s,%s",
                        id,name,color);

                fileWriter.newLine();
                fileWriter.write(line);
            }

            statement.close();
            fileWriter.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }

    }

}