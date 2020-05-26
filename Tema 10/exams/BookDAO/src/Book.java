import java.io.Serializable;

/* See library.sql */
public class Book implements Serializable {
	// CAUTION: Do not modify next line
	private static final long serialVersionUID = 1L;

	private long isbn;
	private String title;
	private String author;
	private  int year;

	public Book(){

	}

	public Book(long isbn,String title,String author, int year){
		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setYear(year);

	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", year=" + year + "]";
	}


}