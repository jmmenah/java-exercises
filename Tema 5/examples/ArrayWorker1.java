// Arrays in Java 
// Looping with the For-Each Loop
// https://interactivepython.org/runestone/static/JavaReview/ArrayBasics/aForEach.html

public class ArrayWorker1
{
   private int[ ] values;

   public ArrayWorker1(int[] theValues)
   {
      values = theValues;
   }

   public double getAverage()
   {
     double total = 0;
     for (int val : values)
     {
       total  = total + val;
     }
     return total / values.length;
   }

   public static void main(String[] args)
   {
     int[] numArray =  {2, 6, 7, 12, 5};
     ArrayWorker1 aWorker = new ArrayWorker1(numArray);
     System.out.println(aWorker.getAverage());
   }
}

