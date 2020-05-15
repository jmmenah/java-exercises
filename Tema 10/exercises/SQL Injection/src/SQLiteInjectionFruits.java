import java.sql.*;
import java.util.Scanner;

public class SQLiteInjectionFruits {

    public static void main(String[] args) {
        select();
    }


    public static void select() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a fruit name: ");
        String name = sc.nextLine();
        System.out.print("Enter a fruit color: ");
        String color = sc.nextLine();
        String sql = "SELECT id, name, color FROM fruit WHERE name ='" + name + "' AND color ='" + color +"';";
        System.out.println(sql);
        try (Connection c = SQLiteConnectionShutdown.getSqliteConnection();
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("color"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
