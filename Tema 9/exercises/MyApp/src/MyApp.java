import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyApp extends Application {

    private FadeTransition ft;
    private Rectangle rect;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new StackPane();

        var scene = new Scene(root, 1200, 650);

        //Image

        var image = new Image("degradado.jpg");
        var iw = new ImageView(image);
        iw.fitHeightProperty().bind(root.heightProperty());
        iw.fitWidthProperty().bind(root.widthProperty());
        root.getChildren().add(iw);

        //Label

        var lbl = new Label("Form");
        lbl.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
        lbl.setTranslateY(-300);
        lbl.setTranslateX(-540);
        root.getChildren().add(lbl);

        //Checkbox

        var cbox = new CheckBox("Show label");
        cbox.setSelected(true);
        cbox.setTranslateY(-300);
        cbox.setTranslateX(-450);

        cbox.setOnAction((ActionEvent event) -> {
            if (cbox.isSelected()) {
                lbl.setText("Form");
            } else {
                lbl.setText("");
            }
        });

        root.getChildren().add(cbox);

        //Choicebox

        var chbox = new ChoiceBox<>(FXCollections.observableArrayList(
                "Sr.", "Sra."));
        chbox.setTranslateY(-260);
        chbox.setTranslateX(-550);

        var name = new TextField();
        name.setTranslateY(-260);
        name.setTranslateX(-400);
        name.setPrefWidth(200);
        name.setMaxWidth(200);

        SingleSelectionModel<String> model = chbox.getSelectionModel();


        root.getChildren().addAll(chbox,name);

        //Datepicker

        var datePicker = new DatePicker();
        datePicker.setTranslateY(-220);
        datePicker.setTranslateX(-400);

        datePicker.setOnAction(e -> {

            var date = datePicker.getValue();
        });


        var dateLbl = new Label("Birth Date: ");
        dateLbl.setFont(Font.font("Serif", FontWeight.NORMAL, 15));
        dateLbl.setTranslateY(-220);
        dateLbl.setTranslateX(-540);

        root.getChildren().addAll(datePicker,dateLbl);

        //MenuBar

        var box = new HBox();
        box.setTranslateX(-300);

        var mbar = new MenuBar();
        mbar.prefWidthProperty().bind(stage.widthProperty());
        mbar.setTranslateY(-340);

        var handler = new MyMenuHandler();

        var fileMenu = new Menu("File");
        mbar.getMenus().add(fileMenu);

        var nmi = new MenuItem("New");
        nmi.setOnAction(handler);
        fileMenu.getItems().add(nmi);

        var omi = new MenuItem("Open");
        omi.setOnAction(handler);
        fileMenu.getItems().add(omi);

        var smi = new MenuItem("Save");
        smi.setOnAction(handler);
        fileMenu.getItems().add(smi);

        fileMenu.getItems().add(new SeparatorMenuItem());

        var emi = new MenuItem("Exit");
        emi.setOnAction((ActionEvent event) -> Platform.exit());

        fileMenu.getItems().add(emi);

        root.getChildren().add(mbar);

        //ColorPicker and effect

        var txt = new Text("Favorite Colour");
        txt.setTranslateY(-300);
        txt.setTranslateX(500);

        var ref = new Reflection();
        txt.setEffect(ref);

        var font = Font.font(20);
        txt.setFont(font);

        var cp = new ColorPicker();
        cp.setOnAction((ActionEvent event) -> txt.setFill(cp.getValue()));
        cp.setTranslateY(-300);
        cp.setTranslateX(320);

        root.getChildren().addAll(cp, txt);

        //Radio Button

        var radLbl = new Label("Prefered browser: ");
        radLbl.setFont(Font.font("Serif", FontWeight.NORMAL, 15));
        radLbl.setTranslateY(-180);
        radLbl.setTranslateX(-512);

        ToggleGroup group = new ToggleGroup();
        var rd1 = new RadioButton("Chrome");
        rd1.setTranslateY(-180);
        rd1.setTranslateX(-380);
        rd1.setToggleGroup(group);
        rd1.setSelected(true);
        var rd2 = new RadioButton("Mozilla");
        rd2.setTranslateY(-160);
        rd2.setTranslateX(-384);
        rd2.setToggleGroup(group);
        var rd3 = new RadioButton("Edge");
        rd3.setTranslateY(-140);
        rd3.setTranslateX(-390);
        rd3.setToggleGroup(group);
        var rd4 = new RadioButton("Other");
        rd4.setTranslateY(-120);
        rd4.setTranslateX(-388);
        rd4.setToggleGroup(group);

        root.getChildren().addAll(rd1, rd2, rd3, rd4, radLbl);

        //Animation

        rect = new Rectangle(-300, -500, 1200, 550);
        rect.setOnMouseClicked(new RectClickHandler());
        rect.setFill(Color.web("#ed4b00"));

        ft = new FadeTransition(Duration.millis(2500), rect);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);

        root.getChildren().add(rect);

        stage.setTitle("My App");
        stage.setScene(scene);
        stage.show();
    }

    private class MyMenuHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            doShowMessageDialog(event);
        }

        private void doShowMessageDialog(ActionEvent event) {

            var mi = (MenuItem) event.getSource();
            String item = mi.getText();

            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information dialog");
            alert.setHeaderText("Menu item selection information");
            alert.setContentText(item + " menu item selected");

            alert.showAndWait();
        }
    }

    private class RectClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            doHandle();
        }

        private void doHandle() {

            double opa = rect.getOpacity();

            if ((int) opa == 0) {
                return;
            }

            Animation.Status as = ft.getStatus();

            if (as == Animation.Status.RUNNING) {
                return;
            }

            if (as == Animation.Status.STOPPED) {
                ft.play();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}