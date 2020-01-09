// List the first ten squares and cubes
// Solution without using any method

public class List10SquaresCubes1 {

	public static void main(String[] args) {
		System.out.printf("%48s\n", "List of the first ten squares and cubes");

		System.out.print("\nNumber:");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%5d", i);
		}
		System.out.print("\nSquare:");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%5d", i * i);
		}
		System.out.print("\n  Cube:");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%5d", i * i * i);
		}
		System.out.println();
	}

}
