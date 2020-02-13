public class Pizza {
	protected double price;
	protected String description;

	public Pizza(double price, String description){
		this.price=price;
		this.description=description;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price=price;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(){
		this.description=description;
	}

	public String toString(){
		return "The pizza has "+description+" and costs "+price+"€.";
	}
}