// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to find the longest word in a text file.

//package w3resourceIO;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise18B {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		@SuppressWarnings("unused")
		File file = checkFileName(fileName);

		try {
			String text = new String(Files.readAllBytes(Paths.get(fileName)));

			String[] words = text.replace("\n", " ").split(" ");
			String longest = "";

			int maxLength = 0;

			for (String word : words) {
				int currentLength = word.length();
				if (currentLength > maxLength) {
					maxLength = currentLength;
					longest = word;
				}

			}
			System.out.printf("Longest word in %s is: %s%n", fileName, longest);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static File checkFileName(String name) {
		File f = new File(name);

		if (!f.exists()) {
			System.out.print("The file \"" + name + "\" does not exist.\n");
			System.exit(1);
		}

		if (!f.isFile()) {
			System.out.print("\"" + name + "\" is not a file.\n");
			System.exit(2);
		}
		return f;
	}
}
