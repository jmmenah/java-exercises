// slides 17-18
// Displays changes in temperature from data in an input file.
// Modify the temperature program to process the entire file, 
// regardless of how many numbers it contains.

import java.io.*; // for File
import java.util.*; // for Scanner

public class Temperatures2 {
	public static void main(String[] args) throws FileNotFoundException {
		// Secure decimal point with locale
		Locale.setDefault(new Locale("en", "US"));

		Scanner input = new Scanner(new File("weather2.txt"));
		
		double prev = input.nextDouble(); // fencepost
		while (input.hasNextDouble()) {
			double next = input.nextDouble();
			System.out.printf("%.1f to %.1f, change = %.1f%n", prev, next, next - prev);
			//System.out.println(prev + " to " + next + ", change = " + (next - prev));
			prev = next;
		}
	}
}