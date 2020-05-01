import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PairMountains {

    public static void main(String[] args) {
        List<Pair<String, Integer>> mountains = new ArrayList<>();

        addMountains(mountains);

        serializeMountains(mountains);

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
                // return o1.getFirst().compareTo(o2.getFirst());
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
        mountains.forEach(m -> System.out.printf("%s (%s)%n", m.first, m.second));

        System.out.println();

        mountains.forEach(System.out::println);
    }

    // Complete
    public static void addMountains(List<Pair<String, Integer>> mList) {
        mList.add("Aneto",3404);
        mList.add("Teide", 3718);
        mList.add("Veleta", 3396);
        mList.add("Mulhacén", 3479);
        mList.add("Pandera", 1872);
        mList.add("Almadén", 2036);
    }

    private static void serializeMountains(List<Pair<String, Integer>> mList) {
        try {
            // for writing or saving binary data
            FileOutputStream fos = new FileOutputStream("SaveArrayList.ser");

            // converting java-object to binary-format
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // writing or saving ArrayList values to stream
            oos.writeObject(mountains);
            oos.flush();
            oos.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

}
