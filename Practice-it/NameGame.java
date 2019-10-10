// CSE 142, Autumn 2010, Jessica Miller
// This program uses various String methods to sing the name game.
import java.util.*;

public class NameGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("What is your name? ");
		String name = input.nextLine();
		
		int firstSpace = name.indexOf(" ");
		String firstName = name.substring(0, firstSpace);
		String lastName = name.substring(firstSpace + 1);	
		
		singSong(firstName);
		System.out.println();
		singSong(lastName);
	}
	
	public static void singSong(String name) {
		String suffix = name.substring(1);
		System.out.println(name + ", " + name + ", bo-b" + suffix);
		System.out.println("Banana-fana fo-f" + suffix);
		System.out.println("Fee-fi-fo-m" + suffix);
		System.out.println(name.toUpperCase() + "!");
	}
}
/*
public static class TheNameGame {
    public static void main(String[] args) {
        System.out.print("What is your name? ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        String surname = input.next();
        String newName = name.substring(1);
        String newSurname = surname.substring(1);
        song(name,newName);
        song(surname,newSurname);
    }
}        
public static void song (String one, String two) {
    System.out.println(one + " " + one + ", " + "bo-B" + two);
    System.out.println("Banana-fana fo-F" + two);
    System.out.println("Fee-fi-mo-M" + two);
    System.out.println(one.toUpperCase() + "!");
}
*/