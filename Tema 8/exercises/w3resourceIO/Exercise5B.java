// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to check if given pathname 
// is a directory or a file.

//package w3resourceIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise5B {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String textPath = input.nextLine();
		input.close();

		Path path = Paths.get(textPath);

		System.out.print(path.toAbsolutePath());

		System.out.println();

		if (Files.isDirectory(path)) {
			System.out.println(" is a directory.\n");
		} else if (Files.isRegularFile(path)) {
			System.out.println(" is a file.\n");
		} else {
			System.out.println(" It is neither a directory nor a file.\n");
		}
	}
}
