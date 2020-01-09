// Prints perfect square numbers between two given numbers from command line
/*
"In mathematics, a square number or perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 9 is a square number, since it can be written as 3 × 3" (Wikipedia: Square number)
https://en.wikipedia.org/wiki/Square_number
*/

public class PerfectSquare3 {
    public static void main(String[] args) {

	if (args.length != 2) {
            System.out.println("Please, use: java PerfectSquare3 start end");
            System.out.println("\twhere start and end are positive integers\n");
        }
        else {  
            int start = Integer.parseInt(args[0]);
            int end = Integer.parseInt(args[1]);       
            if (start < 0 || end < 0) System.out.println("\tSquare numbers are non-negative\n");
            else if (start > end) System.out.println("\t\"Start\" must be less than \"end\"\n");
                 else printPerfectSquare(start, end);
        }

    }

    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt*sqrt == n;
    } 
    
    public static void printPerfectSquare(int start, int end) {
        System.out.printf("Perfect Square Numbers between %d and %d\n", start, end);
        int j = 0;
        for (int i = start; i <= end; i++) {
            if (isPerfectSquare(i)) {
                System.out.print("\t" + i);
                if (++j%5 == 0) System.out.println();    
            }
        }
        System.out.println("\nTotal of perfect squares: " + j); 
    }

}
