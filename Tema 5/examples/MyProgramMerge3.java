import java.util.Arrays;

public class MyProgramMerge3 {

	public static void main(String[] args) {
		int[] a1 = { 12, 34, 56 };
		int[] a2 = { 7, 8, 9, 10 };
		int[] a3 = { 444, 222, -1 };
		System.out.println("a1 = " + Arrays.toString(a1));
		System.out.println("a2 = " + Arrays.toString(a2));
		System.out.println("a3 = " + Arrays.toString(a3));

		int[] a4 = merge3(a1, a2, a3);
		System.out.println("a4 = " + Arrays.toString(a4));
		// [12, 34, 56, 7, 8, 9, 10, 444, 222, -1]
	}

	// Returns a new array containing all elements of a1,a2,a3.
	public static int[] merge3(int[] a1, int[] a2, int[] a3) {
		int[] a4 = new int[a1.length + a2.length + a3.length];

		for (int i = 0; i < a1.length; i++) {
			a4[i] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			a4[a1.length + i] = a2[i];
		}
		for (int i = 0; i < a3.length; i++) {
			a4[a1.length + a2.length + i] = a3[i];
		}

		return a4;
	}

	// Shorter version that calls merge.
	/*
	 * public static int[] merge3(int[] a1, int[] a2, int[] a3) { return
	 * merge(merge(a1, a2), a3); }
	 */
}
