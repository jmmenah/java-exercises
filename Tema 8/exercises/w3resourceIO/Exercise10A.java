// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to read contents from a file into byte array.

// Java read file to byte[] array
// https://howtodoinjava.com/java/io/how-to-read-file-content-into-byte-array-in-java/

// Convert byte[] array to File using Java
// https://www.geeksforgeeks.org/convert-byte-array-to-file-using-java/

//package w3resourceIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Exercise10A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		File file = new File(fileName);

		if (!file.exists()) {
			System.out.print("The file \"" + fileName + "\" does not exist.\n");
			System.exit(1);
		}

		if (!file.isFile()) {
			System.out.print("\"" + fileName + "\" is not a file.\n");
			System.exit(2);
		}

		byte[] byteArray = readContentIntoByteArray(file);

		// Copy byte[] array to a File
		writeByteArrayToFile(byteArray);
	}

	// Read file to byte[] array with FileInputStream [till Java 6]
	private static byte[] readContentIntoByteArray(File file) {
		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];
		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			for (int i = 0; i < bFile.length; i++) {
				System.out.print((char) bFile[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
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
