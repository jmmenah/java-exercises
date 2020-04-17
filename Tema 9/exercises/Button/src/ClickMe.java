import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClickMe implements ActionListener {
    // Counts the number of clicks
    private int counter = 0;

    // The label to display the counter value.
    private JLabel counterLabel;

    // Button that counts up when clicked.
    private JButton countUpButton;

    public JPanel createPanel() {
        // Create the panel that will display the form
        JPanel clickMePanel = new JPanel();

        // Add the button that counts up
        countUpButton = new JButton ("Click Me!");
        countUpButton.addActionListener(this);
        clickMePanel.add(countUpButton);

        // Add a counter to the display
        counterLabel = new JLabel("Number of clicks: " + counter);
        clickMePanel.add(counterLabel);

        return clickMePanel;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == countUpButton) {
            counter++;
            counterLabel.setText("Number of clicks: "+ counter);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Click Me!");
        f.setSize(new Dimension(400, 200));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel to display
        ClickMe clickMe = new ClickMe();
        JPanel clickMePanel = clickMe.createPanel();

        // Add the panel to the center of the window
        Container contentPane = f.getContentPane();
        contentPane.add(clickMePanel, BorderLayout.CENTER);

        // Display the window.
        f.setVisible(true);

    }

}
