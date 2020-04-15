// Graphical User Interfaces - page 26
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e13;

// A GUI to compute a person's body mass index (BMI).
// Object-oriented version without event handling.

import java.awt.*;
import javax.swing.*;

public class BmiGui2 {
    // onscreen components stored as fields
    private JFrame frame;
    private JTextField heightField;
    private JTextField weightField;
    private JLabel bmiLabel;
    private JButton computeButton;

    public BmiGui2() {
        // set up components
        heightField = new JTextField(5);
        weightField = new JTextField(5);
        bmiLabel = new JLabel(
            "Type your height and weight");
        computeButton = new JButton("Compute");

        // layout
        JPanel north = new JPanel(new GridLayout(2, 2));
        north.add(new JLabel("Height: "));
        north.add(heightField);
        north.add(new JLabel("Weight: "));
        north.add(weightField);

        // overall frame
        frame = new JFrame("BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(north, BorderLayout.NORTH);
        frame.add(bmiLabel, BorderLayout.CENTER);
        frame.add(computeButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
