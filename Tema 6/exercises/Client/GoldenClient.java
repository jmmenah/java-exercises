public class GoldenClient extends Client {
	private char goldenLevel;

	public GoldenClient(int id, String firstName, String lastName, double amount){
		super(id, firstName, lastName, amount);
		setGoldenLevel();
	}

	public void setGoldenLevel(){
		if (getAmount()>10000){
			goldenLevel='H';
		}
		else if (getAmount()>5000 && getAmount()<10000){
			goldenLevel='M';
		}
		else{
			goldenLevel='L';
		}
	}
	public void addMoney(int money){
		super.addMoney(money);
		setGoldenLevel();
	}

	public void subMoney(int money){
		super.subMoney(money);
		setGoldenLevel();
	}

	public char getGoldenLevel(){
		return goldenLevel;
	}

	public String toString(){
		return super.toString()+"\nGolden Level: "+goldenLevel;
	}
}