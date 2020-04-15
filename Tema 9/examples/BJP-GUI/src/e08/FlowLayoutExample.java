// Graphical User Interfaces - page 16 - slide 35
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e08;
/*
 * Perhaps the simplest layout manager is FlowLayout . As we discussed previously,
 * a FlowLayout positions components in a left-to-right, top-to-bottom flow, similar to
 * the way that words are arranged in a paragraph. If a row of components is too wide to
 * fit in the frame, the row wraps.
 * Resizing the window illustrates the wrapping behavior.
 */
import java.awt.*;
import javax.swing.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(320, 75));
        frame.setTitle("Flow layout");

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Type your ZIP Code: "));
        frame.add(new JTextField(5));
        frame.add(new JButton("Submit"));

        frame.setVisible(true);
    }
}
