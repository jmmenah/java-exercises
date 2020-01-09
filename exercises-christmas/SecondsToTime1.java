// Convert seconds to hours, minutes and seconds
// Read number of seconds from command line

// Use HH:MM:SS format

import java.util.Scanner;

public class SecondsToTime1 {
    public static void main(String[] args) {

	if (args.length != 1) {
            System.out.println("Please, use: java SecondsToTime1 <numberOfSeconds>\n");
        }
        else {
	    int seconds = Integer.parseInt(args[0]);  // Read number of seconds 

	    int hours = seconds / 3600;  // number of hours

	    seconds %= 3600;

	    int minutes = seconds / 60;  // number of minutes

	    seconds %= 60;	// number of seconds (0-59)

            System.out.printf("HH:MM:SS - %02d:%02d:%02d%n", hours, minutes, seconds);
        }  
    }
}
