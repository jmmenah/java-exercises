// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to check if a file or directory 
// specified by pathname exists or not.

//package w3resourceIO;

import java.io.File;
import java.util.Scanner;

public class Exercise3A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file or directory: ");
		String path = input.nextLine();
		input.close();
		
		File file = new File(path);
		System.out.print("The directory or file \"" + path +"\" ");
		if (file.exists()) {
			System.out.println("exists.\n");
		} else {
			System.out.println("does not exist.\n");
		}
	}
}
