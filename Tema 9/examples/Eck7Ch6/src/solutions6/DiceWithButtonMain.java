/*
 * Chapter 6: Introduction to GUI Programming (Swing)
 * http://math.hws.edu/eck/cs124/javanotes7/c6/index.html
 * Introduction to Programming Using Java, Seventh Edition by David J. Eck
 *
 * Exercise 6.4: Programming Exercises for Chapter 6
 * http://math.hws.edu/eck/cs124/javanotes7/c6/exercises.html
 */
package solutions6;

import javax.swing.JFrame;

/**
 * A main program that just opens a window that shows a DicePanelWithButton.
 */
public class DiceWithButtonMain {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        DicePanelWithButton content = new DicePanelWithButton();
        window.setContentPane(content);
        window.pack();
        window.setLocation(100, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);  // User can't change the window's size.
        window.setVisible(true);
    }

}