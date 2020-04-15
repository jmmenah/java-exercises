// Graphical User Interfaces - page 4
// http://www.buildingjavaprograms.com/samples/5ed/gui-sample-chapter.pdf
package e03;

// Uses JOptionPane windows for numeric input.

import javax.swing.*; // for GUI components

public class UseOptionPanesNumericInput {
    public static void main(String[] args) {
        String ageText = JOptionPane.showInputDialog(null, "How old are you?");
        int age = Integer.parseInt(ageText);
        String moneyText = JOptionPane.showInputDialog(null, "How much money do you have?");
        double money = Double.parseDouble(moneyText);
        JOptionPane.showMessageDialog(null, 
                "If you can double your money each year,\n" +
                "You'll have " + (money * 32) + 
                "dollars at age " + (age + 5) + "!");
    }
}

