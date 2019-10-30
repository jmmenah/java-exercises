// ch05-program-logic-indefinite-loops.ppt (slide 8)
// Improving version: user must type a integer

import java.util.Scanner;

public class FencePostPrintPrimes2 {

	private static Scanner console;

	public static void main(String[] args) {
		System.out.println("Prints all prime numbers up to the given max");
		
		int n = getMax();

		printPrimes(n);
		
		console.close();
	}

	// Get an integer from console
    public static int getMax() {
    	console = new Scanner(System.in);
		System.out.print("Enter max number: ");
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("Not an integer. Please try again.");
    		System.out.print("\nEnter max number: ");
        }
        return console.nextInt();
    }
    
	// Prints all prime numbers up to the given max.
	public static void printPrimes(int max) {
	    if (max >= 2) {
	        System.out.print("2");
	        for (int i = 3; i <= max; i++) {
	            if (countFactors(i) == 2) {
	                System.out.print(", " + i);
	            }
	        }
	        System.out.println();
	    }
	}

	// Returns how many factors the given number has.
	public static int countFactors(int number) {
	    int count = 0;
	    for (int i = 1; i <= number; i++) {
	        if (number % i == 0) {
	            count++;   // i is a factor of number
	        }
	    }
	    return count;
	}
}
