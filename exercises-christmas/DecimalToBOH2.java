// Modify exercise 12 for the change of base (binary, octal and hexadecimal) is performed using a single method. 
// This method must use a loop.
// Hint: toBase(int n, int base)

// https://docs.oracle.com/javase/10/docs/api/java/lang/Integer.html
// https://howtodoinjava.com/java/binary-octal-and-hexadecimal-conversions-in-java/

import java.util.Scanner;

public class DecimalToBOH2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int number;
		// Taking input from user until enter 0
		do {
			System.out.print("\nEnter a decimal number (0 to exit): ");

			while (!input.hasNextInt()) {
				clearScreen();
				System.out.print("Please, enter an integer number: ");
				input.nextLine();
			}

			number = input.nextInt();
			if (number >= 0) {
				clearScreen();
				System.out.println("\n\t" + number + " in binary = " + toBase(number, 2));
				System.out.println("\n\t" + number + " in octal = " + toBase(number, 8));
				System.out.println("\n\t" + number + " in hexadecimal = " + toBase(number, 16));

			} else {
				System.out.println("Please, only positive integer.");
			}
		} while (number != 0);
		input.close();
		System.out.println("\nGoodbye!");
	}

	// Accepts an integer as a parameter and returns a string
	// of that number's representation in other base (2 --> 16)
	public static String toBase(int n, int base) {
		if (n == 0)
			return "0";

		String digits = "0123456789ABCDEF";

		String newBase = ""; // Initializing to empty string

		while (n != 0) {
			newBase = digits.charAt(n % base) + newBase;
			n /= base;
		}
		return newBase;
	}

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	// http://techno-terminal.blogspot.com/2014/12/clear-command-line-console-and-bold.html
	// https://en.wikipedia.org/wiki/ANSI_escape_code
	// Doesn't work in Eclipse
	public static void clearScreen() {

		System.out.print("\033\143"); // echo -e '\0033\0143'
		/*
		 * System.out.print("\033[H\033[2J"); System.out.flush();
		 */
	}
}
