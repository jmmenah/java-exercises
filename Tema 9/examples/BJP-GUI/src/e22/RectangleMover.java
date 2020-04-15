// Graphical User Interfaces - page 46
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e22;

import java.awt.event.*;

public class RectangleMover implements ActionListener {
    private AnimatedRectPanel panel;
    
    public RectangleMover(AnimatedRectPanel panel) {
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent event) {
        panel.move();
        panel.repaint();
    }
}
