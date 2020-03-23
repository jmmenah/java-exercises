// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to check if a file or directory 
// specified by pathname exists or not.

//package w3resourceIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



import java.util.Scanner;

public class Exercise3B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String textPath = input.nextLine();
		input.close();
		
		Path path = Paths.get(textPath);

		System.out.print("The directory or file \"" + path +"\" ");
		if (Files.exists(path)) {
			System.out.println("exists.\n");
		} else {
			System.out.println("does not exist.\n");
		}
	}
}
