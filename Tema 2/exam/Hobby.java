import java.util.Scanner;
public class Hobby {
	public static void main (String[]args) {
		Scanner console = new Scanner(System.in);
		System.out.println();
		System.out.println("/*/*/*/*/*/*/*/*/");
		System.out.println("|| Your Hobby! ||");
		System.out.println("\\*\\*\\*\\*\\*\\*\\*\\*\\");
		System.out.println();

		System.out.print("Please type your name: ");
		String name = console.nextLine();

		System.out.print("Please type your Hobby: ");
		String hobby = console.nextLine();

		System.out.println("	Hello " + name);
		System.out.println("	Your Hobby is \"" + hobby + "\"");
	}
}