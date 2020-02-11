// Java LocalDate class is introduced in Java 8 in the java.time package
// https://beginnersbook.com/2017/10/java-localdate/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FriendsAgenda {
	
	// static for use it in all methods without having to pass a parameter
	static ArrayList<Friend> friendsList = new ArrayList<Friend>();

	// a single shared Scanner object for keyboard input
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
		loadFriends(); 	// load friends into friendList from csv

		int option;

		do {
			menu(); 
			option = Integer.parseInt(console.nextLine());

			switch (option) {
			case 0:
				System.out.println("Thanks for using Friends Agenda!");
				break;
			case 1:
				showFriends();
				break;
			case 2:
				addFriend();
				break;
			case 3:
				removeFriend();
				break;
			case 4:
				clearFriends();
				break;
			default:
				System.out.println("Error: Not a valid option.");
			}
		} while (option != 0);

		console.close();
	}

	public static void menu() {
		System.out.println("\nFriends Agenda");
		System.out.println("==============");
		System.out.println("1. List all friends");
		System.out.println("2. Add friend");
		System.out.println("3. Remove friend");
		System.out.println("4. Clear all List");
		System.out.println("0. Exit");
		System.out.print("\nSelect option: ");
	}

	public static void loadFriends() throws FileNotFoundException {

		Scanner input = new Scanner(FriendsAgenda.class.getResourceAsStream("friends.csv"));

		// int i = 1;

		while (input.hasNext()) {
			String line = input.nextLine();
			//System.out.println(i++ + ": " + line);
			String[] data = line.split(", ");
            // csv file: firstName, lastName, phone, birthday
			// birthday format: dd-MM-yyyy
			Friend f = new Friend(data[0], data[1], data[2], stringToLocalDate(data[3]));
			friendsList.add(f);
		}
		input.close();
	}

	public static void showFriends() {
		if (friendsList.isEmpty()) {
			System.out.println("Friends Agenda is empty");
		} else {
			for (int i = 0; i < friendsList.size(); i++) {
				Friend f = friendsList.get(i);
				System.out.printf("%d - %s%n", i + 1, f);
			}
		}
	}

	public static void addFriend() {
		System.out.println("\nAdding a new Friend");
		System.out.print("Please, type First Name: ");
		String firstName = console.nextLine();
		System.out.print("Last Name: ");
		String lastName = console.nextLine();
		System.out.print("Phone number: ");
		String phone = console.nextLine();
		System.out.print("Birthday (dd/MM/yyyy): ");
		String str = console.nextLine();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate birthday = LocalDate.parse(str, dt);

		friendsList.add(new Friend(firstName, lastName, phone, birthday));

		System.out.println("");
	}

	public static void removeFriend() {
		System.out.print("\nType number to remove friend: ");
		int n = Integer.parseInt(console.nextLine());

		if (n <= 0 || n > friendsList.size()) {
			System.out.printf("Error: %d is not a valid friend number%n", n);
		} else {
			n--; // fixing number, list starts with 0  
			String friend = friendsList.get(n).getFirstName() + " " + friendsList.get(n).getLastName();
			System.out.printf("Removing %s.%nAre you sure? (y/n): ", friend);
			String sure = console.nextLine();
			if (sure.equalsIgnoreCase("y")) {
				friendsList.remove(n);
				System.out.printf("%s removed :-(%n", friend);
			} else {
				System.out.println("Giving her/him another chance :-)");
			}
		}
	}

	public static void clearFriends() {
		System.out.println("\nClearing all Friends!!!");
		System.out.print("Are you sure? (y/n): ");
		String sure = console.nextLine();
		if (sure.equalsIgnoreCase("y")) {
			friendsList.clear();
			System.out.println("All friends removed :-(");
		} else {
			System.out.println("Close friends are truly life's treasures");
		}
	}

	// s must have the format dd-MM-yyyy
	public static LocalDate stringToLocalDate(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(s, formatter);

		return date;
	}
}
