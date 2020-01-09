// Two-dimensional Arrays - Loop Through Part of a 2D Array
// https://interactivepython.org/runestone/static/JavaReview/Array2dBasics/a2dLoopPart.html

public class Test5
{

   public static int getTotalForRow(int row, int[][] a)
   {
      int total = 0;
      for (int col = 0; col < a[0].length; col++)
      {
         total = total + a[row][col];
      }
      return total;
   }

   public static void main(String[] args)
   {
      int[][] matrix = {{1,2,3},{4,5,6}};
      System.out.println(getTotalForRow(0,matrix));
   }
}

