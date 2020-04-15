// Graphical User Interfaces
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e13;

// A GUI to compute a person's body mass index (BMI).
// Final version with event handling

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BmiGui4 implements ActionListener {
    // BmiGui3 is its own runnable client program
    public static void main(String[] args) {
        BmiGui4 gui = new BmiGui4();
    }

    // onscreen components stored as fields
    private JFrame frame;
    private JTextField heightField;
    private JTextField weightField;
    private JLabel bmiLabel;
    private JButton computeButton;

    public BmiGui4() {
        // set up components
        heightField = new JTextField(5);
        weightField = new JTextField(5);
        bmiLabel = new JLabel("Type your height and weight");
        computeButton = new JButton("Compute");

        // attach GUI as event listener to Compute button
        computeButton.addActionListener(this);

        // layout
        JPanel northWest = new JPanel(new GridLayout(2, 2));
        northWest.add(new JLabel("Height: "));
        northWest.add(new JLabel("Weight: "));

        JPanel northCenter = new JPanel(new GridLayout(2, 2));
        northCenter.add(heightField);
        northCenter.add(weightField);

        JPanel south = new JPanel(new GridLayout(2, 1));
        south.add(bmiLabel);
        south.add(computeButton, BorderLayout.SOUTH);

        JPanel north = new JPanel(new BorderLayout());
        north.add(northWest, BorderLayout.WEST);
        north.add(northCenter, BorderLayout.CENTER);
        north.add(south, BorderLayout.SOUTH);

        // overall frame
        frame = new JFrame("BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(north, BorderLayout.NORTH);
        frame.pack();
        //frame.setResizable(false);
        frame.setVisible(true);
    }

    // Handles clicks on Compute button by computing the BMI.
    public void actionPerformed(ActionEvent event) {
        // read height/weight info from text fields
        String heightText = heightField.getText();
        double height = Double.parseDouble(heightText);
        String weightText = weightField.getText();
        double weight = Double.parseDouble(weightText);

        // compute BMI and display it onscreen
        double bmi = weight / (height * height) * 703;
        bmiLabel.setText("BMI: " + bmi);
    }
}

