// Java Input-Output Exercises
// https://www.w3resource.com/java-exercises/io/index.php

// Write a Java program to get file size in Bytes, kB, MB.

// https://github.com/RameshMF/java-io-guide/wiki/How-to-get-File-Size-in-Bytes-KB-MB-GB-TB

//package w3resourceIO;

import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;

/**
 * This Java program demonstrates how to get file size in bytes, kilobytes, mega
 * bytes, GB,TB.
 * 
 * @author javaguides.net
 */

public class Exercise9B {
	/**
	 * Given the size of a file outputs as human readable size using SI prefix.
	 * <i>Base 1024</i>
	 * 
	 * @param size Size in bytes of a given File.
	 * @return SI String representing the file size (B,KB,MB,GB,TB).
	 */
	public static String readableFileSize(long size) {
		if (size <= 0) {
			return "0";
		}
		final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
		int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
		return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.nextLine();
		input.close();

		File file = new File(fileName);
		String size = readableFileSize(file.length());
		System.out.println(size);
	}
}
