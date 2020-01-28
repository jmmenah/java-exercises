// Java LocalDate class is introduced in Java 8 in the java.time package
// https://beginnersbook.com/2017/10/java-localdate/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SongsList {
	
	// static for use it in all methods without having to pass a parameter
	static ArrayList<Song> songsList = new ArrayList<Song>();

	// a single shared Scanner object for keyboard input
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
		loadSongs(); 	// load songs into songList from csv

		int option;

		do {
			menu(); 
			option = Integer.parseInt(console.nextLine());

			switch (option) {
			case 0:
				System.out.println("Thanks for using Songs List!");
				break;
			case 1:
				showSongs();
				break;
			case 2:
				addSong();
				break;
			case 3:
				removeSong();
				break;
			case 4:
				clearSongs();
				break;
			default:
				System.out.println("Error: Not a valid option.");
			}
		} while (option != 0);

		console.close();
	}

	public static void menu() {
		System.out.println("\nSongs List");
		System.out.println("==============");
		System.out.println("1. List all songs");
		System.out.println("2. Add song");
		System.out.println("3. Remove song");
		System.out.println("4. Clear all List");
		System.out.println("0. Exit");
		System.out.print("\nSelect option: ");
	}

	public static void loadSongs() throws FileNotFoundException {

		Scanner input = new Scanner(new File("songs.csv"));

		// int i = 1;

		while (input.hasNext()) {
			String line = input.nextLine();
			//System.out.println(i++ + ": " + line);
			String[] data = line.split(", ");
            // csv file: songTitle, artist, gender, date
			// date format: dd-MM-yyyy
			Song s = new Song(data[0], data[1], data[2].charAt(0), stringToLocalDate(data[3]));
			songsList.add(s);
		}
		input.close();
	}

	public static void showSongs() {
		if (songsList.isEmpty()) {
			System.out.println("Songs List is empty");
		} else {
			for (int i = 0; i < songsList.size(); i++) {
				Song s = songsList.get(i);
				System.out.printf("%d - %s%n", i + 1, s);
			}
		}
	}

	public static void addSong() {
		System.out.println("\nAdding a new Song");
		System.out.print("Please, type Song Title: ");
		String songTitle = console.nextLine();
		System.out.print("Artist: ");
		String artist = console.nextLine();
		System.out.print("Gender (M/F): ");
		char gender = console.nextLine().charAt(0);
		System.out.print("Date (dd/MM/yyyy): ");
		String str = console.nextLine();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(str, dt);

		songsList.add(new Song(songTitle, artist, gender, date));

		System.out.println("");
	}

	public static void removeSong() {
		System.out.print("\nType number to remove song: ");
		int n = Integer.parseInt(console.nextLine());

		if (n <= 0 || n > songsList.size()) {
			System.out.printf("Error: %d is not a valid song number%n", n);
		} else {
			n--; // fixing number, list starts with 0  
			String song = songsList.get(n).getSongTitle() + " - " + songsList.get(n).getArtist();
			System.out.printf("Removing %s.%nAre you sure? (y/n): ", song);
			String sure = console.nextLine();
			if (sure.equalsIgnoreCase("y")) {
				songsList.remove(n);
				System.out.printf("%s removed :-(%n", song);
			} else {
				System.out.println("Giving song another chance :-)");
			}
		}
	}

	public static void clearSongs() {
		System.out.println("\nClearing all Songs!!!");
		System.out.print("Are you sure? (y/n): ");
		String sure = console.nextLine();
		if (sure.equalsIgnoreCase("y")) {
			songsList.clear();
			System.out.println("All songs removed :-(");
		} else {
			System.out.println("Good songs are truly life's treasures");
		}
	}

	// s must have the format dd-MM-yyyy
	public static LocalDate stringToLocalDate(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(s, formatter);

		return date;
	}
}
