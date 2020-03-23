// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to check if given pathname 
// is a directory or a file.

//package w3resourceIO;

import java.io.File;
import java.util.Scanner;

public class Exercise5A {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String path = input.nextLine();
		input.close();

		File f = new File(path);

		System.out.print(f.getAbsolutePath());

		if (f.isDirectory()) {
			System.out.println(" is a directory.\n");
		} else if (f.isFile()) {
			System.out.println(" is a file.\n");
		} else {
			System.out.println(" It is neither a directory nor a file.\n");
		}
	}
}
