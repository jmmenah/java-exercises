// Things to Watch For When Looping Through an Array
// https://interactivepython.org/runestone/static/JavaReview/ArrayBasics/aProcessAll.html

public class StringWorker
{
   private String[ ] arr = {"Hello", "Hey", "Good morning!"};

   public int findString(String target)
   {
     String word = null;
     for (int index = 0; index < arr.length; index++)
     {
       word = arr[index];

       if (word.equals(target))
       {
         return index;
       }
       else return -1;
     }
     return -1;
   }

   public static void main(String[] args)
   {
     StringWorker sWorker = new StringWorker();
     System.out.println(sWorker.findString("Hey"));
   }
}

/*
What is wrong with the code above? The first time through the loop it will start with the element at index 0 and check if the item at the array index equals the passed target string. If they have the same characters in the same order it will return 0, otherwise it will return -1. But, it has only processed one element of the array. How would you fix the code to work correctly (process all array elements before returning)?
*/

