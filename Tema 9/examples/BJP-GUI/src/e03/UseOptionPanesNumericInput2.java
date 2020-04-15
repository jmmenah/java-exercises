// Graphical User Interfaces - page 5
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e03;

// Uses JOptionPane windows for numeric input.

import javax.swing.*; // for GUI components

public class UseOptionPanesNumericInput2 {
    public static void main(String[] args) {
        String ageText = JOptionPane.showInputDialog(null, "How old are you?");
        int age = 0;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid integer.");
            System.exit(1);
        }
        String moneyText = JOptionPane.showInputDialog(null, "How much money do you have?");

        try {
            double money = Double.parseDouble(moneyText);
            JOptionPane.showMessageDialog(null, 
                    "If you can double your money each year,\n" + 
                    "You'll have " + (money * 32) + 
                    "dollars at age " + (age + 5) + "!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid double.");
        }
    }
}

