/*
2.- Write a program Bill.java that takes two integer command-line arguments (money and iva) and prints the bill identical as shown below. (4 points)

Examples of execution:

$ java Bill 100 21
Bill = 100€ + 21% IVA = 121.0€

$ java Bill 100 10
Bill = 100€ + 10% IVA = 110.0€

$ java Bill 123 4
Bill = 123€ + 4% IVA = 127.92€

$ java Bill 896 21
Bill = 896€ + 21% IVA = 1084.16€
*/
public class Bill{
	public static void main(String[]args){
		double value = Double.parseDouble(args[0]);//int value = Integer.parseInt(args[0]);
		int iva = Integer.parseInt(args[1]);
		double totalValue = value + (value*iva/100); //double totalValue = (double)value + (value*iva/100);
		System.out.println("Bill = " + value +"€ + " + iva +"% IVA = " + totalValue + "€" );
	}
}
