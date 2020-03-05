/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.List;


// Looping using enhanced for loop

public class Test2 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Goat");
        animals.add("Cow");

        //print using enhanced for loop
        for (String animal : animals) {
            System.out.println("Name: " + animal);
        }

    }
}