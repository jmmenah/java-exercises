import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PairTest {

	public static void main(String[] args) {
		ArrayList<Pair<String, Integer>> mountains = new ArrayList<Pair<String, Integer>>();

		mountains.add(new Pair<>("Aneto", 3404));
		mountains.add(new Pair<>("Teide", 3718));
		mountains.add(new Pair<>("Veleta", 3396));
		mountains.add(new Pair<>("Mulhacén", 3479));
		
        // for-each loop
		for (Pair<String, Integer> m : mountains) {
			System.out.println(m);
		}

		System.out.println();

		for (Pair<String, Integer> m : mountains) {
			System.out.printf("%s = %d meters%n", m.getFirst(), m.getSecond());
		}

		// Sorting
		// https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
		Collections.sort(mountains, new Comparator<Pair<String, Integer>>() {
			@Override
			public int compare(final Pair<String, Integer> o1, final Pair<String, Integer> o2) {
				return o2.getSecond() - o1.getSecond(); // order by Integer (meters)

				// alphabetical order
				//return o1.getFirst().compareTo(o2.getFirst()); 
			}
		});

		System.out.println();
        // for loop
		for (int i = 0; i < mountains.size(); i++) {
			System.out.printf("%d.- %-9s= %d meters%n", i + 1, mountains.get(i).getFirst(),
					mountains.get(i).getSecond());
		}
		System.out.println();

		// looping using forEach() with lambda expression
		mountains.forEach(m -> System.out.printf("%s (%s)%n", m.first, m.second ));
		
		System.out.println();

		mountains.forEach(System.out::println);

	}
}
