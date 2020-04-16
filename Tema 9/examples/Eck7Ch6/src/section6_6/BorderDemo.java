/*
 * Chapter 6: Introduction to GUI Programming (Swing)
 * http://math.hws.edu/eck/cs124/javanotes7/c6/index.html
 * Introduction to Programming Using Java, Seventh Edition by David J. Eck
 *
 * Section 6: Basic Layout
 */
package section6_6;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * A simple program that shows six different types of border.  The
 * borders are used on labels which are contained in a panel that
 * itself uses an EmptyBorder.
 */
public class BorderDemo extends JPanel {

    /**
     * A main routine allows this class to be run as an application.
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Border Demo");
        BorderDemo content = new BorderDemo();
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120, 70);
        window.pack();
        window.setVisible(true);
    }

    //---------------------------------------------------------------------


    public BorderDemo() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(0, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        make(BorderFactory.createLineBorder(Color.RED, 2),
                " BorderFactory.createLineBorder(Color.RED,2) ");
        make(BorderFactory.createMatteBorder(2, 2, 5, 5, Color.RED),
                " BorderFactory.createMatteBorder(2,2,5,5,Color.RED) ");
        make(BorderFactory.createEtchedBorder(),
                " BorderFactory.createEtchedBorder() ");
        make(BorderFactory.createRaisedBevelBorder(),
                " BorderFactory.createRaisedBevelBorder() ");
        make(BorderFactory.createLoweredBevelBorder(),
                " BorderFactory.createLoweredBevelBorder() ");
        make(BorderFactory.createTitledBorder("Title Goes Here"),
                " BorderFactory.createTitledBorder(\"Title Goes Here\") ");
    }

    /**
     * Make a label showing the string and with the specified border.
     * The label will be opaque and will have a light gray background.
     * The label is added to the content pane.
     */
    void make(Border border, String command) {
        JLabel label = new JLabel(command, JLabel.CENTER);
        label.setBorder(border);
        add(label);
    }


}
