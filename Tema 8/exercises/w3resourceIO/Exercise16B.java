// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to append text to an existing file. 

// solution using Files.write StandardOpenOption.APPEND
// https://www.baeldung.com/java-append-to-file
// https://www.programiz.com/java-programming/examples/append-text-existing-file

//package w3resourceIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Exercise16B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();

		@SuppressWarnings("unused")
		File file = checkFileName(fileName);

		System.out.print("Enter text to add: ");
		String addingText = System.lineSeparator() + input.nextLine();

		input.close();

		try {
			Files.write(Paths.get(fileName), addingText.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
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
