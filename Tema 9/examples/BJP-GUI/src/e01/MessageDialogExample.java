// Graphical User Interfaces - page 2 - slide 5
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e01;

// showMessageDialog analogous to System.out.println to display a message

import javax.swing.*;

public class MessageDialogExample {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"How's the weather?");
        JOptionPane.showMessageDialog(null, "Second message");
    }
}