import java.util.Arrays;

public class MyProgramMerge {

	public static void main(String[] args) {
		int[] a1 = { 12, 34, 56 };
		int[] a2 = { 7, 8, 9, 10 };
		System.out.println("a1 = " + Arrays.toString(a1));
		System.out.println("a2 = " + Arrays.toString(a2));

		int[] a3 = merge(a1, a2);
		System.out.println("a3 = " + Arrays.toString(a3));
		// [12, 34, 56, 7, 8, 9, 10]
	}

	// Returns a new array containing all elements of a1
	// followed by all elements of a2.
	public static int[] merge(int[] a1, int[] a2) {
		int[] result = new int[a1.length + a2.length];

		for (int i = 0; i < a1.length; i++) {
			result[i] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			result[a1.length + i] = a2[i];
		}

		return result;
	}
}
