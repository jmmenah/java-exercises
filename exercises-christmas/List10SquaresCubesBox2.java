// List the first ten squares and cubes
// formatting with ASCII box (Unicode) 
// Solution using statics methods
// https://illegalargumentexception.blogspot.com/2009/05/java-rough-guide-to-character-encoding.html

public class List10SquaresCubesBox2 {

	public static void main(String[] args) {
		System.out.printf("%55s\n", "List of the first ten squares and cubes");
	
		printLine("\u2554","\u2566","\u2557");  // Top line
		
		printNumbers("Number", 1);
		
		printLine("\u2560","\u256C","\u2563");  // Middle line
		
		printNumbers("Square", 2);
		
		printLine("\u2560","\u256C","\u2563");  // Middle line

		printNumbers("  Cube", 3);
		
		printLine("\u255A","\u2569","\u255D");  // Bottom line

	}


	public static void printLine(String start, String middle, String end) {
		// line for title
		System.out.print("\n" + start);
		for (int i = 1; i <= 9; i++) {
			System.out.print("\u2550");
		}
		System.out.print(middle);

		// line for each number
		for (int i = 1; i <= 59; i++) {
			if (i % 6 == 0) {
				System.out.print(middle);
			} else {
				System.out.print("\u2550");
			}
		}
		System.out.println(end);
	}

	public static void printNumbers(String text, int exp) {
		System.out.printf("\u2551%-5s:  \u2551" , text);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%4d \u2551", (int)Math.pow(i, exp));
		}
	}
	
}
