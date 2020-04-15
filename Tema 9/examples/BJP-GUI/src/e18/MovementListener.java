// Graphical User Interfaces - page 40
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e18;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Mouse listener to show a message dialog on each mouse event.
public class MovementListener extends MouseInputAdapter {
    public void mouseEntered(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Mouse entered!");
    }
}
