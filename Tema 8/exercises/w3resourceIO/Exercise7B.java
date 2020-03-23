// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get last modified time of a file.

//package w3resourceIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

public class Exercise7B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String textPath = input.nextLine();
		input.close();

		Path path = Paths.get(textPath);

		try {
			FileTime date = Files.getLastModifiedTime(path);
			System.out.println("\nThe file or directory was last modified on: " + date + "\n");
		} catch (IOException e) {
			System.out.printf("\nThe file or directory \"%s\" Not exists %n", path);
		}
	}
}
