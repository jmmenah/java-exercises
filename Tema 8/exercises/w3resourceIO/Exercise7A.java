// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get last modified time of a file.

//package w3resourceIO;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Exercise7A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String path = input.nextLine();
		input.close();

		File file = new File(path);
		if (file.exists()) {
			Date date = new Date(file.lastModified());

			System.out.println("\nThe file or directory was last modified on: " + date + "\n");
		} else {
			System.out.printf("\nThe file or directory \"%s\" Not exists %n", path);
		}
	}
}
