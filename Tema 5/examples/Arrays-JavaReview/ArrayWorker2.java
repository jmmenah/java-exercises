// Arrays in Java 
// Using a For Loop to Loop Through an Array
// https://interactivepython.org/runestone/static/JavaReview/ArrayBasics/aLoopFrontToBack.html

public class ArrayWorker2
{
   private int[ ] values;

   public ArrayWorker2(int[] theValues)
   {
      values = theValues;
   }

   public void multAll(int amt)
   {
     for (int i = 0; i < values.length; i++)
     {
       values[i] = values[i] * amt;
     } // end for loop
   } // end method

   public void printValues()
   {
     for (int val : values )
     {
       System.out.println(val);
     }
   }

   public static void main(String[] args)
   {
     int[] numArray =  {2, 6, 7, 12, 5};
     ArrayWorker2 aWorker = new ArrayWorker2(numArray);
     aWorker.multAll(2);
     aWorker.printValues();

   }
}

