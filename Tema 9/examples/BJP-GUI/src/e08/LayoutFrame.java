// Graphical User Interfaces - page 16
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e08;

import java.awt.*;
import javax.swing.*;

public class LayoutFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        // frame.setContentPane(Box.createVerticalBox());
        frame.setTitle("FlowLayout");

        frame.add(new JButton("Button 1"));
        frame.add(new JButton("Button 2"));
        frame.add(new JButton("Button 3"));
        frame.add(new JButton("Button 4"));
        frame.add(new JButton("Wide Button 5"));

        frame.pack();
        frame.setVisible(true);
    }
}
