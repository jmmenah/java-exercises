// Graphical User Interfaces - page 6 - slide 9
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e04;

// Shows an empty window frame on the screen.
// The program’s output is a bit silly—it’s just a tiny window:
// Problem: Closing the window doesn’t actually terminate the Java program.

import javax.swing.*;

import java.awt.Dimension;

public class SimpleFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //frame.setTitle("A window frame");
        //frame.setSize(new Dimension(100, 120));
        frame.setVisible(true);
    }
}
