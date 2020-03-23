// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to find the longest word in a text file.

//package w3resourceIO;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Exercise18A {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		File file = checkFileName(fileName);

		try (Scanner sc = new Scanner(file)) {
			String word = "";
			String longest = "";
			while (sc.hasNext()) {
				word = sc.next();
				if (word.length() > longest.length())
					longest = word;
			}
			System.out.printf("Longest word in %s is: %s%n", fileName, longest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
