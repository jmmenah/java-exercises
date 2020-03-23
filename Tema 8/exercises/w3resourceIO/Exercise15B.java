// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to write and read a plain text file. 

// solution using BufferedReader and BufferedWriter
// https://www.baeldung.com/java-write-to-file

//package w3resourceIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise15B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		@SuppressWarnings("unused")
		File file = checkFileName(fileName);

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		    		     
			while (line != null) {
				//System.out.println(line);	
			    writer.write(line + System.lineSeparator());
				line = reader.readLine();  // read next line
			}
			reader.close();
		    writer.close();

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
