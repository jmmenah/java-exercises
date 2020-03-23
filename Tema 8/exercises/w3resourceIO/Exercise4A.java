// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to check if a file or directory 
// has read and write permission.

//package w3resourceIO;

import java.io.File;
import java.util.Scanner;

public class Exercise4A {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String path = input.nextLine();
		input.close();

		File f = new File(path);

		System.out.print(f.getAbsolutePath());

		if (f.canWrite()) {
			System.out.println("\ncan write.");
		} else {
			System.out.println("\ncannot write.");
		}

		if (f.canRead()) {
			System.out.println("\ncan read.");
		} else {
			System.out.println("\ncannot read.");
		}
	}
}
