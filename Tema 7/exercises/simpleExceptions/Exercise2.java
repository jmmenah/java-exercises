import java.util.Scanner;
import java.util.InputMismatchException;

public class Exercise2 {

	public static void main(String args[]) {

		int a[] = new int[10];
		// Array has only 10 elements
		for (int i = 0; i < 10; i++)
			a[i] = (i + 1) * 10;
		Scanner input = new Scanner(System.in);
		System.out.print("Please, enter an array position: ");

		int pos = input.nextInt();
		try{
			System.out.println(a[pos]);
		}
		catch(ArrayIndexOutOfBoundsException ob){
			System.out.println("There are less elements in the array");//This exception occurs when you put a number higher than the legth of the array
		}
		catch(InputMismatchException notInt){
			System.out.println("Is not an int"); //This exception is used when the person is using the program insert a string,char or double.
		}
		finally{
			input.close();
		}
	}

}
