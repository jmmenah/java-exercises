/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Set
/*
The use of forEach() with Set is exactly the same as that of List.
Check out the below example that shows the different ways a Set can be iterated.
 */

public class Test11 {
    public static void main(String[] args) {
        Set<String> employees = new HashSet<String>();
        employees.add("Tom");
        employees.add("Luke");
        employees.add("Gabriel");
        employees.add("Kathy");

        // print using iterator
        System.out.println("Looping using iterator...");
        Iterator<String> employeeIterator = employees.iterator();
        while (employeeIterator.hasNext()) {
            System.out.println(employeeIterator.next());
        }
        System.out.println();

        // print using enhanced for loop
        System.out.println("Looping using enhanced for loop...");
        for (String employee : employees) {
            System.out.println(employee);
        }
        System.out.println();

        // print using forEach with Lambda
        System.out.println("Looping using forEach with Lambda...");
        employees.forEach(employee -> System.out.println(employee));
        System.out.println();

        // print using forEach with Method Reference
        System.out.println("Looping using forEach with Method References...");
        employees.forEach(System.out::println);

    }
}