/*
 * Chapter 6: Introduction to GUI Programming (Swing)
 * http://math.hws.edu/eck/cs124/javanotes7/c6/index.html
 * Introduction to Programming Using Java, Seventh Edition by David J. Eck
 *
 * Section 2: Graphics and Painting
 */
package section6_2;

import javax.swing.JFrame;

/**
 * A program that shows a RandomStringsPanel as its content pane.
 */
public class RandomStrings {

    public static void main(String[] args) {
        JFrame window = new JFrame("Java!");
        RandomStringsPanel content = new RandomStringsPanel();
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120, 70);
        window.setSize(350, 250);
        window.setVisible(true);
    }

}

