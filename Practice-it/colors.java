import java.until.Scanner;
Scanner console = new Scanner(System.in);
System.out.print("What color do you want? ");
String choice = console.nextLine();
if (choice.equalsIgnoreCase("r")) {
    System.out.println("You have chosen Red.");
} else if (choice.equalsIgnoreCase("g")) {
    System.out.println("You have chosen Green.");
} else if (choice.equalsIgnoreCase("b")) {
    System.out.println("You have chosen Blue.");
} else {
    System.out.println("Unknown color: " + choice);
}
