// slide 16
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestHasNext {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner console = new Scanner(System.in);
		System.out.print("How old are you? ");
		if (console.hasNextInt()) {
			int age = console.nextInt(); // will not crash!
			System.out.println("Wow, " + age + " is old!");
		} else {
			System.out.println("You didn't type an integer.");
		}
		
		Scanner input = new Scanner(new File("example.txt"));
		if (input.hasNext()) {
		    String token = input.next();   // will not crash!
		    System.out.println("next token is " + token);
		}
	}
}
