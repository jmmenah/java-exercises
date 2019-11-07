public class Bill{
	public static void main(String[]args){
		double value = Double.parseDouble(args[0]);
		int iva = Integer.parseInt(args[1]);
		double totalValue = value + (value*iva/100);
		System.out.println("Bill = " + value +"€ + " + iva +"% IVA = " + totalValue + "€" );
	}
}