// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get specific files by extensions
// from a specified folder.

//package w3resourceIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Exercise2A {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a path: ");
		String path = input.nextLine();
		
		if (!isValidPath (path)) {
			System.out.println(path + " is not a valid path!");
			System.exit(1);
		}
			
		
		System.out.print("Enter a extension: ");
		String extension = "." + input.nextLine();

		input.close();
		try {
			File file = new File(path);
			
			String[] list = file.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(extension);
				}
			});
			if (list.length == 0) {
				System.out.printf("No files with \"%s\" extension in %s%n", extension, path);
			} else {
				for (String f : list) {
					System.out.println(f);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean isValidPath(String p) {
		File f = new File(p);
		return f.exists() && f.isDirectory();
	}
}
