import java.util.ArrayList;
import java.util.List;

public class UseBook{

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();

		books.add(new Fiction("Los Pilares de la Tierra"));
		books.add(new NonFiction("Cronica de un suceso"));

		for(Book book : books){
			System.out.println(book);
		}

	}
}