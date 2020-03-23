// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to write and read a plain text file. 

// solution using Scanner and PrintStream

//package w3resourceIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;

public class Exercise15A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a inpunt file name: ");
		String fileName = input.nextLine();
		input.close();

		File file = checkFileName(fileName);

		try {
			PrintStream output = new PrintStream(new File("output.txt"));

			try (Scanner sc = new Scanner(file)) {
				while (sc.hasNextLine()) {
					output.println(sc.nextLine());
				}
				System.out.println("file output.txt created");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
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
