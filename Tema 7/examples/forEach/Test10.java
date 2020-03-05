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
Although, forEach() can most effectively be used to form nested loops.

Consider a class Library that contains the name, location and list of books.
We need a nested loop to print both the library names and the book names.
*/

class Library {
    String name;
    String location;
    List<String> books;

    public Library(String name, String location, List<String> books) {
        this.name = name;
        this.location = location;
        this.books = books;
    }
}

public class Test10 {
    public static void main(String[] args) {
        List<String> books1 = new ArrayList<String>();
        books1.add("Talking to the moon");
        books1.add("A walk to remember");
        books1.add("Da Vinci code");

        List<String> books2 = new ArrayList<String>();
        books2.add("Harry Potter");
        books2.add("Bloodline");
        books2.add("Da Vinci code");

        List<Library> libraries = new ArrayList<Library>();
        libraries.add(new Library("West Coast Library", "West Coast", books1));
        libraries.add(new Library("City Center Library", "East Coast", books2));

        libraries.forEach(library -> {
            library.books.forEach(book -> {
                System.out.println("Library Name: " + library.name + ", Book Name: " + book);
            });
        }); 
    }
}
