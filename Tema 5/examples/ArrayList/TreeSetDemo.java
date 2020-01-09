// Java program to demonstrate insertions in TreeSet 
// https://www.geeksforgeeks.org/treeset-in-java-with-examples/
import java.util.*; 

class TreeSetDemo { 
	public static void main(String[] args) 
	{ 
		TreeSet<String> ts1 = new TreeSet<String>(); 

		// Elements are added using add() method 
		
		ts1.add("B");
		ts1.add("C");
		ts1.add("A");   

		// Duplicates will not get insert 
		ts1.add("C"); 

		// Elements get stored in default natural 
		// Sorting Order(Ascending) 
		System.out.println(ts1); 
	} 
} 

