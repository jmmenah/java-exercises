/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;

// Looping using forEach() with Lambda

public class Test3 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Goat");
        animals.add("Cow");

        // Implement the Consumer Interface using Lambda Expressions.
        Consumer<String> consumerImplObject = animal->System.out.println("Name: "+animal);
        // calling the forEach() method on the animals list and passing the Consumer implementation.
        animals.forEach(consumerImplObject);

        System.out.println();

        //print using forEach with Lambda in one step
        animals.forEach(animal -> System.out.println("Name: " + animal));

    }
}