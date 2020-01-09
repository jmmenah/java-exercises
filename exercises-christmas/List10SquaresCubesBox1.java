// List the first ten squares and cubes
// formatting with ASCII box
// Solution using statics methods

public class List10SquaresCubesBox1 {

	public static void main(String[] args) {
		System.out.printf("%55s\n", "List of the first ten squares and cubes");

		printLine();
		
		printNumbers("Number", 1);
		printNumbers("Square", 2);
		printNumbers("  Cube", 3);
	}

	public static void printLine() {
		// line for title
		System.out.print("\n+");
		for (int i = 1; i <= 9; i++) {
			System.out.print("-");
		}
		System.out.print("+");

		// line for each number
		for (int i = 1; i <= 60; i++) {
			if (i % 6 == 0) {
				System.out.print("+");
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	public static void printNumbers(String text, int exp) {
		//System.out.print("|" + text + ":  |");
		System.out.printf("|%-5s:  |" , text);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%4d |", (int)Math.pow(i, exp));
		}
		printLine();
	}
	
}
