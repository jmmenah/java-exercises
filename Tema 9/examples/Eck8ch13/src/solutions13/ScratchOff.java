/*
 * Chapter 13: GUI Programming Continued (JavaFX)
 * http://math.hws.edu/eck/cs124/javanotes8/c13/index.html
 * Introduction to Programming Using Java, Eighth Edition by David J. Eck
 *
 * Exercise 13.1: Programming Exercises for Chapter 13
 * http://math.hws.edu/eck/cs124/javanotes8/c13/exercises.html
 */
package solutions13;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A program that lets the user "scratch off" a mask that is covering an
 * image, by dragging the mouse.  This program requires that some specific
 * image files be available as resource files in a folder named "nature-images".
 */
public class ScratchOff extends Application {

    public static void main(String[] args) {
        launch();
    }
    //-------------------------------------------------------------------
    
    private final static String[] picFileNames = {
                // These are the names of the resource image files that contain
                // the pictures used by this program.  The must be in folder
                // named nature-images.
            "bluejay.jpg", "chipmunk.jpg", "collie.jpg", "elephants.jpg", 
            "faun.jpg", "lion.jpg", "polar-bear.jpg", "stork.jpg"
    };
    
    private Canvas picCanvas;                // canvas where picture is drawn
    private GraphicsContext picGraphics;     // graphics context for picCanvas
    private Canvas overlayCanvas;            // canvas that hides the picture
    private GraphicsContext overlayGraphics; // graphics context for overlayCanvas
    
    private ArrayList<Image> pictures;  // An arraylist containing the images
    private int nextPicIndex;  // The index of the array list of the next picture
                               // that will be drawn.  To avoid repeating a picture
                               // until all of the pictures have been used,
                               // the array list is shuffled and the pictures are
                               // shown in the reverse order that they occur in the
                               // list.  If all the pictures are used, the list is
                               // reshuffled and the pictures are reused.
    
    private final int[] sizes = { 10, 20, 35, 60 };  // sizes for the square that
                                                     // is revealed when the user
                                                     // drags the mouse
    private double scratcherSize; // current size of the rectangle; one of the
                                  // items from the previous array, depeding on
                                  // the current setting of a ComboBox
    
    private final static int width = 800;    // canvas size
    private final static int height = 600;
    
    /**
     * Set up the GUI.  The overlay canvas, which hides the picture is
     * stacked on top of the canvas that displays the image.  There are
     * some buttons and a combo box at the bottom of the window.
     */
    public void start(Stage stage) {
                
        picCanvas = new Canvas(width,height);
        picGraphics = picCanvas.getGraphicsContext2D();
        overlayCanvas = new Canvas(width,height);
        overlayGraphics = overlayCanvas.getGraphicsContext2D();
        
        pictures = new ArrayList<Image>();
        for (int i = 0; i < picFileNames.length; i++) {
            pictures.add( new Image("solutions13/nature-images/" + picFileNames[i]) );
        }
        Collections.shuffle(pictures);  // put pictures in a random order
        nextPicIndex = picFileNames.length - 1;  // index for the first picture
        newPic();  // Set up the first picture.
        
        overlayCanvas.setOnMousePressed( this::scratch );
        overlayCanvas.setOnMouseDragged( this::scratch );
        
        StackPane canvasHolder = new StackPane(picCanvas,overlayCanvas);
        canvasHolder.setStyle("-fx-border-color: #444; -fx-border-width:5px");
        
        Button newPicBtn = new Button("New ScratchOff!");
        newPicBtn.setOnAction( e -> newPic() );
        Button showAllBtn = new Button("Show the Whole Picture!");
        showAllBtn.setOnAction( e -> overlayGraphics.clearRect(0,0,width,height) );
        
        ComboBox<String> sizeSelect = new ComboBox<>();
        sizeSelect.getItems().addAll("Small", "Normal", "Big", "Giant");
        sizeSelect.getSelectionModel().select(1);
        scratcherSize = sizes[1];
        sizeSelect.setOnAction( 
                e -> scratcherSize = sizes[ sizeSelect.getSelectionModel().getSelectedIndex() ] );
        
        HBox bottom = new HBox(10,newPicBtn,showAllBtn,    new Label("  Scratcher Size:"), sizeSelect);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding( new Insets(10) );
        
        BorderPane root = new BorderPane(canvasHolder);
        root.setBottom(bottom);
        
        stage.setScene( new Scene(root) );
        stage.setResizable(false);
        stage.setTitle("Scratc Off to Reveal a Picture!");
        stage.show();
        
    }
    
    /**
     * Show the next picture in the picCanvas, and fill the overlay canvas
     * with a random dull color to hide the picture.  Set up nextPicIndex
     * for the next picture.
     */
    private void newPic() {
        overlayGraphics.setFill( Color.hsb(360*Math.random(), 0.5, 0.5) );
        overlayGraphics.fillRect(0,0,width,height);
        picGraphics.drawImage(pictures.get(nextPicIndex),0,0,width,height);
        if (nextPicIndex == 0) {
            Image item0 = pictures.get(0);
            do { // Avoid having the item that is showing now be put
                 // at the end of the list where it will be shown next.
                Collections.shuffle(pictures);
            } while (pictures.get(pictures.size()-1) == item0);
            nextPicIndex = pictures.size() - 1;
        }
        else {
            nextPicIndex--;
        }
    }
    
    /**
     * When the user pressed or drags the mouse, clear a rect in the
     * overlay canvas, with a size given by scratcherSize.
     */
    private void scratch(MouseEvent evt) {
        overlayGraphics.clearRect( evt.getX() - scratcherSize/2, 
                evt.getY() - scratcherSize/2, scratcherSize, scratcherSize );
    }
    
} // end ScratchOff
