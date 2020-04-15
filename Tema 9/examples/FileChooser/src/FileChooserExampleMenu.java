/*
 * Java Swing – JFileChooser example
 * JFileChooser is a quick and easy way to prompt the user to choose a file or a file saving location.
 * Please visit and practice some simple examples of how to use this class.
 * https://mkyong.com/swing/java-swing-jfilechooser-example/
 *
 * Menus and toolbars in Java Swing
 * http://zetcode.com/tutorials/javaswingtutorial/menusandtoolbars/
 *
 */

//  Using var, local variable type inference in Java 10
// https://dzone.com/articles/finally-java-10-has-var-to-declare-local-variables

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileChooserExampleMenu extends JPanel implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame("File Chooser Example");
        FileChooserExampleMenu content = new FileChooserExampleMenu();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(200, 200);
        frame.setSize(400, 500);
        //frame.pack();
        //frame.setResizable(false);
        frame.setVisible(true);
    }

    private JTextArea textArea;
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem cutMenuItem;
    private JMenuItem copyMenuItem;
    private JMenuItem pasteMenuItem;
    private JMenuItem selectAllMenuItem;
    private JLabel statusLabel;

    public FileChooserExampleMenu() {
        super(new BorderLayout());
        setMenuBar();
        setAddActionListeners();
        setTextArea();
        setStatusLabel();
    }

    private void setAddActionListeners() {
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pasteMenuItem.addActionListener(this);
        selectAllMenuItem.addActionListener(this);
    }

    private void setMenuBar() {
        var menuBar = new JMenuBar();
        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // keyboard shortcut

        var editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E); // keyboard shortcut

        var helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H); // keyboard shortcut

        var iconOpen = new ImageIcon(getClass().getResource("/open.png"));
        var iconSave = new ImageIcon(getClass().getResource("/save.png"));
        var iconExit = new ImageIcon(getClass().getResource("/exit.png"));

        openMenuItem = new JMenuItem("Open", iconOpen);
        saveMenuItem = new JMenuItem("Save", iconSave);
        exitMenuItem = new JMenuItem("Exit", iconExit);

        cutMenuItem = new JMenuItem("Cut");
        copyMenuItem = new JMenuItem("Copy");
        pasteMenuItem = new JMenuItem("Paste");
        selectAllMenuItem = new JMenuItem("Select All");

        openMenuItem.setMnemonic(KeyEvent.VK_O);
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        exitMenuItem.setToolTipText("Exit application");

        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(selectAllMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(helpMenu);

        add(menuBar, BorderLayout.NORTH);
    }

    private void setTextArea() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        //textArea.setEditable(false);
        textArea.setText("No open file yet");
        textArea.setMargin(new Insets(5, 5, 5, 5));
        scrollPane.setViewportView(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setStatusLabel() {
        statusLabel = new JLabel();
        statusLabel.setText("File name");
        add(statusLabel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        var source = actionEvent.getSource();

        if (source == openMenuItem) {
            String fileContent = openFile();
            textArea.setText(fileContent);
        } else if (source == saveMenuItem) {
            saveFile();
        } else if (source == cutMenuItem) {
            textArea.cut();
        } else if (source == copyMenuItem) {
            textArea.copy();
        } else if (source == pasteMenuItem) {
            textArea.paste();
        } else if (source == selectAllMenuItem) {
            textArea.selectAll();
        } else if (source == exitMenuItem) {
            System.exit(0);
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
