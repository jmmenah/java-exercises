
// Driver class: uses Rectangle.class

import java.util.Scanner;

public class RectangleTest1 {

    public static void main(String[] args) {
        // Create a Rectangle object using the no-arg constructor
        Rectangle rect1 = new Rectangle();

        // First rectangle
        System.out.println("First " + rect1); // call toString method

        // Call a static method
        showRectangle(rect1);

        // input width and length to create a new rectangle object
        Scanner input = new Scanner(System.in);

        // width and length in main are local variables
        // and they are different from instance variables
        System.out.print("\nEnter rectangle width: ");
        int width = input.nextInt();

        System.out.print("Enter rectangle length: ");
        int length = input.nextInt();

        try {
            // Create a Rectangle object with a parameterized constructor
            Rectangle rect2 = new Rectangle(length, width);

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

} // end RectangleTest
