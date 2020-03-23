// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get specific files by extensions
// from a specified folder.

//package w3resourceIO;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise2B {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a path: ");
		String textPath = input.nextLine();

		Path path = Paths.get(textPath);

		if (!isValidPath(path)) {
			System.out.println(path + " is not a valid path!");
			System.exit(1);
		}

		System.out.print("Enter a extension: ");
		String extension = "." + input.nextLine();

		input.close();
		try {
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, "*" + extension);
			int count = 0;

			for (Path p : directoryStream) {
				System.out.println(p.getFileName());
				count++;
			}
			if (count == 0) {
				System.out.printf("No files with \"%s\" extension in %s%n", extension, path);
			}
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean isValidPath(Path p) {
		return Files.exists(p) && Files.isDirectory(p);
	}
}
