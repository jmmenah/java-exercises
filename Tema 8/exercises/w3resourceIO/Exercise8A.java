// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write Java program to read input from java console.

// 3 Ways to read input from console in Java
// 1.Using Buffered Reader Class
// https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/

//package w3resourceIO;

//Java program to demonstrate BufferedReader 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise8A {
	public static void main(String[] args) throws IOException {
		System.out.println("Input your line: ");

		// Enter data using BufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		String line = reader.readLine();

		// Printing the read line
		System.out.println("You entered:\n" + line);
	}
}
