// Print first n squares and cubes
// n is a command line argument and must be an integer between 1 and 100
// The header of the list will be shown every 5 lines

public class ListSquaresCubes {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Please, use: java ListSquaresCubes n");
			System.out.println("\twhere n is an integer between 1 and 100\n");
		} else if (isValid(args[0])) {
			int n = Integer.parseInt(args[0]);
			for (int i = 1; i <= n; i++) {
				if (i % 5 == 1) {
					printHeader();
				}
				System.out.printf("%4d\t %d\t %d\n", i, i * i, (int) Math.pow(i, 3));
			}
		} else {
			System.out.println("Please, only numbers from 1 to 100.");

		}
	}

	public static void printHeader() {
		System.out.println("\nNumber  Square   Cube");
		System.out.println("======  ======  ======");
	}

	// https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch06s07.html
	public static boolean isValid(String str) {
		return str.matches("^(100|[1-9][0-9]?)$"); // match a number from 1 to 100
	}

}
