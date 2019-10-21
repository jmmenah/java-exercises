/******************************************************************************
 *  Compilation:  javac RollDie.java
 *  Execution:    java RollDie
 *
 *  Simulate the roll of a fair six-sided die
 *  and print the resulting number.
 *
 *  % java RollDie
 *  4
 *
 *  % java RollDie
 *  1
 *
 ******************************************************************************/

public class RollDie {
    public static void main(String[] args) {
        int SIDES = 6;   // how many sides on the die?

        // roll should be 1 through SIDES
        int roll = (int) (Math.random() * SIDES) + 1;

        // print result
        System.out.println(roll);

    }
}


