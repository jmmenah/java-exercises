// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write Java program to read input from java console.

// 3 Ways to read input from console in Java
// 2. Using Scanner Class
// https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/

//package w3resourceIO;

//Java program to demonstrate working of Scanner in Java 

import java.io.IOException;
import java.util.Scanner;

public class Exercise8B {
	public static void main(String[] args) throws IOException {
	    
		System.out.println("Input your line: ");
	    
		// Using Scanner for Getting Input from User
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		in.close();
		
		System.out.println("You entered:\n" + s);
	}
}
