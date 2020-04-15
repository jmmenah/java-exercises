// Graphical User Interfaces - page 3 - slide 7
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e02;

// showInputDialog analogous to a System.out.print that prints a question,
// then reading an input value from the user (can be any value)

import javax.swing.*;

public class InputDialogExample {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null,
                "What's yer name, pardner?");
        JOptionPane.showMessageDialog(null, "Yeehaw, " + name);
    }
}