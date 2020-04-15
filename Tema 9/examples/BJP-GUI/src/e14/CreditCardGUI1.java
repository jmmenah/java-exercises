// Graphical User Interfaces - page 31
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e14;

// Presents a GUI to verify credit card numbers.
// Initial version without event handling.

import java.awt.*;
import javax.swing.*;


public class CreditCardGUI1 {
    public static void main(String[] args) {
        CreditCardGUI1 gui = new CreditCardGUI1();
    }

    // fields
    private JFrame frame;
    private JTextField numberField;
    private JLabel validLabel;
    private JButton verifyButton;

    // creates components, does layout, shows window onscreen
    public CreditCardGUI1() {
        numberField = new JTextField(16);
        validLabel = new JLabel("not yet verified");
        verifyButton = new JButton("Verify CC Number");

        frame = new JFrame("Credit card number verifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(350, 100));
        frame.setLayout(new FlowLayout());
        frame.add(numberField);
        frame.add(verifyButton);
        frame.add(validLabel);

        frame.setVisible(true);

    }
}