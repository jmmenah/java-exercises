// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get file size in Bytes, kB, MB.

//package w3resourceIO;

import java.io.File;
import java.util.Scanner;

public class Exercise9A {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		File file = new File(fileName);
		if (file.exists() && file.isFile()) {
			double bytes = file.length();
			System.out.println(bytes + " Bytes");
			bytes /= 1024;
			System.out.println(bytes + " KB");
			bytes /= 1024;
			System.out.println(bytes + " MB");
		} else {
			System.out.println("File doesn't exist");
		}
	}
}
