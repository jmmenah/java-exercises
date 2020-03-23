// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to check if a file or directory 
// has read and write permission.

//package w3resourceIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class Exercise4B {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String textPath = input.nextLine();
		input.close();

		Path path = Paths.get(textPath);

		System.out.print(path.toAbsolutePath());

		if (Files.isWritable(path) ) {
			System.out.println("\ncan write.");
		} else {
			System.out.println("\ncannot write.");
		}

		if (Files.isReadable(path)) {
			System.out.println("\ncan read.");
		} else {
			System.out.println("\ncannot read.");
		}
	}
}
