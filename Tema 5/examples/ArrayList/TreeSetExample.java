// Java program to demonstrate working TreeSet collection 
// https://www.geeksforgeeks.org/treeset-in-java/

import java.util.Iterator; 
import java.util.TreeSet; 

public class TreeSetExample 
{ 
	public static void main(String[] args) 
	{ 
		TreeSet<Integer> ts = new TreeSet<Integer>(); 
		ts.add(10); 
		ts.add(61); 
		ts.add(87); 
		ts.add(39); 

		Iterator<Integer> iterator = ts.iterator(); 
		System.out.print("Tree set data: "); 

		// note that 87 being largest element, appears in 
		// the last. 
		while (iterator.hasNext()) 
			System.out.print(iterator.next() + " "); 
		System.out.println(); 

		// to check if treeset is empty or not. 
		if (ts.isEmpty()) 
			System.out.print("Tree Set is empty."); 
		else
			System.out.println("Tree Set size: " + ts.size()); 

		// To get the smallest element from the set 
		System.out.println("First data: " + ts.first()); 

		// To get the largest value from set 
		System.out.println("Last data: " + ts.last()); 

		// remove 61 from set. 
		if (ts.remove(61)) 
			System.out.println("Data is removed from tree set"); 
		else
			System.out.println("Data doesn't exist!"); 

		System.out.print("Now the tree set contain: "); 
		iterator = ts.iterator(); 

		// Displaying the Tree set data 
		while (iterator.hasNext()) 
			System.out.print(iterator.next() + " "); 

		System.out.println(); 
		System.out.println("Now the size of tree set: " + 
						ts.size()); 

		// Remove all 
		ts.clear(); 
		if (ts.isEmpty()) 
			System.out.println("Tree Set is empty."); 
		else
			System.out.println("Tree Set size: " + ts.size()); 
	} 
} 

