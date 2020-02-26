/*
 Introduction to Java Programming, Tenth Edition
 Y. Daniel Liang
 http://www.cs.armstrong.edu/liang/intro10e/

 (Geometry: area of a triangle) Write a program that prompts the user to enter
 three points (x1, y1), (x2, y2), (x3, y3) of a triangle and displays its area.

input:
Enter three points for a triangle: 1.5 -3.4 4.6 5 9.5 -3.4

output:
The area of the triangle is 33.600000000000016


http://soultionmanual.blogspot.com/2016/06/chapter-2-exercise-19-introduction-to.html

https://github.com/jsquared21/Intro-to-Java-Programming/blob/master/Exercise_02/Exercise_02_19/Exercise_02_19.java
*/

import java.util.Locale;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        // Secure decimal point with locale
        Locale.setDefault(new Locale("en", "US"));
        Scanner input = new Scanner(System.in);
        // Scanner input = new Scanner(System.in).useLocale(Locale.US);

        // Prompt the user to enter three points
        System.out.print("Enter three points for a triangle: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        input.close();
        // Compute the area of a triangle
        double side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        // Display result
        System.out.println("The area of the triangle is " + area);
    }
}