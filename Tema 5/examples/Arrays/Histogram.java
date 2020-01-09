// Reads a file of test scores and shows a histogram of score distribution.

import java.io.*;
import java.util.*;

public class Histogram {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("midterm.txt"));
		int[] counts = new int[101]; // counters of test scores 0 - 100

		while (input.hasNextInt()) { // read file into counts array
			int score = input.nextInt();
			counts[score]++; // if score is 87, then counts[87]++
		}

		for (int i = 0; i < counts.length; i++) { // print star histogram
			if (counts[i] > 0) {
				System.out.print(i + ": ");
				for (int j = 0; j < counts[i]; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}