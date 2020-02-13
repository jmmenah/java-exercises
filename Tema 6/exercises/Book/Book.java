public abstract class Book {
	private String title;
	protected double price;

	public Book(String title){
		this.title=title;
	}

	public String getTitle(){
		return title;
	}

	public double getPrice(){
		return price;
	}

	abstract void setPrice();

	public String toString(){
		return "The book is "+title+" and costs "+price+"€.";
	}
}