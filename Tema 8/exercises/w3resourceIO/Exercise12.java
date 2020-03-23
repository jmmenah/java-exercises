// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

//  Write a Java program to read a plain text file.

// solution using FileReader 
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

//package w3resourceIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercise12 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		try {
			FileReader fr = new FileReader(fileName);
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
			fr.close();
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
