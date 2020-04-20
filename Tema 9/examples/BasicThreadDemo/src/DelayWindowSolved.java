/*
 * Modified example from the original of the book
 * JAVA A FONDO - Estudio del lenguaje y desarrollo de aplicaciones - 2ª Edición
 * Autor: SZNAJDLEDER, Pablo
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelayWindowSolved extends JFrame {

    private JButton jButton;

    public DelayWindowSolved() {
        setTitle("Delayed Window");
        setLayout(new FlowLayout());

        jButton = new JButton("This will take time...");

        add(jButton);
        jButton.addActionListener(new buttonListener());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new ComboBoxPets());

        pack();
        setVisible(true);
    }

    private class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            jButton.setEnabled(false); // Disable button

            ButtonTask buttonTask = new ButtonTask();
            buttonTask.start();
        }
    }

    private class ButtonTask extends Thread {
        @Override
        public void run() {

            try {

                System.out.println("A time-consuming process...");
                Thread.sleep(10000);
                System.out.println("...the wait is over!");
                jButton.setEnabled(true); // Enable button

            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }


    public static void main(String[] args) {
        new DelayWindowSolved();

    }

}  // End Class
