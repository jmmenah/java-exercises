import java.util.List;

public interface BookDAO {

    public List<Book> getAllBooks();

    public Book getBook(long isbn);

    public Book getBook(String title);

    public boolean insertBook(Book book);

    public boolean updateBook(Book book);

    public boolean deleteBook(long isbn);

    public int deleteBooks(String author);

}
