// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to read a file content line by line.

// solution using java.nio.file.Files with readAllLines method

//package w3resourceIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.util.Scanner;

public class Exercise11B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		Path path = checkFileName(fileName);

		try {
			List<String> lines = Files.readAllLines(path);
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Path checkFileName(String name) {
		Path p = Paths.get(name);

		if (!Files.exists(p)) {
			System.out.print("The file \"" + name + "\" does not exist.\n");
			System.exit(1);
		}

		if (!Files.isRegularFile(p)) {
			System.out.print("\"" + name + "\" is not a file.\n");
			System.exit(2);
		}
		return p;
	}
}
