/*
 ch10-arraylist.ppt - Slide 20
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FilterEvenNumbers {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner input = new Scanner(new File("numbers.txt"));
        while (input.hasNextInt()) {
            int n = input.nextInt();
            numbers.add(n);
        }
        System.out.println(numbers);
        System.out.println("numbers size= " + numbers.size());

        filterEvens(numbers);

        System.out.println("\nAfter calling to \"filterEvens\"");
        System.out.println(numbers);
        System.out.println("numbers size= " + numbers.size());
    }

    // Removes all elements with even values from the given list.
    public static void filterEvens(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int n = list.get(i);
            if (n % 2 == 0) {
                list.remove(i);
            }
        }
    }
}


