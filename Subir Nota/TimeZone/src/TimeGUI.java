import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TimeGUI extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        var btn = new Button("Search");
        var tooltip = new Tooltip("Button search");
        Tooltip.install(btn, tooltip);
        btn.setTranslateX(130);
        btn.setTranslateY(80);

        root.getChildren().add(btn);

        var lbl1 = new Label("City : ");
        var lbl2 = new Label("Country : ");

        var fieldCity = new TextField();
        var fieldCountry = new TextField();

        var lbl = new Label("");
        lbl.setFont(Font.font("Serif", FontWeight.NORMAL, 15));
        lbl.setTranslateX(5);
        lbl.setTranslateY(200);
        root.getChildren().add(lbl);

        btn.setOnAction((ActionEvent event) -> {
            String city = fieldCity.getText().isBlank() ? "Jaén": fieldCity.getText();
            String country = fieldCountry.getText().isBlank() ? "España": fieldCountry.getText();
            lbl.setText(GetTimeZone.getString(city,country));
        });

        lbl1.setLabelFor(fieldCity);
        lbl1.setMnemonicParsing(true);
        lbl2.setLabelFor(fieldCountry);
        lbl2.setMnemonicParsing(true);

        root.getChildren().add(lbl1);
        lbl1.setTranslateX(0);
        lbl1.setTranslateY(0);
        root.getChildren().add(fieldCity);
        fieldCity.setTranslateX(70);
        fieldCity.setTranslateY(0);
        root.getChildren().add(lbl2);
        lbl2.setTranslateX(0);
        lbl2.setTranslateY(40);
        root.getChildren().add(fieldCountry);
        fieldCountry.setTranslateX(70);
        fieldCountry.setTranslateY(40);


        var scene = new Scene(root, 350, 300);

        stage.setTitle("GetTime");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
