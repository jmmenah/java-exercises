
// Driver class: uses EasyCalculator.class

import java.util.InputMismatchException;
import java.util.Scanner;

public class EasyCalculatorTest {

    static double op1, op2;

    public static void main(String[] args) {

        getOperands();

        // Create an object using parameterized constructor
        EasyCalculator calc = new EasyCalculator(op1, op2);

        // Calling toString method
        System.out.println(calc);

        // Calling static method
        showOperations(calc);

    } // end main

    // Static methods belongs to EasyCalculatorTest class
    public static void showOperations(EasyCalculator c) {
        System.out.print("\nFirst operand: " + c.getOperand1());
        System.out.println(" , Second operand: " + c.getOperand2());
        System.out.println("Addition = " + c.addition());
        System.out.println("Subtraction = " + c.subtraction());
        System.out.println("Multiplication = " + c.multiplication());
        System.out.println("Division = " + c.division());
    } // end showOperations

    public static void getOperands() {
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Please enter two operands: ");
                op1 = input.nextDouble();
                op2 = input.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                input.nextLine(); // discard input so user can try again
                System.out.printf("%nYou must enter 2 numeric operands. Please try again.%n%n");
            }
        } // end while
        input.close();
    } // end getOperands
} // end EasyCalculatorTest
