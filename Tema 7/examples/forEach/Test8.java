/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.List;


// Limitations of forEach()
// 2. Cannot use to replace elements
/*
Similar to removing elements, replacing elements in a list is also not possible with forEach().
Since we most definitely need the index position to replace a specific element in a list with another element.

The below example shows how we can replace an element using a regular for loop. Note that we cannot use enhanced for loop as well for this.
 */
public class Test8 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Goat");
        animals.add("Cow");

        System.out.println("Before Replace: " + animals);

        for (int i = 0; i < animals.size(); i++) {
            if ("Cow".equals(animals.get(i))) {
                animals.remove(i);
                animals.add(i, "Goose");
            }
        }

        System.out.println("After Replace: " + animals);
    }
}
