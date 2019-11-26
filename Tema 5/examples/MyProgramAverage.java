public class MyProgramAverage {

	public static void main(String[] args) {
		// figure out the average TA IQ
        int[] iq = {126, 84, 149, 167, 95};
        double avg = average(iq);
        System.out.println("Average IQ = " + avg);
	}

	// Returns the average of the given array of numbers.
	public static double average(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return (double) sum / numbers.length;
	}
}
