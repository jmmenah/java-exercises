// Graphical User Interfaces - page 43
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e20;

// A GUI that displays the position of the mouse over a label.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MousePointGUI extends MouseInputAdapter {
    public static void main(String[] args) {
        MousePointGUI gui = new MousePointGUI();
    }

    // fields
    private JFrame frame;
    private JLabel label;

    // sets up the GUI, components, and events
    public MousePointGUI() {
        label = new JLabel();
        label.setText("Move the mouse over me!");

        // listen for mouse events
        label.addMouseListener(this);
        label.addMouseMotionListener(this);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(200, 100));
        frame.setTitle("A frame");
        frame.add(label);
        frame.setVisible(true);
    }

    // responds to mouse movement events
    public void mouseMoved(MouseEvent event) {
        label.setText("(" + event.getX() + ", " +
                            event.getY() + ")");
    }
}
