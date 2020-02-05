// A graphical equivalent of the classic "Hello world" program.

// Compile and create directories with -d option
// javac -d . HelloWorldSwing.java

// Execute
// java first.programs.HelloWorldSwing 
 
package first.programs;

import javax.swing.*;   // for GUI components

public class HelloWorldSwing {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hello, world!");
    }
}
