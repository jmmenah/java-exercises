import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class ClickMeWindow extends JFrame implements ActionListener {
    // Counts the number of clicks
    private int counter = 0;

    // Button that counts up when clicked.
    private JButton countUpButton;

    public JPanel createPanel() {
        // Create the panel that will display the form
        JPanel clickMePanel = new JPanel();

        // Add the button that counts up
        countUpButton = new JButton ("Number of clicks: " + counter);
        countUpButton.addActionListener(this);
        countUpButton.setPreferredSize(new Dimension(495, 455));
        countUpButton.setBackground(Color.BLUE);
        countUpButton.setForeground(Color.WHITE);
        countUpButton.setContentAreaFilled(false);
        countUpButton.setOpaque(true);
        clickMePanel.add(countUpButton);

        return clickMePanel;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == countUpButton) {
            counter++;
            countUpButton.setText("Number of clicks: "+ counter);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Click Me Window!");
        f.setSize(new Dimension(500, 500));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel to display
        ClickMeWindow clickMe = new ClickMeWindow();
        JPanel clickMePanel = clickMe.createPanel();

        // Add the panel to the center of the window
        Container contentPane = f.getContentPane();
        contentPane.add(clickMePanel, BorderLayout.CENTER);

        // Display the window.
        f.setVisible(true);

    }

}

