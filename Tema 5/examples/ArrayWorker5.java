// Arrays in Java 
// Looping through Part of an Array
// https://interactivepython.org/runestone/static/JavaReview/ArrayBasics/aLoopPart.html

public class ArrayWorker5
{
   private int[ ] values;

   public ArrayWorker5(int[] theValues)
   {
      values = theValues;
   }

   public void doubleLastHalf()
   {
     for (int i = values.length / 2; i < values.length; i++)
     {
       values[i] = values[i] * 2;
     }
   }

   public void printArray()
   {
      for (int val: values)
      {
         System.out.println(val);
      }
   }

   public static void main(String[] args)
   {
     int[] numArray = {3,8,-3, 2};
     ArrayWorker5 worker = new ArrayWorker5(numArray);
     worker.doubleLastHalf();
     worker.printArray();
   }
}

