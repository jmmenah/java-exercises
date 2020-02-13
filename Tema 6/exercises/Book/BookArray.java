import java.util.ArrayList;
import java.util.List;

public class BookArray{

	public static void main(String[] args) {
		Book[] books = new Book[10];

		books[0] = new Fiction("Los Pilares de la Tierra");
		books[1] = new Fiction("La hermandad de la Sabana Santa");
		books[2] = new Fiction("La caida de los Gigantes");
		books[3] = new Fiction("El invierno del Mundo");
		books[4] = new Fiction("El Umbral de la Eternidad");
		books[5] = new NonFiction("Cronica de un suceso");
		books[6] = new NonFiction("Historia de España");
		books[7] = new NonFiction("Historia del siglo XX");
		books[8] = new NonFiction("El diario de Ana Frank");
		books[9] = new NonFiction("El arte de la guerra");

		for(Book book : books){
			System.out.println(book);
		}

	}
}