// Graphical User Interfaces - page 42
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e19;

// Responds to a mouse click by showing a message
// that indicates where the user clicked

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ClickListener extends MouseInputAdapter {

    public void mousePressed(MouseEvent event) {

        JOptionPane.showMessageDialog(null,
            "Mouse pressed at position ("
            + event.getX() + ", " + event.getY() + ")");
    }
}
