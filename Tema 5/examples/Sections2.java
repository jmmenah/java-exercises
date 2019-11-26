
// This program reads a file representing which students attended
// which discussion sections and produces output of the students'
// section attendance and scores.

import java.io.*;
import java.util.*;

public class Sections2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("sections.txt"));
		int section = 1;
		while (input.hasNextLine()) {
			// process one section
			String line = input.nextLine();
			int[] points = countPoints(line);
			double[] grades = computeGrades(points);
			results(section, points, grades);
			section++;
		}
	}

	// Produces all output about a particular section.
	public static void results(int section, int[] points, double[] grades) {
		System.out.println("Section " + section);
		System.out.println("Student scores: " + Arrays.toString(points));
		System.out.println("Student grades: " + Arrays.toString(grades));
		System.out.println();
	}

	// Computes the points earned for each student for a particular section.
	public static int[] countPoints(String line) {
		int[] points = new int[5];
		for (int i = 0; i < line.length(); i++) {
			int student = i % 5;
			int earned = 0;
			if (line.charAt(i) == 'y') { // c == 'y' or c == 'n'
				earned = 3;
			} else if (line.charAt(i) == 'n') {
				earned = 2;
			}
			points[student] = Math.min(20, points[student] + earned);
		}
		return points;
	}

	// Computes the percentage for each student for a particular section.
	public static double[] computeGrades(int[] points) {
		double[] grades = new double[5];
		for (int i = 0; i < points.length; i++) {
			grades[i] = 100.0 * points[i] / 20.0;
		}
		return grades;
	}
}