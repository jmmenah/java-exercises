// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to write and read a plain text file. 

// solution using java.nio.file.Files with readAllLines method
// and Files.write
// https://www.baeldung.com/java-write-to-file

//package w3resourceIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class Exercise15C {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		Path pathInput = checkFileName(fileName);

	    Path pathOutput = Paths.get("output.txt");
	 
	    try {
			Files.write(pathOutput, Files.readAllBytes(pathInput));
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
