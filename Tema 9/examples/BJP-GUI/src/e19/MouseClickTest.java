// Graphical User Interfaces - page 41
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e19;

import java.awt.*;
import javax.swing.*;

public class MouseClickTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setTitle("Click Test");

        ClickListener mListener = new ClickListener();
        frame.addMouseListener(mListener);
        frame.addMouseMotionListener(mListener);

        frame.setVisible(true);
    }
}
