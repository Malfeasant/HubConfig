package us.malfeasant.templatefx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("HubConfig");
        var labelIp = new Label("IP Address of Hub:");
        var fieldIp = new TextField();
        var buttonConnect = new Button("Connect");
        buttonConnect.setDefaultButton(true);

        var grid = new GridPane();
        grid.addRow(0, labelIp, fieldIp, buttonConnect);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        stage.setScene(new Scene(grid));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}