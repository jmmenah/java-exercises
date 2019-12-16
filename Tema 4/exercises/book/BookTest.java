public class BookTest{
	public static void main(String[] args) {
		Book[] books= new Book[7];
		books[0]=new Book();
		books[1]=new Book("978-0133900699","The Java Language Specification","James Gosling",792);
		books[2]=new Book("Don Quixote","Miguel de Cervantes");
		books[3]=new Book("The C Programming Language","Brian W. Kernighan - Dennis M. Ritchie");
		books[4]=new Book("The Life of Lazarillo de Tormes and of His Fortunes and Adversities");
		books[5]=new Book("978-0142437230","Don Quixote","Miguel de Cervantes",0);
		books[6]=new Book("unknown","Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin",464);

		System.out.println();
		System.out.println("Calling showBooks");
		showBooks(books);
		System.out.println();

		System.out.println("Calling showBooks2");
		showBooks2(books);
		System.out.println();

		System.out.println("Calling showDuplicates");
		showDuplicates(books);
		System.out.println();
	}

	public static void showBooks(Book[] books){	
		for(int i=0;i<books.length;i++){
			System.out.println("Book #"+(i+1)+" : "+books[i]);
		}
	}

	public static void showBooks2(Book[] books){
		int i=0;	
		for (Book book : books){
			System.out.println("Book #"+(i+1)+" : "+book);
			i++;
		}
	}

	public static void showDuplicates(Book[] books){
		for(int i=0;i<books.length-1;i++){
			for(int j=i+1;j<books.length;j++){
				if(books[i].equals(books[j])){
					System.out.println("Book #"+(i+1)+" equals to Book #"+(j+1));
				}
			}
		}		
	}
	

}
