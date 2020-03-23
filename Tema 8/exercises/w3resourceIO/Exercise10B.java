// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to read contents from a file into byte array.

// Java read file to byte[] array
// https://howtodoinjava.com/java/io/how-to-read-file-content-into-byte-array-in-java/

// Convert byte[] array to File using Java
// https://www.geeksforgeeks.org/convert-byte-array-to-file-using-java/

//package w3resourceIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise10B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		Path path = Paths.get(fileName);

		if (!Files.exists(path)) {
			System.out.print("The file \"" + fileName + "\" does not exist.\n");
			System.exit(1);
		}

		if (!Files.isRegularFile(path)) {
			System.out.print("\"" + fileName + "\" is not a file.\n");
			System.exit(2);
		}

		byte[] byteArray;
		try {
			// Read file to byte[] array with NIO [Java 7 and later] with readAllBytes
			// method
			byteArray = Files.readAllBytes(path);

			outputByteArray(byteArray);

			// Copy byte[] array to a File
			writeByteArrayToFile(byteArray);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Output byte[] array to console
	private static void outputByteArray(byte[] bytes) throws IOException {
		// Raw data
		System.out.println(Arrays.toString(bytes));
		// characters
		System.out.write(bytes);
		/*
		for (int i = 0; i < bytes.length; i++) {
			System.out.print((char) bytes[i]);
		}
		*/
	}

	// Method which write the bytes into a file
	static void writeByteArrayToFile(byte[] bytes) {
		try {

			// Initialize a pointer
			// in file using OutputStream
			OutputStream os = new FileOutputStream("myBackupFile.bk");

			// Starts writing the bytes in it
			os.write(bytes);
			System.out.println("\n Successfully bytes inserted. myBackupFile.bk created");

			// Close the file
			os.close();
		}

		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
