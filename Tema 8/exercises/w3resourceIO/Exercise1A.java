// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get a list 
// of all file/directory names from the given.

//package w3resourceIO;

import java.io.File;
import java.util.Scanner;

public class Exercise1A {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a path: ");
		String path = input.nextLine();
		input.close();
		
		try {
			File file = new File(path);
			if (file.exists()) {
				if (file.isFile()) {
					System.out.println(path + " is a file, Not a directory!");
				} else {

					System.out.println("Listing : " + path);
					String[] fileList = file.list();
					for (String name : fileList) {
						System.out.println(name);
					}
				}
			} else {
				System.out.println(path + " is not valid.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
