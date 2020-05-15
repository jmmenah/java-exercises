// Example to test SQLite Connection
// Using Singleton Design Pattern

// See SQLiteConnectionShutdown.java

import java.sql.*;

public class CreateFruitsSQLite2 {

	private Connection c = SQLiteConnectionShutdown.getSqliteConnection();

	public void executeUpdate(String sql) {

		try (Statement stmt = c.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println(sql + "\n");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectFruits() {
		String sql = "SELECT * FROM fruit;\n";

		System.out.println(sql);
		try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.printf("%3s %-12s %s%n", rsmd.getColumnName(1), rsmd.getColumnName(2), rsmd.getColumnName(3));
			for (int i = 1; i <= 25; i++) {
				System.out.print("-");
			}
			System.out.println();
			// loop through the result set
			while (rs.next()) {
				System.out.printf("%3s %-12s %s%n", rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws SQLException {

		CreateFruitsSQLite2 fruits = new CreateFruitsSQLite2();
	
		fruits.executeUpdate("DROP TABLE IF EXISTS fruit;");

		String tableFruit = "CREATE TABLE fruit (\n" 
						  + "  id INTEGER PRIMARY KEY,\n" 
				          + "  name TEXT NOT NULL,\n"
				          + "  color TEXT NOT NULL\n" + ");";

		fruits.executeUpdate(tableFruit);
		
		String insert = "INSERT INTO fruit (name, color) VALUES \n" 
				  + "('apple', 'red'),\n"
				  + "('banana', 'yellow'),\n" 
				  + "('watermelon', 'green'),\n" 
				  + "('pear', 'yellow'),\n"
				  + "('orange', 'orange'),\n" 
				  + "('apple', 'yellow'),\n" 
				  + "('grape', 'purple'),\n"
				  + "('apple', 'green'),\n" 
				  + "('kiwi', 'green'),\n" 
				  + "('strawberry', 'red');";
		
		fruits.executeUpdate(insert);

		fruits.selectFruits();
	}
}
