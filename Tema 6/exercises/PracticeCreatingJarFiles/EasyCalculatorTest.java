// Driver class: uses EasyCalculator.class

import java.util.Scanner;

public class EasyCalculatorTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double op1, op2;
		System.out.print("Please enter two operands: ");
		op1 = input.nextDouble();
		op2 = input.nextDouble();

		// Create an object using parameterized constructor
		EasyCalculator calc = new EasyCalculator(op1, op2);

		// Calling toString method 
		System.out.println(calc);

		// Calling static method
		showOperations(calc);

		input.close();
	} // end main
	
	// Static method belongs to EasyCalculatorTest class
	public static void showOperations (EasyCalculator c) {
		System.out.print("\nFirst operand: " + c.getOperand1());
		System.out.println(" , Second operand: " + c.getOperand2());
		System.out.println("Addition = " + c.addition());
		System.out.println("Subtraction = " + c.subtraction());
		System.out.println("Multiplication = " + c.multiplication());
		System.out.println("Division = " + c.division());
	} // end showOperations
	
} // end EasyCalculatorTest
