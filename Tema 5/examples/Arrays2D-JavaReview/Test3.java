// Two-dimensional Arrays - Use a For-Each to Loop Through an Array
// https://interactivepython.org/runestone/static/JavaReview/Array2dBasics/a2dLoop.html#use-a-for-each-to-loop-through-an-array

public class Test3
{

   public static double getAvg(int[][] a)
   {
      double total = 0;
      for (int[] innerArray : a)
      {
         for (int val : innerArray)
         {
            total = total + val;
         }
      }
      return total / (a.length * a[0].length);
   }

   public static void main(String[] args)
   {
      int[][] theArray = {{80, 90, 70}, {20, 80, 75}};
      System.out.println(getAvg(theArray));
   }
}

