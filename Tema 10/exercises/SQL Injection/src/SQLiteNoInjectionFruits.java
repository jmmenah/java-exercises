import java.sql.*;
import java.util.Scanner;

public class SQLiteNoInjectionFruits {

    public static void main(String[] args) {
        select();
    }


    public static void select() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a fruit name: ");
        String name = sc.nextLine();
        System.out.print("Enter a fruit color: ");
        String color = sc.nextLine();
        String sql = "SELECT id, name, color FROM fruit WHERE name = ?" +
                "AND color = ?";
        Connection c = SQLiteConnectionShutdown.getSqliteConnection();
        try (PreparedStatement prsmt = c.prepareStatement(sql);
             ) {
            prsmt.setString(1, name);
            prsmt.setString(2, color);
            prsmt.executeQuery();

            ResultSet rs = prsmt.executeQuery();
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

