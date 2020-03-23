// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

//  Write a Java program to store text file content line by line into an array.

// solution using Scanner 
// https://www.baeldung.com/java-file-to-arraylist

//package w3resourceIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise14A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		ArrayList<String> lines = new ArrayList<>();

		try (Scanner sc = new Scanner(new FileReader(fileName))) {
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " does not exist.");
		}

	}

}
