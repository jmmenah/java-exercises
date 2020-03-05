/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// Map
/*
For most parts, the forEach() method in Map interface is similar to the forEach() method in Iterable Interface.
The only difference is that the forEach() in Map takes an implementation of BiConsumer Interface instead of a Consumer Interface.
That means it takes two variables – key and value.
 */

public class Test12 {
    public static void main(String[] args) {
        Map<Integer, String> days = new HashMap<Integer, String>();
        days.put(1, "Monday");
        days.put(2, "Tuesday");
        days.put(3, "Wednesday");
        days.put(4, "Thursday");
        days.put(5, "Friday");
        days.put(6, "Saturday");
        days.put(7, "Sunday");

        // print using Iterator
        System.out.println("Looping using iterator...");
        Iterator<Entry<Integer, String>> daysIterator = days.entrySet()
                .iterator();
        while (daysIterator.hasNext()) {
            Entry<Integer, String> entry = daysIterator.next();
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println();

        // print using enhanced for loop
        System.out.println("Looping using enhanced for loop...");
        for (Entry<Integer, String> entry : days.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println();

        // print using forEach with Lambda
        System.out.println("Looping using forEach with Lambda...");
        days.forEach((key, value) -> System.out.println(key + ". " + value));
        System.out.println();

        System.out.println("Looping using forEach with Method Reference...");
        days.forEach(Test12::printMap);

    }

    public static void printMap(Integer key, String value) {
        System.out.println(key + ". " + value);
    }

}