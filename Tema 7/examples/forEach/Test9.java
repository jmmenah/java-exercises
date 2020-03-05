/*
forEach() method in Java 8 with examples
Published by Cindhu Vinayagamoorthy on September 11, 2018
https://thejavacult.com/foreach-method-java-8-examples/
*/

import java.util.ArrayList;
import java.util.List;


// Limitations of forEach()
// 3. Can use with nested loops but not parallel loops
/*
Consider two lists. One contains odd numbers and the other contains even numbers.
To iterate through both lists in parallel, we must use a regular for loop as shown in the example below.
*/

public class Test9 {
    public static void main(String[] args) {
        List<String> oddList = new ArrayList<>();
        oddList.add("one");
        oddList.add("three");

        List<String> evenList = new ArrayList<>();
        evenList.add("two");
        evenList.add("four");

        for (int i = 0; i < oddList.size() && i < evenList.size(); i++) {
            System.out.println("Number from odd list: " + oddList.get(i));
            System.out.println("Number from Even list: " + evenList.get(i));
        }

    }
}
