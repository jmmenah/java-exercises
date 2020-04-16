/*
 * Chapter 6: Introduction to GUI Programming (Swing)
 * http://math.hws.edu/eck/cs124/javanotes7/c6/index.html
 * Introduction to Programming Using Java, Seventh Edition by David J. Eck
 *
 * Section 3: Mouse Events
 */
package section6_3;

import section6_2.RandomStringsPanel;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/*
 * This version uses an anonymous class based on MouseAdapter to handle mouse events
 * The adapter class MouseAdapter implements both the MouseListener interface and the
 * MouseMotionListener interface, so it can be used as a basis for creating a listener
 * for any mouse event.
 */
public class ClickableRandomStrings2 {

    public static void main(String[] args) {
        JFrame window = new JFrame("Random Strings");
        RandomStringsPanel content = new RandomStringsPanel();

        content.addMouseListener(new MouseAdapter() {
            // Register a mouse listener that is defined by an anonymous subclass
            // of MouseAdapter.  This replaces the RepaintOnClick class that was
            // used in the original version.
            public void mousePressed(MouseEvent evt) {
                Component source = (Component) evt.getSource();
                source.repaint();
            }
        });

        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(100, 75);
        window.setSize(300, 240);
        window.setVisible(true);
    }

}