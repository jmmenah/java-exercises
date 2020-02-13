public class DeliveryPizza extends Pizza{
	private double deliveryFee;
	private String deliveryAddress;

	public DeliveryPizza(double price, String description,String deliveryAddress){
		super(price,description);
		this.deliveryAddress=deliveryAddress;
		deliveryFee= getPrice() > 15 ? 3 : 5;
	}

	public String toString(){
		return  super.toString() + " The delivery fee is " + deliveryFee +"€ and the delivery address is "+deliveryAddress+".Total = "+(price+deliveryFee)+"€";
	}
}