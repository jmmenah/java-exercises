
// Driver class: uses Rectangle.class

import java.util.Scanner;
import java.util.InputMismatchException;

public class RectangleTest5 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a Rectangle object using the no-arg constructor
        Rectangle rect1 = new Rectangle();

        // First rectangle
        System.out.println("First " + rect1); // call toString method

        // Call a static method
        showRectangle(rect1);

        try {
            // input width and length to create a new rectangle object

            // width and length in main are local variables
            // and they are different from instance variables

            // Create a Rectangle object with a parameterized constructor
            Rectangle rect2 = new Rectangle(getInput("length"), getInput("width"));

            // Call a static method
            showRectangle(rect2);

            // Checking if the rectangle is a Square
            // using a call to a instance method isSquare
            if (rect2.isSquare()) {
                System.out.println(rect2 + " is a square."); // call toString method
            } else {
                System.out.println(rect2 + " is not a square."); // call toString method
            }
        } catch (IllegalArgumentException e) {
            System.out.printf("\nException while initialising rect2: %s\n", e.getMessage());
        }
        input.close(); // close scanner object
    } // end main

    // Static method belongs to RectangleTest class
    public static void showRectangle(Rectangle r) {
        System.out.println("Area: " + r.area());
        System.out.println("Perimeter: " + r.perimeter());
    } // end showRectangle

    public static int getInput(String side) {
        while (true) {
            try {
                System.out.printf("%nEnter rectangle %s: ", side);
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine(); // discard input so user can try again
                System.out.printf("You must enter integers. Please try again.%n");
            }
        } // end while
    } // end getInput

} // end RectangleTest
