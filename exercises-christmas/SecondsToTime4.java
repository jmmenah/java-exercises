// Convert seconds to hours, minutes and seconds
// Read number of seconds from user input

// Use HH:MM:SS format

import java.util.Scanner;

public class SecondsToTime4 {
    public static void main(String[] args) {

        // create object of Scanner class
	Scanner console = new Scanner(System.in);

        int secs;  // input seconds

        int seconds, hours, minutes;
    
        System.out.print("\nEnter number of seconds: ");
        secs = console.nextInt();  // Read number of seconds 

        while (secs != 0) {
            
            hours = secs / 3600;  // number of hours

	    seconds = secs % 3600;

	    minutes = seconds / 60;  // number of minutes

	    seconds %= 60;	// number of seconds (0-59)

            System.out.printf("HH:MM:SS - %02d:%02d:%02d%n", hours, minutes, seconds);

	    System.out.print("\nEnter number of seconds: ");
	    secs = console.nextInt();  // Read number of seconds 
        }

        System.out.println("Goodbye!");   
    }
}

