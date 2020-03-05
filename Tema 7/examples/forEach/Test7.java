/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// Limitations of forEach()
// 1. Cannot use to Filter elements in a collection
/*
To remove an element from a list, we need to call remove() on the iterator object.
Since forEach() hides the iterator, we cannot use it.
Look at the below example to recall how to remove an element using iterator remove() method.
 */
public class Test7 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Goat");
        animals.add("Cow");

        System.out.println("Before Remove: " + animals);

        Iterator<String> animalIterator = animals.iterator();

        while (animalIterator.hasNext()) {
            String animal = animalIterator.next();
            if ("Cow".equals(animal)) {
                animalIterator.remove();
            }
        }

        System.out.println("After Remove: " + animals);
    }
}