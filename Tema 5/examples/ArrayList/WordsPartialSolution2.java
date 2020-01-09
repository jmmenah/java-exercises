/*
 ch10-arraylist.ppt - Slide 16
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordsPartialSolution2 {
    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList<String> allWords = new ArrayList<String>();
        Scanner input = new Scanner(new File("words.txt"));
        while (input.hasNext()) {
            String word = input.next();
            allWords.add(word);
        }
        System.out.println(allWords);
        System.out.println("allWords size= " + allWords.size());

        // remove all plural words
        removePlural(allWords);

        System.out.println("\nAfter removing all plural words (ending with \"s\")");
        System.out.println(allWords);
        System.out.println("allWords size= " + allWords.size());
    }

    // Removes all plural words from the given list.
    // ArrayList as parameter
    public static void removePlural(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.endsWith("s")) {
                list.remove(i);
                i--;
            }
        }
    }
}


