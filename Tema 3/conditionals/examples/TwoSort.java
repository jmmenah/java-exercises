// Example of if statement use : 2-sort
// Reads two integers from the command line, then prints them out in numerical order.

public class TwoSort
{
    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        if (b < a)
        {
            int t = a;  // alternatives for if and else
            a = b;      // can be a sequence of
            b = t;      // statements, enclosed in braces
        }
        System.out.println(a);
        System.out.println(b);
    }
}
