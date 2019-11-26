public class MostFrequentDigit {

	public static void main(String[] args) {
		int n = 669260267;
		System.out.println("n = " + n);
		System.out.print("Most frequent digit is: ");
		System.out.println(mostFrequentDigit(n));

	}

	// Returns the digit value that occurs most frequently in n.
	// Breaks ties by choosing the smaller value.
	public static int mostFrequentDigit(int n) {
		int[] counts = new int[10];
		while (n > 0) {
			int digit = n % 10; // pluck off a digit and tally it
			counts[digit]++;
			n = n / 10;
		}

		// find the most frequently occurring digit
		int bestIndex = 0;
		for (int i = 1; i < counts.length; i++) {
			if (counts[i] > counts[bestIndex]) {
				bestIndex = i;
			}
		}

		return bestIndex;
	}
}
