// Graphical User Interfaces - page 3 - slide 6
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e02;

// showConfirmDialog analogous to a System.out.print that prints a question,
// then reading an input value from the user (can only be one of the provided choices)

import javax.swing.*;

public class ConfirmDialogExample {
    public static void main(String[] args) {
        int choice = JOptionPane.showConfirmDialog(null, "Erase your hard disk?");
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Disk erased!");
        } else {
            JOptionPane.showMessageDialog(null, "Cancelled.");
        }
    }
}