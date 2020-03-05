/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.List;


// Looping using forEach with Method References

public class Test4 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Goat");
        animals.add("Cow");

        // In the case at hand, the Lambda body only had a system.out.println statement. Therefore, it can be replaced with the following:
        // animals.forEach(animal -> System.out.println("Name: " + animal));

        //print using forEach with Method Reference
        animals.forEach(System.out::println);

    }
}