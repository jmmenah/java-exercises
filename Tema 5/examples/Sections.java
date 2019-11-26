import java.io.*;
import java.util.*;

public class Sections {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("sections.txt"));
		int section = 1;
		while (input.hasNextLine()) {
			String line = input.nextLine(); // process one section
			int[] points = new int[5];
			for (int i = 0; i < line.length(); i++) {
				int student = i % 5;
				int earned = 0;
				if (line.charAt(i) == 'y') { // c == 'y' or 'n' or 'a'
					earned = 3;
				} else if (line.charAt(i) == 'n') {
					earned = 2;
				}
				points[student] = Math.min(20, points[student] + earned);
			}

			double[] grades = new double[5];
			for (int i = 0; i < points.length; i++) {
				grades[i] = 100.0 * points[i] / 20.0;
			}

			System.out.println("Section " + section);
			System.out.println("Student points: " + Arrays.toString(points));
			System.out.println("Student grades: " + Arrays.toString(grades));
			System.out.println();
			section++;
		}
	}
}