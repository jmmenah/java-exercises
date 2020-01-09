// Checking whether an integer entered from command line is a perfect square.
// If it is a perfect square prints a square of asterisks
/*
"In mathematics, a square number or perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 9 is a square number, since it can be written as 3 × 3" (Wikipedia: Square number)
https://en.wikipedia.org/wiki/Square_number
*/


public class PerfectSquare2 {
    public static void main(String[] args) {

	if (args.length != 1) {
            System.out.println("Please, use: java PerfectSquare2 n");
            System.out.println("\twhere n is a positive integer\n");
        }
        else {  
            int n = Integer.parseInt(args[0]);
            if (n < 0) System.out.println("\tSquare numbers are non-negative\n");
            else {
                int sqrt = (int) Math.sqrt(n);
                if(sqrt*sqrt == n) {
                    System.out.printf("%d is a Perfect Square.%n\t%d x %d = %d\n", n, sqrt, sqrt, n);
                    if (sqrt <= 20) printSquare(sqrt);
                } 
                else System.out.println(n + " is NOT a Perfect Square.");
            }
        }

    }

    public static void printSquare(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print("* ");
            }  
            System.out.println();
        } 
    }

}
