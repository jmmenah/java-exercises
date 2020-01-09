// Convert seconds to hours, minutes and seconds
// Read number of seconds from user input

// Use HH:MM:SS format

import java.util.Scanner;

public class SecondsToTime2 {
    public static void main(String[] args) {
        // create object of Scanner class
	Scanner console = new Scanner(System.in);

	System.out.print("Enter number of seconds: ");
	int seconds = console.nextInt();  // Read number of seconds 

	int hours = seconds / 3600;  // number of hours

	seconds %= 3600;

	int minutes = seconds / 60;  // number of minutes

	seconds %= 60;	// number of seconds (0-59)

        System.out.printf("HH:MM:SS - %02d:%02d:%02d%n", hours, minutes, seconds);
    }  
}
