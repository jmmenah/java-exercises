/*
 * Java Swing – JFileChooser example
 * JFileChooser is a quick and easy way to prompt the user to choose a file or a file saving location.
 * Please visit and practice some simple examples of how to use this class.
 * https://mkyong.com/swing/java-swing-jfilechooser-example/
 */

// https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileChooserExampleButtonSwing extends JPanel implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame("File Chooser Example");
        FileChooserExampleButtonSwing content = new FileChooserExampleButtonSwing();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(200, 200);
        frame.setSize(400, 500);
        //frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JTextArea textArea;
    private JButton openButton;
    private JButton saveButton;
    private JLabel statusLabel;

    public FileChooserExampleButtonSwing() {
        setLayout(new BorderLayout());
        JPanel north = new JPanel(new GridLayout(1, 2));

        openButton = new JButton();
        openButton.setText("Open file");
        openButton.addActionListener(this);
        north.add(openButton);

        saveButton = new JButton();
        saveButton.setText("Save file");
        saveButton.addActionListener(this);
        north.add(saveButton);

        add(north, BorderLayout.NORTH);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        //textArea.setEditable(false);
        textArea.setText("No open file yet");
        textArea.setMargin(new Insets(5, 5, 5, 5));

        scrollPane.setViewportView(textArea);
        add(scrollPane, BorderLayout.CENTER);

        statusLabel = new JLabel();
        statusLabel.setText("File name");
        add(statusLabel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == openButton) {
            String fileContent = openFile();
            textArea.setText(fileContent);
        }
        if (actionEvent.getSource() == saveButton) {
            saveFile();
        }
    }

    private String openFile() {
        JFileChooser fileChooser = new JFileChooser();
        String data = "";
        String message = "";
        try {
            fileChooser.setDialogTitle("Select a text file");
            // https://www.codejava.net/java-se/swing/add-file-filter-for-jfilechooser-dialog
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("*.txt", "txt");
            FileNameExtensionFilter htmlFilter = new FileNameExtensionFilter("*.htm, *.html", "htm", "html");
            fileChooser.addChoosableFileFilter(txtFilter);
            fileChooser.addChoosableFileFilter(htmlFilter);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Markdown *.md", "md"));
            int returnVal = fileChooser.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                message = file.getAbsolutePath();
                // https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
                data = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            } else {
                message = "File selection cancelled!";
            }
        } catch (IOException e) {
            message = "No file selected";
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Problem", JOptionPane.WARNING_MESSAGE);
        } finally {
            statusLabel.setText(message);
        }
        return data;
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        String message = "";
        try {
            fileChooser.setDialogTitle("Saving a text file");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("txt files", "txt"));
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                FileWriter save = new FileWriter(file + ".txt");
                save.write(textArea.getText());
                save.close();
                message = file.getAbsolutePath() + ".txt";
            } else {
                message = "File saving cancelled!";
            }
        } catch (IOException e) {
            message = "No file saved";
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Problem", JOptionPane.WARNING_MESSAGE);
        } finally {
            statusLabel.setText(message);
        }
    }
}
