import java.util.Scanner;

public class LearnScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("What is your name?");
        String name = input.nextLine();
        System.out.println("Hello " + name);
	System.out.print("How old are you? ");
	int age = input.nextInt();
	System.out.println(name+" is "+ age + " year old.");
    }
}
