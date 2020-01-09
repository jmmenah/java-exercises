
// https://docs.oracle.com/javase/10/docs/api/java/lang/Integer.html
// https://howtodoinjava.com/java/binary-octal-and-hexadecimal-conversions-in-java/

import java.util.Scanner;

public class DecimalToBinary1 {

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
				System.out.println("\n\t" + number + " in binary = " + toBinary(number));
				System.out.println("\n\t" + number + " in binary = " + Integer.toString(number, 2));
				System.out.println("\n\t" + number + " in binary = " + Integer.toBinaryString(number));
			} else {
				System.out.println("Please, only positive integer.");
			}
		} while (number != 0);
		input.close();
		System.out.println("\nGoodbye!");
	}

	// BJP4 Exercise 5.3: toBinary
	// https://practiceit.cs.washington.edu/problem/view/bjp4/chapter5/e3%2DtoBinary
	// Accepts an integer as a parameter and returns a string
	// of that number's representation in binary.
	public static String toBinary(int n) {
	// Complete this method
		return "code your solution";
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
