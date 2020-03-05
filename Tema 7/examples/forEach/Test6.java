/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.List;


// Limitations of forEach()
// 1. Cannot use to Filter elements in a collection
/*
For example, if we try to remove an element from a list in its forEach() call, we will get a ConcurrentModificationException.
This is because we are trying to change the same list that we are traversing.
 */
public class Test6 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Goat");
        animals.add("Cow");

        //print using forEach with Lambda
        animals.forEach(animal -> {
            if ("Cow".equals(animal)) {
                animals.remove(animal); //Runtime Error: java.util.ConcurrentModificationException
            }
        });
    }
}