// Graphical User Interfaces - page 14
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e07;

// Responds to a button click by displaying a message box.

import java.awt.event.*;
import javax.swing.*;

public class MessageListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null,
                "You clicked the button!");
    }
}
