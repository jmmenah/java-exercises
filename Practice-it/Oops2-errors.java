The following program contains 9 errors. Correct the errors and submit a working version of the program. The corrected version of the program should produce the following output:

x is 0
x is now 15
x and y are 15 and 16

// FIND ERRORS
public class Oops2 {
    public static void main(String[] args) {
        int x;
        System.out.println("x is " x);

        int x = 15.2;   // set x to 15.2
        System.out.println("x is now + x");

        int y;   // set y to 1 more than x
        y = int x + 1;
        System.out.println("x and y are " + x + and + y);
    }
}

// Solution
public class Oops2 {
    public static void main(String[] args) {
        int x = 0;
        System.out.println("x is " + x);

        x = 15;   // set x to 15
        System.out.println("x is now " + x);

        int y = 0;   // set y to 1 more than x
        y = x + 1;
        System.out.println("x and y are " + x + " and " + y);
    }
}