/*
 Write a method called printPowersOfN that accepts a base and an exponent as arguments and prints each power of the base from base0 (1) up to that maximum power, inclusive. For example, consider the following calls:

printPowersOfN(4, 3);

printPowersOfN(5, 6);

printPowersOfN(-2, 8);

These calls should produce the following output:

1 4 16 64
1 5 25 125 625 3125 15625
1 -2 4 -8 16 -32 64 -128 256

You may assume that the exponent passed to printPowersOfN has a value of 0 or greater. (The Math class may help you with this problem. If you use it, you may need to cast its results from double to int so that you don't see a .0 after each number in your output. Also, can you write this program without using the Math class?) 
*/
public static void printPowersOfN(int base, int exponent) {
    int currentNum = 1;
    System.out.print(currentNum + " ");
    
    for (int i = 1; i <= exponent; i++) {
        currentNum *= base;
        System.out.print(currentNum + " ");
    }
    
    System.out.println();
}
