// Graphical User Interfaces - page 12 - slide 20
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e06;

import java.awt.*;
import javax.swing.*;

public class ComponentsExample1_FlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 100));
        frame.setTitle("A frame");
        frame.setLayout(new FlowLayout());
        
        JButton button1 = new JButton();
        button1.setText("I'm a button.");
        button1.setBackground(Color.BLUE);
        frame.add(button1);
        
        JButton button2 = new JButton();
        button2.setText("Click me!");
        button2.setBackground(Color.RED);
        frame.add(button2);
        
        //frame.pack();
        frame.setVisible(true);
    }
}