/*
 * Chapter 3: Programming in the Small II: Control
 * math.hws.edu/eck/cs124/javanotes7/c3/index.html
 * Introduction to Programming Using Java, Seventh Edition by David J. Eck
 *
 * Section 3.9 Introduction to GUI Programming
 */
package section3_9;

import javax.swing.*;
import java.awt.*;

/**
 * This program draws a set of ten parallel lines
 * lines are 200 pixels long and that the distance from each line to the next is 20 pixels
 */
public class TenParallelLines {

    private static class TenLines extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int y;   // y-coordinate for the line
            int i;   // loop control variable
            y = 50;  // y starts at 50 for the first line

            for (i = 1; i <= 10; i++) {
                g.drawLine(100, y, 300, y);
                y = y + 20;  // increase y by 20 before drawing the next line.
            }
        }
    }

    public static void main(String[] args) {
        TenLines tenLines = new TenLines();
        JFrame window = new JFrame("Ten parallel lines");
        window.setSize(400, 300);
        window.setLocation(200, 200);
        window.getContentPane().add(tenLines);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }  // end of main()
}  // end of class
