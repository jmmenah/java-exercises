/*
 * References:
 * https://stackoverflow.com/questions/45368725/how-to-move-button-when-you-put-the-mouse-over-it
 *
 * https://docs.oracle.com/javase/7/docs/api/java/awt/Toolkit.html#createCustomCursor(java.awt.Image,%20java.awt.Point,%20java.lang.String)
 *
 * Java: Incorrect rendering of full-color cursors on Linux
 * https://github.com/TigerVNC/tigervnc/issues/512
 *
 * virus.png, victory.png
 *   Autor pictogramas: Sergio Palao Procedencia: ARASAAC (http://arasaac.org)
 *   Licencia: CC (BY-NC-SA) Propiedad: Gobierno de Aragón
 *
 * pj01674.wav
 *   Banco de imágenes y sonidos Ministerio de Educación (http://recursostic.educacion.es/bancoimagenes/web/)
 *   licencia CC (BY-NC-SA 3.0)
 */

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
// import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class ButtonChase extends JPanel implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame("End of coronavirus quarantine");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setResizable(false);

        // Set custom cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image cursorImage = toolkit.getImage(ButtonChase.class.getResource("/virus32.png"));
        Point cursorHotSpot = new Point(16, 16);
        Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
        frame.setCursor(customCursor);
        // linux only 2 colors for cursor
        // System.out.println(toolkit.getMaximumCursorColors());

        // Background Image
        Image image = null;
        try {
            //image = ImageIO.read(new File("virus.png"));
            image = ImageIO.read(ButtonChase.class.getResource("/virus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BackgroundPanel backgroundPanel = new BackgroundPanel(image, BackgroundPanel.TILED, 1.0f, 0.5f);

        ButtonChase coronavirus = new ButtonChase();
        backgroundPanel.add(coronavirus);

        frame.setContentPane(backgroundPanel);

        frame.setVisible(true); // display frame
    }

    private JButton yesButton;
    private JButton noButton;

    public ButtonChase() {
        setLabel();
        setButtons();
    }

    private void setLabel() {
        JLabel label = new JLabel("End of Coronavirus Quarantine?");
        label.setFont(new Font("Serif", Font.BOLD, 32));
        label.setForeground(Color.BLUE);
        label.setBackground(Color.CYAN);
        label.setOpaque(true);
        Border border = label.getBorder();
        Border margin = new EmptyBorder(10, 10, 10, 10);
        label.setBorder(new CompoundBorder(border, margin));
        add(label);
    }

    private void setButtons() {
        yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Serif", Font.BOLD, 32));
        yesButton.setPreferredSize(new Dimension(100, 50));

        noButton = new JButton("No");
        noButton.setFont(new Font("Serif", Font.BOLD, 32));
        noButton.setPreferredSize(new Dimension(100, 50));

        add(yesButton);
        add(noButton);

        yesButton.addActionListener(this);
        noButton.addActionListener(this);

        yesButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) (screenSize.width * 0.9);
                int y = (int) (screenSize.height * 0.9);
                yesButton.setLocation(new Random().nextInt(x), new Random().nextInt(y));
                Sound();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == yesButton) {
            Icon icon = new ImageIcon(ButtonChase.class.getResource("victory.png"));
            JOptionPane.showMessageDialog(this, "Safe and sound", "Congratulations", JOptionPane.PLAIN_MESSAGE, icon);
            System.exit(0);
        } else {
            int value = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION);
            if (value == JOptionPane.YES_OPTION) System.exit(0);
        }
    }

    private void Sound() {
        try {
            // Open an audio input stream.
            URL url = ButtonChase.class.getClassLoader().getResource("pj01674.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

            AudioFormat format = audioIn.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip clip = (Clip) AudioSystem.getLine(info);
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
