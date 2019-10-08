import java.util.Scanner;

public class Magic {
	public static void main(String[] args) {
	//int myNumber = 7;
	Scanner input = new Scanner(System.in);
	System.out.print("Write an integer number : ");
	int myNumber = input.nextInt();
	int stepOne = myNumber * myNumber;
	int stepTwo = stepOne + myNumber;
	int stepThree = stepTwo / myNumber;
	int stepFour = stepThree + 17;
	int stepFive = stepFour - myNumber;
	int stepSix = stepFive / 6;
	System.out.println("Your magic number is "+ stepSix);
	}
}

	

	
