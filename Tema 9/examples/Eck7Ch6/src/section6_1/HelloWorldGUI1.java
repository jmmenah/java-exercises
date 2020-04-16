/*
 * Chapter 6: Introduction to GUI Programming (Swing)
 * http://math.hws.edu/eck/cs124/javanotes7/c6/index.html
 * Introduction to Programming Using Java, Seventh Edition by David J. Eck
 *
 * Section 1: The Basic GUI Application
 */
package section6_1;

import javax.swing.JOptionPane;

/**
 * Puts up a dialog box that says "Hello World."  The program
 * ends when the user closes the dialog box.  This is, perhaps,
 * the simplest possible GUI program.
 */
public class HelloWorldGUI1 {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hello World!");
    }

}
