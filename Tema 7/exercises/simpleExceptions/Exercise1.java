import java.util.Scanner;
import java.util.InputMismatchException;

public class Exercise1 {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		try{
			System.out.print("Please, enter an integer number: ");
			int num1 = input.nextInt();
			System.out.print("Please, enter another integer number: ");
			int num2 = input.nextInt();
			int output = num1 / num2;
			System.out.println("Result: " + output);
		}
		catch(ArithmeticException notZero){
			System.out.println("Argument 'divisor' is 0"); //This exception is used when the second number is 0 and you can't divide by zero
		}
		catch(InputMismatchException notInt){
			System.out.println("Is not an int"); //This exception is used when the person is using the program insert a string,char or double.
		}
		finally{
			input.close();
		}
	}
}
