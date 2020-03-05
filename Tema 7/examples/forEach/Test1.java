/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// Example of looping using Iterator

public class Test1 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Goat");
        animals.add("Cow");

        //print using iterator
        Iterator<String> animalIterator = animals.iterator();
        while (animalIterator.hasNext()) {
            System.out.println("Name: " + animalIterator.next());
        }


    }
}