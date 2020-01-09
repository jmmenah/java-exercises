// List the first ten squares and cubes
// Solution using a static method

public class List10SquaresCubes2 {

	public static void main(String[] args) {
		System.out.printf("%48s\n", "List of the first ten squares and cubes");
		printNumbers("Number", 1);
		printNumbers("Square", 2);
		printNumbers("  Cube", 3);
		System.out.println();
	}

	public static void printNumbers(String text, int exp) {
		System.out.printf("\n%s:", text);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%5d", (int) Math.pow(i, exp));
		}
	}
	
}