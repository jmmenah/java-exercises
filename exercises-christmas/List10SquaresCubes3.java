// List the first ten squares and cubes
// Solution (bad) using only one loop

public class List10SquaresCubes3 {

	public static void main(String[] args) {
		System.out.printf("%48s\n", "List of the first ten squares and cubes");

		System.out.print("\nNumber:");

		for (int i = 1; i < 30; i++) {
			if (i < 10)
				System.out.printf("%5d", i);
			else if (i == 10)
				System.out.printf("%5d\nSquare:", i);
			else if (i < 20)
				System.out.printf("%5d", (i % 10) * (i % 10));
			else if (i == 20)
				System.out.printf("%5d\n  Cube:", i);
			else
				System.out.printf("%5d", (i % 10) * (i % 10) * (i % 10));

		}
		System.out.printf("%5d\n", (int) Math.pow(10, 3));
	}

}
