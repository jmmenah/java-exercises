// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to read first 3 lines from a file.

// solution using Scanner

//package w3resourceIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise17A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();
		
		File file = checkFileName(fileName);
		
		try (Scanner sc = new Scanner(file)) {
			int lines = 0;
			while (sc.hasNextLine() && lines < 3 ) {
				System.out.println(sc.nextLine());
				lines++;
			}
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
