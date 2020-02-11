// Driver class: uses Book.class

public class BookTest {
	public static void main(String[] args) {
		// Create array of Book objects
		Book[] books = new Book[7];

		// Initialize array of Book using constructors
		books[0] = new Book(); // no-arg constructor

		// using parameterized constructors
		books[1] = new Book("978-0133900699", "The Java Language Specification", "James Gosling", 792);

		books[2] = new Book("Don Quixote", "Miguel de Cervantes");

		books[3] = new Book("The C Programming Language", "Brian W. Kernighan - Dennis M. Ritchie");
		
		books[4] = new Book("The Life of Lazarillo de Tormes and of His Fortunes and Adversities");

		books[5] = new Book("Don Quixote", "Miguel de Cervantes");
		books[5].setIsbn("978-0142437230");

		books[6] = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin");
		books[6].setNumberOfPages(464);
		
		System.out.println("\nCalling showBooks");
		showBooks(books);
		
		System.out.println("\nCalling showBooks2");
		showBooks2(books);
		
		System.out.println("\nCalling showDuplicates");
		showDuplicates(books);

	} // end main

	// using for loop
	public static void showBooks(Book[] book) {
		for (int i = 0; i < book.length; i++) {
			System.out.print("Book #" + (i + 1) + ": ");
			System.out.println(book[i]);
		}
	} // end showBooks

	// using for-each loop
	public static void showBooks2(Book[] book) {
		int i = 0;
		for (Book b : book) {
			System.out.print("Book #" + (i + 1) + ": ");
			System.out.println(b);
			i++;
		}
	} // end showBooks2

	public static void showDuplicates(Book[] book) {
		// using brute force method
		// nested loop
		for (int i = 0; i < book.length - 1; i++) {
			// System.out.print("\nComparing " + i + ": ");
			for (int j = i + 1; j < book.length; j++) {
				// System.out.print(" " + j);

				if (book[i].equals(book[j])) {
					System.out.print(" Book #" + (i + 1) + " equals to Book #" + (j + 1));
					// System.out.print(" book[" + i + "] equals to book[" + j + "]");
				}
			} // inner loop
		} // outer loop
	} // end showDuplicates
} // end BookTest
