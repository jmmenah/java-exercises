// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write Java program to read input from java console.

// 3 Ways to read input from console in Java
// 3. Using Console Class
// https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/

// Does not work in non-interactive environment (such as in an IDE).

//package w3resourceIO;

//Java program to demonstrate working of System.console() 
//Note that this program does not work on IDEs as  
//System.console() may require console 

public class Exercise8C {
	public static void main(String[] args) {
		
		System.out.println("Input your line: ");

		// Using Console to input data from user
		String line = System.console().readLine();

		System.out.println("You entered:\n" + line);
	}
}
