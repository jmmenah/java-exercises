// Graphical User Interfaces - page 3
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf

package e02;

import static javax.swing.JOptionPane.*;

public class UseOptionPanesB {
    public static void main(String[] args) {
        String name = showInputDialog(null, "What is your name?");

        int choice = showConfirmDialog(null, "Do you like cake, " + name + "?");
        if (choice == YES_OPTION) {
            showMessageDialog(null, "Of course!  Who doesn't?");
        } else {
            // choice == JOptionPane.NO_OPTION or CANCEL_OPTION
            showMessageDialog(null, "We'll have to agree to disagree.");
        }
    }
}
