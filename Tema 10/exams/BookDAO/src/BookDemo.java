import java.io.*;
import java.util.List;

public class BookDemo {

	private static BookDAO bookDAO = new BookDAOImpl();


	private static void printList(List<Book> list) {
		System.out.println("List of "+list.size()+"books:");
		for (Book book : list) {
			System.out.println(book);
		}
	}

	private static void loadBooksFromCSV() {

		try (BufferedReader csvReader = new BufferedReader(new FileReader("data/myBooks.csv"))) {
			String row;

			while ((row = csvReader.readLine()) != null) {
				Book book = new Book();
				String[] data = row.split(";", -1);
				book.setIsbn(Long.parseLong(data[0]));
				book.setTitle(data[1]);
				book.setAuthor(data[2]);
				book.setYear(Integer.parseInt(data[3]));
				bookDAO.insertBook(book);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private static void loadBooksFromSerialize() {
			List<Book> l = null;
			String fileName="data/books19th.ser";

			try (FileInputStream fileIn = new FileInputStream(fileName);
			 ObjectInputStream in = new ObjectInputStream(fileIn)
			){
				l = (List<Book>) in.readObject();
			} catch (FileNotFoundException i) {
				i.printStackTrace();
			} catch (IOException i) {
				i.printStackTrace();
			} catch (ClassNotFoundException c) {
				System.out.println("Book class not found");
				c.printStackTrace();
			}

		for (int i = 0; i < l.size(); i++) {
			bookDAO.insertBook(l.get(i));
		}
	}

	// It is NOT necessary to change this main method
	public static void main(String[] args) {

		loadBooksFromCSV();  // 16 books from myBooks.csv

		loadBooksFromSerialize();  // 8 books from books19th.ser

		System.out.println(bookDAO.getBook(9780439554930L).getTitle()); // Harry Potter and the Philosopher's Stone

		Book b = bookDAO.getBook("Misery");
		
		System.out.println(b.getAuthor()); // Stephen King

		bookDAO.updateBook(new Book(9780142437230L, "Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", 1605));

		System.out.println(bookDAO.deleteBook(b.getIsbn())); // true
		
		int deleted = bookDAO.deleteBooks("Dan Brown");  // 3

		System.out.println(deleted + " books deleted"); // 3 books deleted

		printList(bookDAO.getAllBooks());  // 20 books

	}
}
