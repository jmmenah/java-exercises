public class Client{
	private int id;
	private String firstName;
	private String lastName;
	private double amount;


	public Client(int id, String firstName, String lastName, double amount) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.amount=amount;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id=id;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(){
		this.lastName=lastName;
	}

	public double getAmount(){
		return amount;
	}

	public void setAmount(double amount){
		this.amount=amount;
	}

	public void addMoney(double money){
		amount=amount+money;
	}

	public void subMoney(double money){
		amount=amount-money;
	}

	public String toString(){
		return "ID: "+id +"\n Name: "+firstName+" "+lastName+"\nAmount: "+amount;
	}
}