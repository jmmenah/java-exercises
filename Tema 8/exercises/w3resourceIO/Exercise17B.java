// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to read first 3 lines from a file.

// solution using Files.lines and lambda
// https://codereview.stackexchange.com/questions/79024/get-the-first-10-lines-of-a-file
//  Reading a text file using Stream in Java 8
// https://javarevisited.blogspot.com/2016/07/10-examples-to-read-text-file-in-java.html#ixzz5mWhJ3mea

//package w3resourceIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise17B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		@SuppressWarnings("unused")
		File file = checkFileName(fileName);

		try {
			Files.lines(Paths.get(fileName)).limit(3).forEach(System.out::println);
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
