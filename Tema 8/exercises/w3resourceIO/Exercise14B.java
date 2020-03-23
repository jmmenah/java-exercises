// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

//  Write a Java program to store text file content line by line into an array.

// solution using Files.readAllLines
// https://www.baeldung.com/java-file-to-arraylist

//package w3resourceIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Exercise14B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName));
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
