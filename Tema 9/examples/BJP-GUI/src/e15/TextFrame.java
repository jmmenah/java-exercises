// Graphical User Interfaces - page 35
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e15;

// Demonstrates the JTextArea component.

import java.awt.*;
import javax.swing.*;

public class TextFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(300, 150));
        frame.setTitle("Text frame");
        
        JTextArea area = new JTextArea(5, 20);
        //area.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(area);
        //frame.add(new JScrollPane(area));
        
        frame.setVisible(true);
    }
}
