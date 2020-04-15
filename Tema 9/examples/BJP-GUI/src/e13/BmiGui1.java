// Graphical User Interfaces - page 24
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e13;

// A GUI to compute a person's body mass index (BMI).
// Initial version without event handling.

import java.awt.*;
import javax.swing.*;

public class BmiGui1 {
    public static void main(String[] args) {
        // set up components
        JTextField heightField = new JTextField(5);
        JTextField weightField = new JTextField(5);
        JLabel bmiLabel = new JLabel(
                "Type your height and weight");
        JButton computeButton = new JButton("Compute");

        // layout
        JPanel north = new JPanel(new GridLayout(2, 2));
        north.add(new JLabel("Height: "));
        north.add(heightField);
        north.add(new JLabel("Weight: "));
        north.add(weightField);

        // overall frame
        JFrame frame = new JFrame("BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(north, BorderLayout.NORTH);
        frame.add(bmiLabel, BorderLayout.CENTER);
        frame.add(computeButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
