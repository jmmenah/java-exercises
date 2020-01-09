/*
 ch10-arraylist.ppt - Slide 3
	Problem: You don't know how many words the file will have.
		- Hard to create an array of the appropriate size.
		- Later parts of the problem are more difficult to solve.
*/
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class WordsNaiveSolution {
    public static void main(String[] args) throws FileNotFoundException {
        
        String[] allWords = new String[1000];
        int wordCount = 0;

        Scanner input = new Scanner(new File("data.txt"));
        while (input.hasNext()) {
            String word = input.next();
            allWords[wordCount] = word;
            wordCount++;
        }

        System.out.println("allWords = " + Arrays.toString(allWords));

        System.out.println("wordCount = " + wordCount);

        System.out.println("Last Word = " + allWords[wordCount-1]);

    }
}


