// ch05-program-logic-indefinite-loops.ppt (slide 33)

// Rolls two dice until a sum of 7 is reached.

import java.util.Scanner;
import java.util.Random;

public class Dice2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int tries = 0;
        int sum;
        
        do {
            int roll1 = rand.nextInt(6) + 1;   // one roll
            int roll2 = rand.nextInt(6) + 1;
            sum = roll1 + roll2;
            System.out.println(roll1 + " + " + roll2 + " = " + sum);
            tries++;
        } while (sum != 7);
        
        System.out.println("You won after " + tries + " tries!");
    }
}
