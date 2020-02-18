//  Building Java Programs: A Back to Basics Approach, 4th edition by Stuart Reges and Marty Stepp
//  http://www.buildingjavaprograms.com/code-files/4ed/
//  chapter 4

public class Factorial {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++)
            System.out.println(i + "! = " + factorial(i));
        System.out.println(factorial(-1));
    }

    public static int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("negative n");
        int product = 1;
        for (int i = 2; i <= n; i++)
            product *= i;
        return product;
    }
}

