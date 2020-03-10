// Slides 23-25
/********************************
 * This solution does not work! *
 ********************************
 */

import java.io.*; // for File
import java.util.*; // for Scanner

public class HoursWorked {
	public static void main(String[] args) throws FileNotFoundException {
		// Secure decimal point with locale
		Locale.setDefault(new Locale("en", "US"));

		Scanner input = new Scanner(new File("hours.txt"));
		while (input.hasNext()) {
			// process one person
			int id = input.nextInt();
			String name = input.next();
			double totalHours = 0.0;
			int days = 0;
			
			while (input.hasNextDouble()) {
				totalHours += input.nextDouble();
				days++;
			}
			System.out.println(name + " (ID#" + id + ") worked " + totalHours + 
					           " hours (" + (totalHours / days) + " hours/day)");
		}
	}
}