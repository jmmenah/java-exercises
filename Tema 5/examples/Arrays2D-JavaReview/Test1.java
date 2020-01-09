// Two-dimensional Arrays - Set Value(s) in a 2D Array
// https://interactivepython.org/runestone/static/JavaReview/Array2dBasics/a2dDAS.html#set-value-s-in-a-2d-array

public class Test1
{
   public static void main(String[] args)
   {
      // declare arrays
      int[][] ticketInfo;
      String[][] seatingChart;

      // create arrays
      ticketInfo = new int [2][3];
      seatingChart =  new String [3][2];

      // initialize the array elements
      ticketInfo[0][0] = 15;
      ticketInfo[0][1] = 10;
      ticketInfo[0][2] = 15;
      ticketInfo[1][0] = 25;
      ticketInfo[1][1] = 20;
      ticketInfo[1][2] = 25;
      seatingChart[0][0] = "Jamal";
      seatingChart[0][1] = "Maria";
      seatingChart[1][0] = "Jacob";
      seatingChart[1][1] = "Suzy";
      seatingChart[2][0] = "Emma";
      seatingChart[2][1] = "Luke";

      // print the contents
      System.out.println(ticketInfo);
      System.out.println(seatingChart);
   }
}
