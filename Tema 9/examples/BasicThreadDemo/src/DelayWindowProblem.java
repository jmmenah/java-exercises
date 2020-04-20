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

public class DelayWindowProblem extends JFrame{

    private JButton jButton;

    public DelayWindowProblem() {
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
            try {
                System.out.println("A time-consuming process...");
                Thread.sleep(10000);
                System.out.println("...the wait is over!");
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
        new DelayWindowProblem();

    }

}  // End Class
