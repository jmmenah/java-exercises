// Book class
// See BookTest.java

public class Book {

	// Fields - State
	private String isbn;
	private String title;
	private String author;
	private int numberOfPages;

	// no-arg constructor
	public Book() {
		isbn = "unknown";
		title = "unknown";
		author = "unknown";
		numberOfPages = 0;
	}

	// parameterized constructors
	// Constructor overloading and Constructor Chaining
	public Book(String isbn, String title, String author, int numberOfPages) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.numberOfPages = numberOfPages;
	}
	
	public Book(String title) {
		this();
		this.title = title;
	}
	
	public Book(String title, String author) {
		this("unknown", title, author, 0);
	}

	// Methods - Behaviour

	// toString method
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", numberOfPages=" + numberOfPages
				+ "]";
	}
	// compares the current book object with other Book object 
	// returns true if both objects have the same title and author
	public boolean equals(Book other) {
		return  other.getAuthor().equals(author) && other.getTitle().equals(title) ;
	}

	// setters and getters
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
} // end Book
