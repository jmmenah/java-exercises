/*
 ch10-arraylist.ppt - Slide 15
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordsPartialSolution {
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
        for (int i = 0; i < allWords.size(); i++) {
            String word = allWords.get(i);
            if (word.endsWith("s")) {
                allWords.remove(i);
                i--;
            }
        }
        System.out.println("\nAfter removing all plural words (ending with \"s\")");
        System.out.println(allWords);
        System.out.println("allWords size= " + allWords.size());
    }
}


