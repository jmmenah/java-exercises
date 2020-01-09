// Two-dimensional Arrays - Looping Through a 2D Array
// https://interactivepython.org/runestone/static/JavaReview/Array2dBasics/a2dLoop.html#looping-through-a-2d-array

public class Test2
{

   public static double getAverage(int[][] a)
   {
      double total = 0;
      int value = 0;
      for (int row = 0; row < a.length; row++)
      {
         for (int col = 0; col < a[0].length; col++)
         {
            value = a[row][col];
            total = total + value;
         }
      }
      return total / (a.length * a[0].length);
   }

   public static void main(String[] args)
   {
      int[][] matrix = {{1,2,3},{4,5,6}};
      System.out.println(getAverage(matrix));
   }
}

