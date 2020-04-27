// Graphical User Interfaces - page 9 - slide 10
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e04;

// Sets several properties of a window frame.

import java.awt.*;      // for Dimension
import javax.swing.*;   // for GUI components

public class SimpleFrame2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //frame.setForeground(Color.WHITE);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(new Point(10, 50));
        frame.setSize(new Dimension(300, 120));
	    frame.getContentPane().setBackground(Color.YELLOW);
        JLabel label = new JLabel("This is a label");
        label.setForeground(Color.RED);
        frame.add(label);
        frame.setTitle("A frame");
        frame.setVisible(true);
    }
}