import java.util.Arrays;

public class MyProgramSwap {

	public static void main(String[] args) {
		int[] a1 = {12, 34, 56};
		System.out.println("a1 = " + Arrays.toString(a1));
		swap(a1, 1, 2);
		System.out.println("Call: swap(a1, 1, 2)");
		System.out.println("a1 = " + Arrays.toString(a1));  // [12, 56, 34]
	}
	// Swaps the values at the given two indexes.
	public static void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
}
