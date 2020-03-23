// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to read first 3 lines from a file.

// solution using LineNumberReader

//package w3resourceIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Exercise17C {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		File file = checkFileName(fileName);

		LineNumberReader reader;
		try {
			reader = new LineNumberReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null && reader.getLineNumber() <= 3) {
				System.out.println(line);
				line = reader.readLine();
			}

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
