// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

//  Write a java program to read a file line by line and store it into a variable.

// solution using readAllBytes 
// https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

//package w3resourceIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise13C {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		try {
			String text = new String(Files.readAllBytes(Paths.get(fileName)));
			System.out.println(text);

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
