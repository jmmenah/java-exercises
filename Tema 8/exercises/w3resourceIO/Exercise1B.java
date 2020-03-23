// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get a list 
// of all file/directory names from the given.

//package w3resourceIO;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise1B {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a path: ");
		String textPath = input.nextLine();
		input.close();
		
		Path path = Paths.get(textPath);

		try {
			if (Files.exists(path)) {
				if (Files.isRegularFile(path)) {
					System.out.println(path + " is a file, Not a directory!");
				} else {
					System.out.println("Listing : " + path);

					DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);

					for (Path p : directoryStream) {
						System.out.println(p);
					}
				}
			} else {
				System.out.println(path + " is not valid.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
