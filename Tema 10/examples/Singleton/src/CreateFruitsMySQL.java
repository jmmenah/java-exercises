/*
 * Do not forget to check the properties file.
 * Please make sure that the database exists. 
 */

// See MysqlConnect.java

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CreateFruitsMySQL {

	public static void showFruitRows(ResultSet rs) throws SQLException {
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
	}

	public static void main(String[] args) {
		// Call singleton
		MysqlConnect my = MysqlConnect.getDbCon();
		// System.out.println(my.conn);
		 
		String dropTable = "DROP TABLE IF EXISTS fruit;";
	
		String tableFruit = "CREATE TABLE fruit (\n" 
				  		  + "  id INT PRIMARY KEY auto_increment,\n"
				  		  + "  name VARCHAR(20) NOT NULL,\n"
				  		  + "  color VARCHAR(15) NOT NULL\n" + ");";
		
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
		
		String select = "SELECT * FROM fruit;";
		
		try {
			my.insert(dropTable);			
			my.insert(tableFruit);
			my.insert(insert);

			showFruitRows(my.query(select));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
