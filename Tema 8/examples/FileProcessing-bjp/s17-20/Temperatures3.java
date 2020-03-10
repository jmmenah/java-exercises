
// slides 19-20
// Displays changes in temperature from data in an input file.
// Modify the temperature program to handle files 
// that contain non-numeric tokens (by skipping them)

import java.io.*; // for File
import java.util.*; // for Scanner

public class Temperatures3 {
	public static void main(String[] args) throws FileNotFoundException {
		// Secure decimal point with locale
		Locale.setDefault(new Locale("en", "US"));
		Scanner input = new Scanner(new File("weather3.txt"));
		// You may assume that the file begins with a real number
		double prev = input.nextDouble(); // fencepost
		while (input.hasNext()) {
			if (input.hasNextDouble()) {
				double next = input.nextDouble();
				System.out.printf("%.1f to %.1f, change = %.1f%n", prev, next, next - prev);
				// System.out.println(prev + " to " + next + ", change = " + (next - prev));
				prev = next;
			} else {
				input.next(); // throw away unwanted token
			}
		}
	}
}